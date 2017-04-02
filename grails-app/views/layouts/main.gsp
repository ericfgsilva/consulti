<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- /Biblioteca -->
        <title>ConsulTI - MED</title>
        <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />

        <g:render template="/layouts/baseCSS" />

        <title><g:layoutTitle default="Grails"/></title>
        <g:layoutHead/>
        <%
            response.setHeader("Cache-Control","no-cache");
            response.setHeader("Cache-Control","no-store");
            response.setDateHeader("Expires", 0);
            response.setHeader("Pragma","no-cache");
        %>
    </head>
    <body ng-app="Consultorio" >
        <!-- begin #page-loader -->
        <div id="page-loader" class="fade in"><span class="spinner"></span></div>
        <!-- end #page-loader -->

        <!-- begin #page-container -->
        <div id="page-container" class="fade page-without-sidebar page-header-fixed">
            <!-- begin #header -->
            <div id="header" class="header navbar navbar-default navbar-fixed-top">
                    <!-- begin container-fluid -->
                <div class="container-fluid">
                    <g:render template="/layouts/navbar/header" />
                    <g:render template="/layouts/navbar/menu" />
                </div>
                <!-- end container-fluid -->
            </div>
            <!-- end #header -->

            <!-- begin #content -->
            <div id="content" class="content">
                <g:hiddenField name="config" data-resource="${resource()}" value="config" />
                <g:layoutBody/>

                <script type="text/ng-template" id="showConfirmationMessageTemplate">
                    <g:render template="/layouts/confirmationMessage" model="['messageClass':'alert-warning', 'title': 'Tem certeza?']" />
                </script>
                <script type="text/ng-template" id="showMessageTemplate">
                    <g:render template="/layouts/message" model="['messageClass':'alert-success', 'title': 'Sucesso!']" />
                </script>
                <script type="text/ng-template" id="showMessageErrorTemplate">
                    <g:render template="/layouts/message" model="['messageClass':'alert-danger', 'title': 'Erro!']" />
                </script>

                <script type="text/ng-template" id="documentoTemplate">
                    <g:render template="/layouts/document" />
                </script>
            </div>
        </div>
        <!-- end page container -->
        <g:render template="/layouts/baseJS" />
        <js:appJS />
    </body>
</html>