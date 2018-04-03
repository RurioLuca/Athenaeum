<%--
  Created by IntelliJ IDEA.
  User: Luca
  Date: 30/03/2018
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Gestione Utenti</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


</head>
<body>
<div class="container">
    <br/>
    <br/>
    <h1>Cerca utente per nome o cognome</h1>
    <div class="row">
        <form action="/mainUsers" method="get">
            <input type="text" name="search_field" value="${search_field}"/>
            <input type="submit" value="CERCA" class="btn btn-success"/>
        </form>
    </div>


    <br/>
    <br/>

    <div class="row">
        <c:choose>
            <c:when test="${not empty is_exist_user}">
                <table class="table">
                    <form:form method="post" action="/updateUsers" modelAttribute="user_form">
                        <form:input type="text" path="user_id" cssStyle="visibility: hidden;"/>
                        <tr>
                            <th>
                                Nome:
                            </th>
                            <td>
                                <form:input type="text" path="name"/>
                            </td>
                        </tr>

                        <tr>
                            <th>
                                Cognome:
                            </th>
                            <td>
                                <form:input type="text" path="surname"/>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                Matricola:
                            </th>
                            <td>
                                <form:input type="text" path="registrationNumber" readonly="true" />
                            </td>
                        </tr>

                        <tr>
                            <th>
                                <input type="submit" class="btn btn-primary" value="MODIFICA">
                            </th>
                            <td>
                                <button class="btn btn-warning" type="button" onclick="deleteUser('${user_id}')">
                                    CANCELLA
                                </button>
                            </td>
                        </tr>
                    </form:form>
                </table>
            </c:when>
            <c:otherwise>
                <p>${message}</p>
                <button class="btn" onclick="window.location.href='/addUser'">Aggiungi nuovo utente</button>
            </c:otherwise>
        </c:choose>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="js/main_users.js"></script>
</body>
</html>
