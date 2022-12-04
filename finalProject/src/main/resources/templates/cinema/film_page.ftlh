<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Фильм</title>
    <link rel="stylesheet" href="css/style2.css">
</head>
<body>

<#include "../header/header.ftlh" >

<h1 class=cinema>${film.name} </h1>
<#if auth.role.toString() == 'ADMIN'> <a href="/films/${film.id}/delete"> удалить фильм</a> </#if>

<h3>Куплено:</h3>
<#list tickets as ticket >
    <p>Место: ${ticket.place}, ${ticket.film.name}, начало:  ${ticket.film.startTime}, конец:  ${ticket.film.finishTime},

    </p>

</#list>


<h4>Стоимость билета: ${film.amountTicket}</h4>
<h4>Место:</h4>
<form action="/films/${film.id}/buyTicket" method="post">
    <input type="number" name="place">
    <button type="submit"> купить билет</button>
</form>


</body>
</html>