$(document).ready(function(){
    
	//$("#modal-create").hide();

    $('#showHideCreate').click(function() { 
        $("#modal-create").modal('show')
		var teste = $("#modal-create")
		console.log(teste);
        return false;
    });
})