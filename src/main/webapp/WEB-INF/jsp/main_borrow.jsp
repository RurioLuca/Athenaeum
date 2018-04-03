<%--
  Created by IntelliJ IDEA.
  User: Luca
  Date: 03/04/2018
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Gestione Prestiti</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<div class="container">
    <div class="row">
        <h1>Gestisci i prestiti</h1>
    </div>

    <div class="row">
        <h3>Aggiunti un prestito</h3>
    </div>

    <div class="row">
        <table class="table">
            <form method="post" action="/addBorrow">

                <tr>

                    <th>Utente:</th>

                    <td>
                        <select name="user">
                            <c:forEach items="${users_list}" var="user">
                                <option value="${user.utente_id}">${user.nome}</option>
                            </c:forEach>
                        </select>

                    </td>

                </tr>

                <tr>

                    <th>Libro:</th>

                    <td>
                        <select name="book">
                            <c:forEach items="${book_list}" var="book">
                                <option value="${book.libro_id}">${book.nome}</option>
                            </c:forEach>
                        </select>

                    </td>

                </tr>


                <tr>

                    <th>Cliente:</th>

                    <td>
                        <select name="client">
                            <c:forEach items="${client_list}" var="client">
                                <option value="${client.cliente_id}">${client.nome}</option>
                            </c:forEach>
                        </select>

                    </td>

                </tr>

                <tr>

                    <th>Durata prestito:</th>

                    <td>
                        <input type="number" name="durata" value="30"/> <label> Giorni</label>
                    </td>

                </tr>
                <tr>
                    <td colspan="2"><input class="btn btn-success" type="submit" value="SALVA"></td>
                </tr>

            </form>
        </table>

        <!-- FROM INSERIMENTO PRESTITO -->

    </div>


    <div class="row">
        <h3>Lista dei prestiti</h3>
    </div>

    <c:forEach begin="0" end="${size}" varStatus="status">
        <div class="row" style="cursor: pointer"
             onclick="window.location.href='/borrowDetail?borrow_id=${borrow_list[status.index].prestito_id}'">
            <ul>
                <li>Nome Utente: ${borrow_list[status.index].user.nome}</li>
                <li>Nome Libro: ${borrow_list[status.index].book.nome}</li>
                <li>Nome Cliente: ${borrow_list[status.index].client.nome}</li>
                <li>Durata Prestito: ${borrow_list[status.index].durata_prestito} Giorni</li>
                <li>Stato Prestito: ${borrow_list[status.index].stato_prestito}</li>
            </ul>

        </div>
        <hr>
    </c:forEach>

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


</body>
</html>
