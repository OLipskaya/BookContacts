
function createPhone(){
    $(document).ready(function(){
        var line = "<div class='row'>"+$("#phone_form").html()+"</div><br>";
        $("#butt_phone").before(line);
    });
}

function createAddress(){
    $(document).ready(function(){
        var line = "<div class='row'>"+$("#addr_form").html()+"</div><br>";
        $("#butt_addr").before(line);
    });
}

function createMail(){
    $(document).ready(function(){
        var line = "<div class='row'>"+$("#form_mail").html()+"</div><br>";
        $("#mail_butt").before(line);
    });
}