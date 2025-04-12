document.addEventListener("DOMContentLoaded", function () {
    const logsTableBody = document.getElementById("logTableBody");
    const pageTitle = document.getElementById("pageTitle");
    const apiInfo = document.getElementById("apiInfo");

    // 从 URL 中解析参数
    const urlParams = new URLSearchParams(window.location.search);
    const apiId = urlParams.get("apiId");
    const apiName = decodeURIComponent(urlParams.get("name") || "");

    // 修改标题显示
    pageTitle.textContent = `API 日志 - ${apiName}`;
    apiInfo.textContent = `监控日志：${apiName}`;

    function fetchMonitoringLogs() {
        if (!apiId) {
            console.error("缺少 apiId 参数");
            return;
        }

        fetch(`http://localhost:8080/api/logs/recent/${apiId}`) // 修改为你实际的后端接口
            .then(response => response.json())
            .then(data => {
                logsTableBody.innerHTML = "";
                data.forEach(log => {
                    const row = document.createElement("tr");
                    row.innerHTML = `
                        <td>${apiName}</td>
                        <td>${log.apiUrl}</td>
                        <td>${log.statusCode}</td>
                        <td>${log.responseTime} ms</td>
                        <td>${new Date(log.checkedAt).toLocaleString()}</td>
                    `;
                    logsTableBody.appendChild(row);
                });
            })
            .catch(error => console.error("获取日志失败:", error));
    }

    fetchMonitoringLogs();
    setInterval(fetchMonitoringLogs, 30000);

    function checkAlerts() {
        fetch(`http://localhost:8080/api/alerts/recent/${apiId}`) // 1是 userId，根据实际修改
            .then(response => response.json())
            .then(data => {
                data.forEach(alert => {
                    if (!alert._shown) { // 简单防抖处理
                        alert._shown = true;
                        alertUser(alert);
                    }
                });
            })
            .catch(error => console.error("获取告警失败:", error));
    }

    function alertUser(alert) {
        const message = `⚠️ API 调用失败\n名称: ${alert.apiName}\nURL: ${alert.apiUrl}\n时间: ${new Date(alert.triggeredAt).toLocaleString()}\n信息: ${alert.message}`;
        alert(message);
    }

    // 每 30 秒轮询
    setInterval(checkAlerts, 30000);
});
