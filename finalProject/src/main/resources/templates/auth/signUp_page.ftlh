<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Регистрация</title>
    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="registration-cssave">
    <form action="/signUp" method="post">
        <h3 class="text-center">Форма регистрации</h3>

        <div class="form-group">
            <input class="form-control item" type="email" name="email" id="email" placeholder="Email">
        </div>
        <div class="form-group">
            <input class="form-control item" type="password" name="password"  id="password"
                   placeholder="Пароль" >
        </div>

        <div class="form-group">
            <label>Роль
                <select name="role">
                        <option value="USER"> Пользователь</option>
                        <option value="ADMIN"> Администратор</option>
                </select>
            </label>

        </div>
        <div class="form-group">
            <button class="btn btn-primary btn-block create-account" type="submit">Создать</button>
        </div>
    </form>
</div>

</body>
</html>