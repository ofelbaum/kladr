<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="../resources/style.css" type="text/css" media="screen"/>
</head>
<body>
<div align="center">
    <h2>Restricted Area</h2>
    <form action="/admin/j_spring_security_check" method="post">
        <table class="login">
            <tr>
                <td>
                    User
                </td>
                <td>
                    <input name="j_username" type="text">
                </td>
            </tr>
            <tr>
                <td>
                    Password
                </td>
                <td>
                    <input type="password" name="j_password"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" value="login" class="app-button app-button-submit">Login</button>
                <td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>