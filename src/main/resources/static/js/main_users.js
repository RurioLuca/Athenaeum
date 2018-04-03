/**
 * Created by Luca on 27/03/2018.
 */
function deleteUser(user_id) {


    console.log("user_id id: " + user_id);

    if (user_id == null || user_id == "") {
        alert("ricerca un utente");
        return;
    }

    $.ajax({
        url: '/users/delete/' + user_id,
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