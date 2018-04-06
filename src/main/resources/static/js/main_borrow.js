/**
 * Created by Luca on 27/03/2018.
 */
function deleteBorrow(borrow_id) {


    console.log("borrow_id id: " + borrow_id);


    $.ajax({
        url: '/borrow/delete/' + borrow_id,
        type: 'DELETE',
        success: function (result) {

            alert(result.message);
            console.log(result.message);
            console.log(result["message"]);
            window.location.href = "/mainBorrow";
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });


}