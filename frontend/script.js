document.addEventListener("DOMContentLoaded", function () {
    const apiTableBody = document.getElementById("apiTableBody");
    const addApiForm = document.getElementById("addApiForm");

    // 后端 API 地址
    const API_BASE_URL = "http://localhost:8080/api/monitor";

    // 获取 API 列表
    function fetchApis() {
        fetch(`${API_BASE_URL}/list/1`)
            .then(response => response.json())
            .then(data => {
                apiTableBody.innerHTML = "";
                data.forEach(api => {
                    api.status = 1;
                    const row = document.createElement("tr");
                    row.innerHTML = `
                        <td><a href="monitoring_logs.html?apiId=${api.id}&name=${encodeURIComponent(api.name)}&url=${api.url}">${api.name}</a></td>
                        <td>${api.url}</td>
                        <td class="status">${api.status ? "✅ 正常" : "❌ 异常"}</td>
                        <td>
                            <button class="delete-btn" data-id="${api.id}"><i class="fas fa-trash"></i> 删除</button>
                        </td>
                    `;
                    apiTableBody.appendChild(row);
                });
            })
            .catch(error => console.error("获取 API 失败:", error));
    }

    // 监听表单提交事件，添加 API
    addApiForm.addEventListener("submit", function (event) {
        event.preventDefault();
        const apiName = document.getElementById("apiName").value;
        const apiUrl = document.getElementById("apiUrl").value;

        fetch(`${API_BASE_URL}/add`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name: apiName, url: apiUrl, userId:1, checkInterval: 60, timeout: 5})
        })
            .then(response => {
                if (response.ok) {
                    fetchApis();
                    addApiForm.reset();
                } else {
                    console.error("添加 API 失败");
                }
            })
            .catch(error => console.error("请求错误:", error));
    });

    // 监听删除 API 事件
    apiTableBody.addEventListener("click", function (event) {
        if (event.target.classList.contains("delete-btn")) {
            const apiId = event.target.getAttribute("data-id");

            fetch(`${API_BASE_URL}/delete/${apiId}`, { method: "DELETE" })
                .then(response => {
                    if (response.ok) {
                        fetchApis();
                    } else {
                        console.error("删除 API 失败");
                    }
                })
                .catch(error => console.error("请求错误:", error));
        }
    });

    // 初始化获取 API 列表
    fetchApis();
});
