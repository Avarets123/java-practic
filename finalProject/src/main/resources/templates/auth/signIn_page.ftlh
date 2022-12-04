<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Авторизация</title>
    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="registration-cssave">
    <form action="/signIn" method="post">
        <h3 class="text-center">Форма авторизации</h3>

        <div class="form-group">
            <input class="form-control item" type="email" name="email" id="email" placeholder="Email">
        </div>
        <div class="form-group">
            <input class="form-control item" type="password" name="password"  id="password"
                   placeholder="Пароль" >
        </div>

        <div class="form-group">
            <button class="btn btn-primary btn-block create-account" type="submit">Вход в аккаунт</button>
        </div>
    </form>
</div>

</body>
</html>