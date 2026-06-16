<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>🎓 Student Management App</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(135deg, #4f46e5 0%, #0ea5e9 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .card {
            background: #fff;
            border-radius: 20px;
            box-shadow: 0 8px 40px rgba(0,0,0,0.18);
            padding: 52px 48px;
            text-align: center;
            max-width: 420px;
            width: 100%;
        }
        .icon { font-size: 3.5rem; margin-bottom: 16px; }
        h1 { font-size: 1.8rem; color: #1a202c; margin-bottom: 10px; }
        p  { color: #6b7280; font-size: 0.95rem; margin-bottom: 32px; line-height: 1.6; }
        .btn {
            display: inline-flex;
            align-items: center;
            gap: 8px;
            padding: 14px 32px;
            background: #4f46e5;
            color: #fff;
            border-radius: 10px;
            font-size: 1rem;
            font-weight: 700;
            text-decoration: none;
            transition: opacity 0.2s, transform 0.1s;
        }
        .btn:hover { opacity: 0.88; transform: translateY(-2px); }
        .stack {
            margin-top: 28px;
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 8px;
        }
        .tag {
            background: #ede9fe;
            color: #6d28d9;
            border-radius: 20px;
            padding: 4px 12px;
            font-size: 0.78rem;
            font-weight: 600;
        }
    </style>
</head>
<body>
<div class="card">
    <div class="icon">🎓</div>
    <h1>Student Management App</h1>
    <p>A mini JEE CRUD project — manage students with ease.</p>
    <a href="${pageContext.request.contextPath}/students" class="btn">📋 View Students</a>
    <div class="stack">
        <span class="tag">Servlet</span>
        <span class="tag">JSP + JSTL</span>
        <span class="tag">DAO Pattern</span>
        <span class="tag">JDBC</span>
        <span class="tag">MySQL</span>
        <span class="tag">Tomcat 10</span>
        <span class="tag">Docker</span>
    </div>
</div>
</body>
</html>
