<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Профиль</title>
</head>
<body>
    <#include "../header/header.ftlh" >


    <h2>Мои билеты</h2>

    <#list profile.tickets as tickets >
        <p>Название фильма: ${tickets.film.name}, начало: ${tickets.film.startTime}, конец: ${tickets.film.finishTime},
            место в зале: ${tickets.place}, стоимость билета: ${tickets.film.amountTicket} </p>
    </#list>

</body>
</html>