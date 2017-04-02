<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
    <head>
        <meta name="layout" content="main" charset="utf-8" />
        <title>ConsulTI</title>
    </head>
    <body>
        <div ng-controller="atendimentoCtrl as ctrl" ng-init="ctrl.init();">
        <!-- begin row -->
            <div class="row" >
                <g:render template="/general/contadores" />
                <g:render template="lista_consultas" />
            </div>

            <!-- begin row -->
            <div class="col-xs-12 col-sm-6 col-md-12 height-full" ng-show="!ctrl.isConsultaEmAtendimento()" >
                <g:render template="pre_atendimento" />
            </div>

            <div class="row" ng-show="ctrl.isConsultaEmAtendimento()" data-drop="true"
                 ng-model="ctrl.listdragged" jqyoui-droppable="{beforeDrop: 'ctrl.beforeDrop'}" >
                <g:render template="atendimento" />
            </div><!-- Filto -->

        </div>
    </div>
</body>
</html>
