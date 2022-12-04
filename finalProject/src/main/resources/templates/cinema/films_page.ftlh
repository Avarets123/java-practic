<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Кинотеатр</title>
    <link rel="stylesheet" href="css/style2.css">
</head>
<body>

<#include "../header/header.ftlh">

<h1 class=cinema>Кинотеатр</h1>
<h2 class=film>Фильмы</h2>
<#list films as films >
    <p>Название фильма: ${films.name}, начало: ${films.startTime}, конец: ${films.finishTime}, стоимость
        билета: ${films.amountTicket} <a
                href="/films/${films.id}">перейти</a></p>
</#list>

<#if role == 'ADMIN' >

    <form action="/films" method="post">
        <input type="text" name="name" placeholder="название фильма">
        <#--            <input type="text" name="day" placeholder="дата формат гггг-мм-дд">-->
        <input type="time" name="startTime">
        <input type="time" name="finishTime">
        <input type="number" placeholder="стоимость билета" name="amountTicket">
        <button type="submit"> Добавить</button>
    </form>

</#if>


</body>
</html>