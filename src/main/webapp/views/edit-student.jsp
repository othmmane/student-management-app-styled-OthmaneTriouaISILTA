<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>✏️ Edit Student</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f0f4f8;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 40px 20px;
        }
        .card {
            background: #fff;
            border-radius: 16px;
            box-shadow: 0 4px 20px rgba(0,0,0,0.10);
            padding: 40px;
            width: 100%;
            max-width: 480px;
        }
        h1 { font-size: 1.6rem; color: #1a202c; margin-bottom: 24px; }
        .form-group { margin-bottom: 20px; }
        label { display: block; font-size: 0.9rem; font-weight: 600; color: #374151; margin-bottom: 6px; }
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 11px 14px;
            border: 1.5px solid #d1d5db;
            border-radius: 8px;
            font-size: 0.95rem;
            outline: none;
            transition: border-color 0.2s;
            color: #1a202c;
        }
        input:focus { border-color: #0ea5e9; }
        .error {
            background: #fee2e2;
            color: #b91c1c;
            border-radius: 8px;
            padding: 10px 14px;
            margin-bottom: 20px;
            font-size: 0.9rem;
        }
        .btn {
            padding: 11px 22px;
            border-radius: 8px;
            font-size: 0.95rem;
            font-weight: 600;
            text-decoration: none;
            border: none;
            cursor: pointer;
            transition: opacity 0.2s, transform 0.1s;
            display: inline-flex;
            align-items: center;
            gap: 6px;
        }
        .btn:hover { opacity: 0.88; transform: translateY(-1px); }
        .btn-update    { background: #0ea5e9; color: #fff; }
        .btn-secondary { background: #e2e8f0; color: #374151; }
        .btn-row { display: flex; gap: 12px; align-items: center; margin-top: 8px; flex-wrap: wrap; }
    </style>
</head>
<body>
<div class="card">
    <h1>✏️ Edit Student</h1>

    <% if (request.getAttribute("error") != null) { %>
        <div class="error">⚠️ <%= request.getAttribute("error") %></div>
    <% } %>

    <form action="${pageContext.request.contextPath}/students/edit" method="post">
        <input type="hidden" name="id" value="${student.id}">
        <div class="form-group">
            <label>👤 First Name</label>
            <input type="text" name="firstName" value="${student.firstName}" required>
        </div>
        <div class="form-group">
            <label>👤 Last Name</label>
            <input type="text" name="lastName" value="${student.lastName}" required>
        </div>
        <div class="form-group">
            <label>📧 Email</label>
            <input type="email" name="email" value="${student.email}" required>
        </div>
        <div class="btn-row">
            <button type="submit" class="btn btn-update">✅ Update</button>
            <a href="${pageContext.request.contextPath}/students" class="btn btn-secondary">↩️ Back to list</a>
        </div>
    </form>
</div>
</body>
</html>
