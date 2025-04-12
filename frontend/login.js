document.getElementById("loginForm").addEventListener("submit", async function (e) {
    e.preventDefault();

    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();

    if (!username || !password) {
        showMessage("请输入用户名和密码", true);
        return;
    }

    try {
        const response = await fetch("http://localhost:8080/api/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ username, password })
        });

        const result = await response.json();

        if (response.ok) {
            localStorage.setItem("token", result.token);
            window.location.href = "monitor_api.html"; // 登录成功后跳转
        } else {
            console.error("登录失败:", result.message);
            showMessage(result.message || "登录失败", true);
        }
    } catch (error) {
        showMessage("网络错误，请稍后再试", true);
        console.error("Login error:", error);
    }
});

function showMessage(msg, isError) {
    const messageDiv = document.getElementById("error-message");
    messageDiv.textContent = msg;
    messageDiv.className = isError ? "error" : "success";
    messageDiv.style.display = "block";
}
