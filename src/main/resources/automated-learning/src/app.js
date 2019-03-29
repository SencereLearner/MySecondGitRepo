(function ($) {
    window.api.setupUsers();
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
    window.ForgotPassword = function (event) {
        var login = $("#login").val();
        var user = window.api.getUserByLogin(login);
        if(user!==undefined)
        {
            confirm(`Username: ${user.username} Password: ${user.password}`);
        }

        return false;
    };

    window.RegisterUser = function (event) {
        var login = $("#login").val();
        var password = $("#password").val();
        var user = window.api.register(login, password);
        if(user===undefined)
        {
            confirm(`Username is already taken`);
        }
        window.location = "./index.html";
        return false;
    };
})(jQuery);