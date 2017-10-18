<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form name="user" action="/updateUser" method="post">
    <p>Id:</p>
    <input title="Id" type="number" name="id" value="${user.id}"
    <p>Name:</p>
    <input title="Name" type="text" name="name" value="${user.name}">
    <p>Email:</p>
    <input title="Email" type="email" name="email" value="${user.email}">
    <p>Age:</p>
    <input title="Age" type="number" name="age" value="${user.age}">
    <input type="submit" value="OK">
</form>

</body>
</html>