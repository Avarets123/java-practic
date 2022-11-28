<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Страница курсов</title>
</head>
<body>

<table>
    <tr>
        <th>Название курса</th>
        <th>Описание курса</th>
        <th>Начало курса</th>
        <th>Конец курса</th>
    </tr>
    <#list courses as course>
        <tr>
            <td>${course.title}</td>
            <td>${course.description}</td>
            <td>${course.start}</td>
            <td>${course.finish}</td>
            <td>
                <a href="/courses/${course.id}">Перейти</a>
                <a href="/courses/${course.id}/delete">Удалить</a>
            </td>
        </tr>
    </#list>
</table>


<form action="/courses" method="post">
    <label>
        Название курса
        <input type="text" name="title" placeholder="Введите название курса">
    </label>
    <br>
    <label>
        Описание курса
        <input type="text" name="description" placeholder="Введите описание курса">
    </label>
    <br>
    <label>
        Начало курса
        <input type="text" name="start" placeholder="Введите начало курса">
    </label>
    <br>
    <label>
        Конец курса
        <input type="text" name="finish" placeholder="Введите конец курса">
    </label>

    <input autofocus type="submit" value="Добавить"/>
</form>


</body>
</html>