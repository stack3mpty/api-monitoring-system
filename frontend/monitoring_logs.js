document.addEventListener("DOMContentLoaded", function () {
    const logsTableBody = document.getElementById("logTableBody");

    function fetchMonitoringLogs() {
        fetch("http://localhost:8080/api/logs/recent/3") // 替换成实际后端 API 地址
            .then(response => response.json())
            .then(data => {
                logsTableBody.innerHTML = "";
                data.forEach(log => {
                    console.log(log)
                    const row = document.createElement("tr");
                    row.innerHTML = `
                        <td>${log.apiName}</td>
                        <td>${log.apiUrl}</td>
                        <td>${log.statusCode}</td>
                        <td>${log.responseTime} ms</td>
                        <td>${new Date(log.checkedAt).toLocaleString()}</td>
                    `;
                    logsTableBody.appendChild(row);
                });
            })
            .catch(error => console.error("Error fetching logs:", error));
    }

    // 初次加载数据
    fetchMonitoringLogs();

    // 每 30 秒刷新一次数据
    setInterval(fetchMonitoringLogs, 30000);
});
