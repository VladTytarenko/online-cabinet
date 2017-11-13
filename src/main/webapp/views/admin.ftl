<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
</head>
<body>
    <div class="container">
        <form id="logoutForm" method="post" action="/logout">
            <input type="hidden" name="${user.name}" value="${user.name}"/>
        </form>
        <h2>Admin Page</h2>
    </div>
</body>
</html>