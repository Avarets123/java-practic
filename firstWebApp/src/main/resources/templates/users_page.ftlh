<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователи</title>
</head>
<body>
<table>
    <tr>
        <th>Email</th>
    </tr>
    <#list users as user>
        <tr>
            <td><a href="/users/${user.id}">${user.email}</a></td>
        </tr>
    </#list>
</table>
<form action="/users" method="post">
    <label>
        Email
        <input type="email" name="email" placeholder="Введите почту">
    </label>
    <br>
    <label>
        Пароль
        <input type="password" name="password" placeholder="Введите пароль">
    </label>
    <br>
    <label>
        Описание
        <input type="text" name="description" placeholder="Введите описание">
    </label>
    <input autofocus type="submit" value="Добавить"/>
</form>
</body>
</html>