<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователи</title>
</head>
<body>

<#include "../header/header.ftlh">

<h1>Все пользователи</h1>
    <#list users as users>
        <h4>Email: ${users.email}, роль: ${users.role} <a href="/users/${users.id}/delete"> удалить</a> </h4>
    </#list>
</body>
</html>