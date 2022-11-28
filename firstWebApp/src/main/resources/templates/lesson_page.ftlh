<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Страница урока</title>
</head>
<body>
<h1>${lesson.name}</h1>
<h3>${lesson.description}</h3>
<table>
    <tr>
        <th>Название урока</th>
        <th>Описание урока</th>
        <th>Начало урока</th>
        <td>Конец урока</td>
    </tr>
    <tr>
        <td>${lesson.name}</td>
        <td>${lesson.description}</td>
        <td>${lesson.startTime}</td>
        <td>${lesson.finishTime}</td>
    </tr>
</table>


<form action="/lessons/${lesson.id}/update" method="post">
    <label>
        <input type="text" name="name" value=${lesson.name}>
    </label>
    <br>
    <label>
        <input type="text" name="description" value=${lesson.description}>
    </label>
    <br>
    <label>
        <input type="text" name="startTime" value=${lesson.startTime}>
    </label>
    <label>
        <input type="text" name="finishTime" value=${lesson.finishTime}>
    </label>
    <br>
    <input type="submit" value="Сохранить">
</form>
</body>
</html>