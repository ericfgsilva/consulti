<html>
    <head>
        <title>Sistema de Consultório Médico</title>
        <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" />
        <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'sb-admin.css')}" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
        <link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
        <link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Acesso ao sistema</h3>
                        </div>
                        <div class="panel-body">
                            <form autocomplete="off" action="j_spring_security_check" method="post">
                                <div class="form-group">
                                    <label>Login</label>
                                    <input id="generic_loginPage_txtUsuario" type="text" name="j_username" autocomplete="off" class="form-control" autofocus /> </div>
                                <div class="form-group">
                                    <label>Senha</label>
                                    <input id="generic_loginPage_txtSenha" type="password" name="j_password" autocomplete="off" class="form-control" />
                                </div>
                                <input name="generic_loginPage_btnLogin" class="btn btn-lg btn-success btn-block" type="submit" value="Login"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>