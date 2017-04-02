<asset:javascript src="converse.min.js"/>
<script>
    require(['converse'], function (converse) {
        converse.initialize({
            allow_otr: true,
            auto_list_rooms: true,
            auto_subscribe: true,
            bosh_service_url: 'http://localhost:5280/http-bind/',
            hide_muc_server: true,
            i18n: locales['en'],
            keepalive: true,
            play_sounds: true,
            roster_groups: true,
            show_controlbox_by_default: true,
            xhr_user_search: true
        });
    });
</script>

<!-- ================== BEGIN BASE JS ================== -->
<script src="${resource(dir: 'plugins', file: 'jquery-1.8.2/jquery-1.8.2.min.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'jquery-ui-1.10.4/ui/minified/jquery-ui.min.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'bootstrap-3.2.0/js/bootstrap.min.js')}"></script>
<!--[if lt IE 9]>
<script src="assets/crossbrowserjs/html5shiv.js"></script>
<script src="assets/crossbrowserjs/respond.min.js"></script>
<script src="assets/crossbrowserjs/excanvas.min.js"></script>
<![endif]-->
<script src="${resource(dir: 'plugins', file: 'slimscroll/jquery.slimscroll.min.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'jquery-cookie/jquery.cookie.js')}"></script>
<!-- ================== END BASE JS ================== -->

<!-- ================== BEGIN PAGE LEVEL JS ================== -->
<script src="${resource(dir: 'plugins', file: 'bootstrap-datepicker/js/bootstrap-datepicker.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'ionRangeSlider/js/ion-rangeSlider/ion.rangeSlider.min.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'bootstrap-colorpicker/js/bootstrap-colorpicker.min.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'masked-input/masked-input.min.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'bootstrap-timepicker/js/bootstrap-timepicker.min.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'password-indicator/js/password-indicator.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'bootstrap-combobox/js/bootstrap-combobox.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'bootstrap-select/bootstrap-select.min.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'bootstrap-tagsinput/bootstrap-tagsinput.min.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'bootstrap-tagsinput/bootstrap-tagsinput-typeahead.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'jquery-tag-it/js/tag-it.min.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'slimscroll/jquery.slimscroll.min.js')}"></script>

<asset:javascript src="form-plugins.demo.min.js"/>
<asset:javascript src="form-wysiwyg.demo.min.js"/>
<script src="${resource(dir: 'plugins', file: 'bootstrap-wysihtml5/lib/js/wysihtml5-0.3.0.js')}"></script>
<script src="${resource(dir: 'plugins', file: 'bootstrap-wysihtml5/src/bootstrap-wysihtml5.js')}"></script>
<asset:javascript src="apps.min.js"/>


<!-- ================== END PAGE LEVEL JS ================== -->
<script>
    $(document).ready(function() {
        App.init();
        FormPlugins.init();
        FormWysihtml5.init();

        $('.prescricao').wysihtml5();

        $('#todos').hide();
        $('#todas-consultas, #bt-close-filtro').hide();

        $("*[data-popover]").each(function() {
            var content = $(this).data('popover');
            $(this).data('content', content);
            $(this).attr('rel', 'popover');
            $(this).data('trigger', 'hover');
            $(this).data('placement', 'bottom');
            $(this).popover();
        });

        $('#bt-filtrar').click(function(){
            $('#todos').show();
            $('#bt-close-filtro').show();
            $('#ultimas-consultas').hide();

        });

        $('#bt-all-consultas').click(function(){
            $('#todas-consultas').fadeIn();
        });

        $('#bt-off-consultas').click(function(){
            $('#todas-consultas').fadeOut();
        });

        $('#bt-close-filtro').click(function(){
            $('#bt-close-filtro').hide();
            $('#todos').hide();
            $('#ultimas-consultas').show();
        });

        $('#btn_cancelar_info_paciente').click(function(){
            $('#txarea_info_paciente').val('');
            $('#txarea_info_paciente').prop('disabled', true);
        })

        $('#btn_editar_info_paciente').click(function(){
            $('#txarea_info_paciente').prop('disabled', false);
        });


        /* ATENDIMENTO */
        $('#todas-consultas, #bt-off-consultas, #bt-mob-off-consultas').hide();

        /* Abrindo as consultas */
        $('#bt-all-consultas, #bt-mob-all-consultas').click(function(){
            $('#bt-all-consultas, #bt-mob-all-consultas').hide();
            $('#bt-off-consultas, #bt-mob-off-consultas').show();
            $('#todas-consultas').show();
            //$('#todas-consultas').toggle('fade');
        });

        /* fechando as consultas */
        $('#bt-off-consultas, #bt-mob-off-consultas').click(function(){
            $('#bt-all-consultas, #bt-mob-all-consultas').show();
            $('#bt-off-consultas, #bt-mob-off-consultas').hide();
            $('#todas-consultas').hide();
            //$('#todas-consultas').toggle('fade');
        });

    });
</script>