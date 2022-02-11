<!DOCTYPE html>
<html  lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Регистратсия</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">

</head>

<body>
    <form name="user" action="/user/register" method="POST">
    <p>Имя</p>
    <input title="Name" type="text" name="username"><br>
    <input title="Name" type="text" name="password"><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="OK">
    </form>

</body></html>