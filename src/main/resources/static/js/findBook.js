/**
 * Created by Luca on 27/03/2018.
 */
function deleteLibro(libro_id) {


    console.log("libro id: " + libro_id);

    if (libro_id == null || libro_id == "") {
        alert("ricerca prima un libro");
        return;
    }

    $.ajax({
        url: '/books/delete/' + libro_id,
        type: 'DELETE',
        success: function (result) {

            alert(result.message);
            console.log(result.message);
            console.log(result["message"]);

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });


}