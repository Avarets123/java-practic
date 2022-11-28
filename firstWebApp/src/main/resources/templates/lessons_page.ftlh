<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Страница уроков</title>
</head>
<body>

<table>
    <tr>
        <th>Название урока</th>
        <th>Описание урока</th>
        <th>Начало урока</th>
        <th>Конец урока</th>
    </tr>
    <#list lessons as lesson>
        <tr>
            <td>${lesson.name}</td>
            <td>${lesson.description}</td>
            <td>${lesson.startTime}</td>
            <td>${lesson.finishTime}</td>
            <td>
                <a href="/lessons/${lesson.id}">Перейти</a>
                <a href="/lessons/${lesson.id}/delete">Удалить</a>
            </td>
        </tr>
    </#list>
</table>


<form action="/lessons" method="post">
    <label>
        Название урока
        <input type="text" name="name" placeholder="Введите название урока">
    </label>
    <br>
    <label>
        Описание урока
        <input type="text" name="description" placeholder="Введите описание урока">
    </label>
    <br>
    <label>
        Начало урока
        <input type="text" name="startTime" placeholder="Введите начало урока">
    </label>
    <br>
    <label>
        Конец урока
        <input type="text" name="finishTime" placeholder="Введите конец урока">
    </label>

    <input autofocus type="submit" value="Добавить"/>
</form>


</body>
</html>