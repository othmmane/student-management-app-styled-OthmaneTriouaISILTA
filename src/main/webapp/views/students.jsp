<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>🎓 Students</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f0f4f8;
            min-height: 100vh;
            padding: 40px 20px;
        }
        .container {
            max-width: 900px;
            margin: 0 auto;
        }
        h1 {
            font-size: 2rem;
            color: #1a202c;
            margin-bottom: 24px;
        }
        .nav-bar {
            display: flex;
            gap: 12px;
            margin-bottom: 28px;
            flex-wrap: wrap;
        }
        .btn {
            padding: 10px 20px;
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
        .btn-primary   { background: #4f46e5; color: #fff; }
        .btn-secondary { background: #e2e8f0; color: #374151; }
        .btn-edit      { background: #0ea5e9; color: #fff; font-size: 0.85rem; padding: 6px 14px; }
        .btn-delete    { background: #ef4444; color: #fff; font-size: 0.85rem; padding: 6px 14px; }

        .card {
            background: #fff;
            border-radius: 14px;
            box-shadow: 0 2px 12px rgba(0,0,0,0.08);
            overflow: hidden;
        }
        table { width: 100%; border-collapse: collapse; }
        thead tr { background: #4f46e5; color: #fff; }
        thead th { padding: 14px 18px; text-align: left; font-weight: 600; font-size: 0.9rem; }
        tbody tr { border-bottom: 1px solid #e2e8f0; transition: background 0.15s; }
        tbody tr:last-child { border-bottom: none; }
        tbody tr:hover { background: #f8fafc; }
        td { padding: 14px 18px; color: #374151; font-size: 0.95rem; }
        .actions { display: flex; gap: 8px; align-items: center; }

        .empty-state {
            text-align: center;
            padding: 60px 20px;
            color: #9ca3af;
        }
        .empty-state .icon { font-size: 3rem; margin-bottom: 12px; }
        .empty-state p { font-size: 1.1rem; }

        .badge-id {
            background: #ede9fe;
            color: #6d28d9;
            border-radius: 20px;
            padding: 2px 10px;
            font-size: 0.85rem;
            font-weight: 700;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>🎓 Student Management</h1>

    <div class="nav-bar">
        <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">🏠 Home</a>
        <a href="${pageContext.request.contextPath}/students/add" class="btn btn-primary">➕ Add Student</a>
    </div>

    <div class="card">
        <c:choose>
            <c:when test="${empty students}">
                <div class="empty-state">
                    <div class="icon">🗂️</div>
                    <p>No students found. Add one!</p>
                </div>
            </c:when>
            <c:otherwise>
                <table>
                    <thead>
                        <tr>
                            <th>#️⃣ ID</th>
                            <th>👤 First Name</th>
                            <th>👤 Last Name</th>
                            <th>📧 Email</th>
                            <th>⚙️ Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td><span class="badge-id">${student.id}</span></td>
                                <td>${student.firstName}</td>
                                <td>${student.lastName}</td>
                                <td>${student.email}</td>
                                <td>
                                    <div class="actions">
                                        <a href="${pageContext.request.contextPath}/students/edit?id=${student.id}" class="btn btn-edit">✏️ Edit</a>
                                        <form action="${pageContext.request.contextPath}/students/delete" method="post">
                                            <input type="hidden" name="id" value="${student.id}">
                                            <button type="submit" class="btn btn-delete" onclick="return confirm('🗑️ Delete this student?')">🗑️ Delete</button>
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
