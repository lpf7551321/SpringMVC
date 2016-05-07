<%--
Created by IntelliJ IDEA.
User: miracler
Date: 4/17/16
Time: 4:40 PM
To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<headr>
    <meta charset="UTF-8"/>
    <meta http-equiv="x-ua-compatible" content="IE=edge"/>
    <meta content="width=device-width initial-scale=1" name="viewReport"/>
    <link rel="stylesheet" href="/res/css/bootstrap.min.css"/>
</headr>
<html>
<head>
    <title>success</title>
</head>
<body class="active">
<b>success</b><br>
<table class="table table-bordered table-responsive">
    <thead class="visible-sm-block">
        <tr>
            <th>id</th>
            <th>名字</th>
            <th>年龄</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </tbody>
</table>
<script src="/res/js/bootstrap.min.js" rel="script"/>
</body>
</html>
