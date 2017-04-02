<!-- Modal-cancelar-Edição-Paciente -->
<div class="modal" id="modal-criar-usuario">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header alert alert-warning m-b-0">
                <h4 class="modal-title"><i class="fa fa-warning"></i> Cadastrar Usuário</h4>
            </div>
            <div class="modal-body">
                <form name="form" >
                    <div id="cad-user" class="modal-body">
                    </div>
                    
                        <div class="row">
                            <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="username">Login:</label>
                                <input type="text" class="form-control" id="username" name="username" required="" placeholder="Login" ng-model="ctrl.createObject.username">
                             </div>
                             <div class="form-group col-xs-12 col-sm-3 col-md-3">
                                <label for="password">Senha:</label>
                                <input type="password" class="form-control" id="password" name="password" required="" placeholder="Senha" ng-model="ctrl.createObject.password">
                            </div>
                             <div class="form-group col-xs-12 col-sm-3 col-md-3">
                                <label for="confirmPwd">Repetir Senha:</label>
                                <input type="password" class="form-control" id="confirmPwd" name="confirmPwd" required="" placeholder="Repetir Senha" ng-model="ctrl.createObject.confirmPwd">
                            </div>
                        </div>
                                            
                        <div class="row">
                            <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="nome">Nome:</label>
                                <input type="text" class="form-control" id="nome" name="nome" required="" placeholder="Nome" ng-model="ctrl.createObject.nome">
                             </div>
                             <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="sobrenome">Sobrenome:</label>
                                <input type="text" class="form-control" id="sobrenome" name="sobrenome" required="" placeholder="Sobrenome" ng-model="ctrl.createObject.sobrenome">                                
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="CBO">CBO:</label>
                                <input type="text" class="form-control" id="cbo" name="CBO" required="" placeholder="Classificação Brasileira de Ocupações" ng-model="ctrl.createObject.cbo">
                             </div>
                             <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="conselho">Nº Conselho:</label>
                                <input type="text" class="form-control" id="nuConsReg" name="conselho" required="" placeholder="Nº conselho" ng-model="ctrl.createObject.nuConsReg">                                
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="CPF">CPF:</label>
                                <input type="text" class="form-control" id="nuCpf" name="CPF" required="" placeholder="Cadastro Nacional de PF" ng-model="ctrl.createObject.nuCpf">
                             </div>
                             <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="email">E-mail:</label>
                                <input type="email" class="form-control" id="email" name="email" required="" placeholder="E-mail" ng-model="ctrl.createObject.email">                                
                            </div>
                        </div>  
                        
                        <div class="row">
                            <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="dtNascimento">Data Nascimento:</label>
                                <input type="date" class="form-control" id="dtNascimento" name="dtNascimento" required="" placeholder="00/00/0000" ng-model="ctrl.createObject.dtNascimento">
                             </div>
                             <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="cep">CEP</label>
                                <input type="text" class="form-control" id="cep" name="cep" required="" placeholder="00000-000" ng-model="ctrl.createObject.cep">                                
                            </div>
                        </div> 
                        
                        <div class="row">
                            <div class="form-group col-xs-12 col-sm-12 col-md-12">
                                <label for="endereco">Endereço:</label>
                                <input type="text" class="form-control" id="endereco" name="endereco" required="" placeholder="Endereço completo" ng-model="ctrl.createObject.endereco">
                             </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group col-xs-12 col-sm-12 col-md-12">
                                <label for="complemento">Complemento:</label>
                                <input type="text" class="form-control" id="complemento" name="complemento" required="" placeholder="Edifício, apartamento, conjunto..." ng-model="ctrl.createObject.complemento">
                             </div>
                        </div>
                        
                        <div class="row">
                            <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="telefone">Telefone:</label>
                                <input type="text" class="form-control" id="telefone" name="telefone" required="" placeholder="(00) 0000-0000" ng-model="ctrl.createObject.telefone">
                             </div>
                             <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="celular">Celular</label>
                                <input type="text" class="form-control" id="celular" name="celular" required="" placeholder="(00) 0000-0000" ng-model="ctrl.createObject.celular">                                
                            </div>
                        </div>
                        
                        <div class="row" align="center">
                        <fieldset>
                            <div class="form-group col-xs-12 col-sm-12 col-md-12">
								<label>Perfil:&nbsp</label>
								<input type="radio" name="perfil" id="perfilAdmin" value="234" ng-model="ctrl.createObject.perfil"/>
								<label for="perfilAdmin">Administrador</label> 
								
								<input type="radio" name="perfil" id="perfilMedico" value="4578" ng-model="ctrl.createObject.perfil"/>
								<label for="perfilMedico">Medico</label> 
								
								<input type="radio" name="perfil" id="perfilUser" value="3212" ng-model="ctrl.createObject.perfil"/>
								<label for="perfilUser">Usuário</label> 																                               
                            </div>
                        </fieldset>
                        </div>                                                       
                        
                                               
            		</div>
            		<div class="modal-footer">
                		<a href="javascript:;" class="btn btn-md btn-default" ng-click="ctrl.save();" data-dismiss="modal">Cadastrar</a>
                		<a href="#modal-editar-paciente" class="btn btn-md btn-default botao-nao-cancelar-editar-paciente" data-toggle="modal" data-dismiss="modal">Cancelar</a>
            		</div>
            	</form> 
        </div>
    </div>
</div>
<!-- End Modal-cancelar-Edição-Paciente -->