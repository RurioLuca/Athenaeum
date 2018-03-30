<%--
  Created by IntelliJ IDEA.
  User: Luca
  Date: 27/03/2018
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html>
<head>
    <title>Find Book</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">



</head>
<body>
<div class="container">
    <br/>
    <br/>
    <h1>Cerca il libro per nome</h1>
    <div class="row">
        <form action="/findbook" method="get">
            <input type="text" name="findbyname" value="${book_name}"/>
            <input type="submit" value="CERCA" class="btn btn-success"/>
        </form>
    </div>


    <br/>
    <br/>
    <div class="row">


            <table class="table">
        <form method="post" action="/inserisciLibro">
            <tr>
                <th>
                Nome libro:
                </th>
                <td>
                    <input type="text" name="nome_libro" value="${nome_libro}"/>
                </td>
            </tr>

            <tr>
                <th>
                    Autore:
                </th>
                <td>
                    <input type="text" name="autore" value="${autore}"/>

                </td>
            </tr>
            <tr>
                <th>

                    Data publicazione:
                </th>
                <td>
                    <input type="date" name="date" value="${data}"/>
                </td>
            </tr>

            <tr>
                <th>
                    anno:
                </th>
                <td>
                    <input type="number" name="anno" value="${anno}"/>
                </td>
            </tr>

            <tr>
                <th>
                   <input type="submit" class="btn btn-primary" value="INSERISCI">
                </th>
                <td>
                  <button class="btn btn-warning" type="button" onclick="deleteLibro('${book_id}')">CANCELLA</button>
                </td>
            </tr>
        </form>
        </table>
    </div>

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
<script src="js/findBook.js"></script>

</body>

</html>
