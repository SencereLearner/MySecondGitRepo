(function ($) {
   $('#user-loging').click(function (evt) {
        evt.preventDefault();
        var username = $("#login").val();
        var password = $("#password").val();
        debugger;
        var result = window.api.login(username, password);
        if(result !== undefined)
        {
            window.location = "./src/home.html";
            window.reload();
        }        
   });
})(jQuery)