define("parsley/field",["parsley/factory/constraint","parsley/ui","parsley/utils"],function(ConstraintFactory,ParsleyUI,ParsleyUtils){var ParsleyField=function(field,OptionsFactory,parsleyFormInstance){this.__class__="ParsleyField",this.__id__=ParsleyUtils.hash(4),this.$element=$(field),"undefined"!=typeof parsleyFormInstance?(this.parent=parsleyFormInstance,this.OptionsFactory=this.parent.OptionsFactory,this.options=this.OptionsFactory.get(this)):(this.OptionsFactory=OptionsFactory,this.options=this.OptionsFactory.get(this)),this.constraints=[],this.constraintsByName={},this.validationResult=[],this._bindConstraints()};return ParsleyField.prototype={validate:function(force){return this.value=this.getValue(),$.emit("parsley:field:validate",this),$.emit("parsley:field:"+(this.isValid(force,this.value)?"success":"error"),this),$.emit("parsley:field:validated",this),this.validationResult},isValid:function(force,value){this.refreshConstraints();var priorities=this._getConstraintsSortedPriorities();if(value=value||this.getValue(),0===value.length&&!this._isRequired()&&"undefined"==typeof this.options.validateIfEmpty&&!0!==force)return this.validationResult=[];if(!1===this.options.priorityEnabled)return!0===(this.validationResult=this.validateThroughValidator(value,this.constraints,"Any"));for(var i=0;i<priorities.length;i++)if(!0!==(this.validationResult=this.validateThroughValidator(value,this.constraints,priorities[i])))return!1;return!0},getValue:function(){var value;return value="undefined"!=typeof this.options.value?this.options.value:this.$element.val(),"undefined"==typeof value||null===value?"":!0===this.options.trimValue?value.replace(/^\s+|\s+$/g,""):value},refreshConstraints:function(){return this.actualizeOptions()._bindConstraints()},addConstraint:function(name,requirements,priority,isDomConstraint){if(name=name.toLowerCase(),"function"==typeof window.ParsleyValidator.validators[name]){var constraint=new ConstraintFactory(this,name,requirements,priority,isDomConstraint);"undefined"!==this.constraintsByName[constraint.name]&&this.removeConstraint(constraint.name),this.constraints.push(constraint),this.constraintsByName[constraint.name]=constraint}return this},removeConstraint:function(name){for(var i=0;i<this.constraints.length;i++)if(name===this.constraints[i].name){this.constraints.splice(i,1);break}return this},updateConstraint:function(name,parameters,priority){return this.removeConstraint(name).addConstraint(name,parameters,priority)},_bindConstraints:function(){for(var constraints=[],i=0;i<this.constraints.length;i++)!1===this.constraints[i].isDomConstraint&&constraints.push(this.constraints[i]);this.constraints=constraints;for(var name in this.options)this.addConstraint(name,this.options[name]);return this._bindHtml5Constraints()},_bindHtml5Constraints:function(){(this.$element.hasClass("required")||this.$element.attr("required"))&&this.addConstraint("required",!0,void 0,!0),"string"==typeof this.$element.attr("pattern")&&this.addConstraint("pattern",this.$element.attr("pattern"),void 0,!0),"undefined"!=typeof this.$element.attr("min")&&"undefined"!=typeof this.$element.attr("max")?this.addConstraint("range",[this.$element.attr("min"),this.$element.attr("max")],void 0,!0):"undefined"!=typeof this.$element.attr("min")?this.addConstraint("min",this.$element.attr("min"),void 0,!0):"undefined"!=typeof this.$element.attr("max")&&this.addConstraint("max",this.$element.attr("max"),void 0,!0);var type=this.$element.attr("type");return"undefined"==typeof type?this:"number"===type?this.addConstraint("type","integer",void 0,!0):new RegExp(type,"i").test("email url range")?this.addConstraint("type",type,void 0,!0):this},_isRequired:function(){return"undefined"==typeof this.constraintsByName.required?!1:!1!==this.constraintsByName.required.requirements},_getConstraintsSortedPriorities:function(){for(var priorities=[],i=0;i<this.constraints.length;i++)-1===priorities.indexOf(this.constraints[i].priority)&&priorities.push(this.constraints[i].priority);return priorities.sort(function(a,b){return b-a}),priorities}},ParsleyField});