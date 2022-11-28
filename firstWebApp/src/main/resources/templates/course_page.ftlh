<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Курс</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>${course.title}</h1>
<h2>Студенты в курсе</h2>
<table>
    <tr>
        <th>Email</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <td>Действия</td>
    </tr>
    <#list inCourseStudents as student>
        <tr>
            <td>${student.email}</td>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>
                <a href="/users/${student.id}">Перейти</a>
            </td>
        </tr>
    </#list>
</table>
<form action="/courses/${course.id}/students" method="post">
    <label>Студенты
        <select name="student-id">
            <#list notInCourseStudents as student>
                <option value="${student.id}">${student.firstName} ${student.lastName}</option>
            </#list>
        </select>
    </label>
    <input type="submit" value="Добавить">
</form>


<br>
<br>

<form action="/courses/${course.id}/lesson" method="post">
    <label> Уроки
        <select name="lesson-id">
            <#list allLessons as lesson>
                <option value="${lesson.id}">${lesson.name} ${lesson.description}</option>
            </#list>
        </select>
    </label>
    <input type="submit" value="Добавить">
</form>


<table>
    <tr>
        <th>Название урока</th>
        <th>Описание урока</th>
        <th>Начало урока</th>
        <td>Конец урока</td>
    </tr>

    <#list lessonsInCourse as lesson >
        <tr>
            <td>${lesson.name}</td>
            <td>${lesson.description}</td>
            <td>${lesson.startTime}</td>
            <td>${lesson.finishTime}</td>
        </tr>
    </#list>

</table>
</body>
</html>