var uEnteredName = prompt("Please Enter Your Name");

$("#chat_Header").html(uEnteredName);

$("#msg").focus();

function saveChats() {
    var uName = $("#chat_Header").html();
    if (uName == '') {
        alert('Please enter your name ');
        return false;
    }
    var msg = $("#msg").val();
    //var oldMsg = $("#chat-area").html();
    var colorCode = $('input[name=nameColor]:checked', '#send-message-area')
        .val();

    $.ajax({
        type: "POST",
        data: "uName=" + uName + "&msg=" + msg + "&colorCode="
        + colorCode,
        url: "Chatprocess.do",
        error: function (xhr, ajaxOptions, thrownError) {
            alert(xhr.status);
            alert(thrownError);
        },
        success: function (data) {
            $("#chat-area").html(data);
            $("#ChatAtBigScreen").html(data);
            document.getElementById('chat-area').scrollTop = document.getElementById('chat-area').scrollHeight;
            document.getElementById('ChatAtBigScreen').scrollTop = document.getElementById('ChatAtBigScreen').scrollHeight;
        }
    });
    return false;
}
$('#msg').keyup(function (e) {

    if (e.keyCode == 13) {
        saveChats();
        $("#msg").val('');
    }
});