
<%@ page import="br.com.consultorio.Consulta" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'consulta.label', default: 'Consulta')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-consulta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-consulta" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="dia" title="${message(code: 'consulta.dia.label', default: 'Dia')}" />
					
						<g:sortableColumn property="ordemChegada" title="${message(code: 'consulta.ordemChegada.label', default: 'Ordem Chegada')}" />
					
						<g:sortableColumn property="horaChegada" title="${message(code: 'consulta.horaChegada.label', default: 'Hora Chegada')}" />
					
						<g:sortableColumn property="horaSaida" title="${message(code: 'consulta.horaSaida.label', default: 'Hora Saida')}" />
					
						<th><g:message code="consulta.paciente.label" default="Paciente" /></th>
					
						<th><g:message code="consulta.tipoConsulta.label" default="Tipo Consulta" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${consultaInstanceList}" status="i" var="consultaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${consultaInstance.id}">${fieldValue(bean: consultaInstance, field: "dia")}</g:link></td>
					
						<td>${fieldValue(bean: consultaInstance, field: "ordemChegada")}</td>
					
						<td>${fieldValue(bean: consultaInstance, field: "horaChegada")}</td>
					
						<td>${fieldValue(bean: consultaInstance, field: "horaSaida")}</td>
					
						<td>${fieldValue(bean: consultaInstance, field: "paciente")}</td>
					
						<td>${fieldValue(bean: consultaInstance, field: "tipoConsulta")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${consultaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
