// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('filters');

// Iniciar módulo
var app = angular.module('filters', []);

app.filter("filterPacienteName", function() {
    return function(pacientes, query) {
        if (!pacientes.length)
            return pacientes;

        return pacientes.filter(function(paciente) {
            try {
                return paciente.nome.match(new RegExp(query, "gi"));
            } catch (err) {
                return null;
            }
        });
    };
});

app.filter("filterByGroup", function() {
	return function(teams, query) {
		if (!teams.length)
			return teams;

		return teams.filter(function(team) {
			try {
				return team.group.match(new RegExp(query, "gi"));
			} catch (err) {
				return null;
			}
		});
	};
});