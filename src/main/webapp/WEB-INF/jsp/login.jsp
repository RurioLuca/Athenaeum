<%--
  Created by IntelliJ IDEA.
  User: Luca
  Date: 30/03/2018
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi Utente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <br/>
    <br/>
    <h1>Login</h1>
    <div class="row">
        ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </div>
    <div class="row">
        <table class="table">
            <form method="post" action="/j_spring_security_check">
                <tr>
                    <th>
                        Matricola :
                    </th>
                    <td>
                        <input type="text" name="username"/>
                    </td>
                </tr>

                <tr>
                    <th>
                        Password :
                    </th>
                    <td>
                        <input type="password" name="password"/>
                    </td>
                </tr>


                <tr>
                    <td colspan="2" style="text-align: center">
                        <input type="submit" class="btn btn-success" value="ACCEDI">
                    </td>
                </tr>
            </form>
        </table></div>
</div>
</body>

</html>
