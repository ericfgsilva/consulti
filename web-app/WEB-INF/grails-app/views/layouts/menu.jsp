<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <ul class="nav" id="side-menu">
            <li>
                <div class="panel-heading"><strong>Menu do Sistema</strong>
                <span class="pull-right">
                    <button type="button" class="btn btn-default btn-circle" onClick="abrirJanelaAjuda('${pageContext.request.contextPath}', 'menu')" ><i class="fa fa-question"></i></button>
                </span>
                </div>
            </li>
            <li>
                <a href="#"><i class="fa fa-user-md fa-fw"></i> Agenda M�dica<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href='${pageContext.request.contextPath}/sis/index'>Por dia</a>
                    </li>
                    <li>
                        <a href='${pageContext.request.contextPath}/sis/consulta/consultames'>Por M�s</a>
                    </li>
                    <li>
                        <a href='${pageContext.request.contextPath}/sis/consulta/new_select'>Nova Consulta M�dica</a>
                    </li>

                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-users fa-fw"></i> Pacientes<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href='${pageContext.request.contextPath}/sis/paciente/list'>Consulta</a>
                    </li>
                    <li>
                        <a href='${pageContext.request.contextPath}/sis/paciente/new'>Novo Paciente</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-building-o fa-fw"></i> Planos de Sa�de<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href='${pageContext.request.contextPath}/sis/planosaude/list'>Consulta</a>
                    </li>
                    <li>
                        <a href='${pageContext.request.contextPath}/sis/planosaude/new'>Novo Plano de Sa�de</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Relat�rios<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href='${pageContext.request.contextPath}/sis/relatorios'>Total de Glosas por Plano de Sa�de</a>
                    </li>
                    <li>
                        <a href='${pageContext.request.contextPath}/sis/relatorios'>Pacientes atendidos por M�s</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
        </ul>
    </body>
</html>
