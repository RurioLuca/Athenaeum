<%--
  Created by IntelliJ IDEA.
  User: Luca
  Date: 03/04/2018
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dettaglio Prestito</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<div class="container">

    <div class="row">
        <h1>Dettaglio prestito</h1>
    </div>

    <div class="row">
        <table class="table">
            <form:form method="post" action="/updateBorrow" modelAttribute="borrow_form">
                <form:input type="text" path="borrow_id" cssStyle="visibility: hidden;"/>
                <tr>
                    <th>
                        Nome Utente:
                    </th>
                    <td>
                        <form:input type="text" path="nomeUtente"/>
                    </td>
                </tr>

                <tr>
                    <th>
                        Nome Cliente:
                    </th>
                    <td>
                        <form:input type="text" path="nomeCliente"/>
                    </td>
                </tr>

                <tr>
                    <th>
                        Nome Libro:
                    </th>
                    <td>
                        <form:input type="text" path="nomeLibro"/>
                    </td>
                </tr>

                <tr>
                    <th>
                        Durata Prestito:
                    </th>
                    <td>
                        <form:input type="number" path="durataPrestito"/>
                    </td>
                </tr>

                <tr>
                    <th>
                        Stato Prestito:
                    </th>
                    <td>
                        <form:input type="text" path="stato_prestito"/>
                    </td>
                </tr>

                <tr>
                    <th>
                        Data Prestito:
                    </th>
                    <td>
                        <form:input type="date" path="data_prestito"/>
                    </td>
                </tr>
                <tr>
                    <th>
                        Data Scadenza:
                    </th>
                    <td>
                        <form:input type="date" path="data_scadenza"/>
                    </td>
                </tr>
                <tr>
                    <th>
                        <input type="submit" class="btn btn-primary" value="MODIFICA">
                    </th>
                    <td>
                        <button class="btn btn-warning" type="button" onclick="deleteBorrow('${user_id}')">
                            CANCELLA
                        </button>
                    </td>
                </tr>
            </form:form>
        </table>
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

<script src="js/main_borrow.js"></script>
</body>
</html>
