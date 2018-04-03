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
    <h1>Inserisci un nuovo utente</h1>
<div class="row">
        <table class="table">
        <form method="post" action="/addUser">
            <tr>
                <th>
                    Nome:
                </th>
                <td>
                    <input type="text" name="name"/>
                </td>
            </tr>

            <tr>
                <th>
                    Cognome:
                </th>
                <td>
                    <input type="text" name="surname"/>
                </td>
            </tr>


            <tr>
                <td colspan="2" style="text-align: center">
                    <input type="submit" class="btn btn-primary" value="INSERISCI">
                </td>
            </tr>
        </form>
</div>
</div>
</body>

</html>
