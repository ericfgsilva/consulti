define(function(){return function(ParsleyField,Parsley){describe("ParsleyField",function(){it("should be a function",function(){expect(ParsleyField).to.be.a("function")}),it("should throw an error if no parsleyInstance given",function(){expect(ParsleyField).to.throwException()}),it("should properly bind DOM constraints",function(){$("body").append('<input type="text" id="element" data-parsley-required />');var parsleyField=new Parsley($("#element"));expect(parsleyField.constraints.length).to.be(1),expect(parsleyField.constraints[0].__class__).to.be("Required"),expect(parsleyField.constraints[0].__parentClass__).to.be("Assert"),expect(parsleyField.constraints[0].name).to.be("required"),expect(parsleyField.constraints[0].isDomConstraint).to.be(!0)}),it("should properly bind HTML DOM supported constraints",function(){$("body").append('<input type="email" id="element" />');var parsleyField=new Parsley($("#element"));expect(parsleyField.constraints.length).to.be(1),expect(parsleyField.constraints[0].__class__).to.be("Email"),expect(parsleyField.constraints[0].__parentClass__).to.be("Assert"),expect(parsleyField.constraints[0].name).to.be("type"),expect(parsleyField.constraints[0].isDomConstraint).to.be(!0)}),it("should have a proper addConstraint() javascript method",function(){$("body").append('<input type="text" id="element" />');var parsleyField=new Parsley($("#element")).addConstraint("required",!0);expect(parsleyField.constraints.length).to.be(1),expect(parsleyField.constraints[0].__class__).to.be("Required"),expect(parsleyField.constraints[0].__parentClass__).to.be("Assert"),expect(parsleyField.constraints[0].name).to.be("required"),expect(parsleyField.constraints[0].requirements).to.be(!0),expect(parsleyField.constraints[0].priority).to.be(512),expect(parsleyField.constraints[0].isDomConstraint).to.be(!1),parsleyField.addConstraint("required",!1,64),expect(parsleyField.constraints.length).to.be(1),expect(parsleyField.constraints[0].name).to.be("required"),expect(parsleyField.constraints[0].requirements).to.be(!1),expect(parsleyField.constraints[0].priority).to.be(64)}),it("should have a proper updateConstraint() javascript method",function(){$("body").append('<input type="text" id="element" />');var parsleyField=new Parsley($("#element")).addConstraint("required",!0);parsleyField.updateConstraint("required",!1,64),expect(parsleyField.constraints.length).to.be(1),expect(parsleyField.constraints[0].name).to.be("required"),expect(parsleyField.constraints[0].requirements).to.be(!1),expect(parsleyField.constraints[0].priority).to.be(64)}),it("should have a proper removeConstraint() javascript method",function(){$("body").append('<input type="text" id="element" />');var parsleyField=new Parsley($("#element")).addConstraint("required",!0).addConstraint("notblank",!0).removeConstraint("required");expect(parsleyField.constraints.length).to.be(1),expect(parsleyField.constraints[0].name).to.be("notblank")}),it("should return an empty array for fields withoud constraints",function(){$("body").append('<input type="text" id="element" value="" />'),expect(new Parsley($("#element")).isValid()).to.eql([])}),it("should properly bind HTML5 supported constraints",function(){$("body").append('<input type="email" pattern="\\w+" id="element" required min="5" max="100" />');var parsleyField=new Parsley($("#element"));expect(parsleyField.constraints.length).to.be(4),$("#element").removeAttr("min"),expect(parsleyField.actualizeOptions().constraints.length).to.be(4)}),it("should properly bind special HTML5 `number` type",function(){$("body").append('<input type="number" id="element" />');var parsleyField=new Parsley($("#element"));expect(parsleyField.constraints[0].requirements).to.be("integer")}),it("should valid simple validator",function(){$("body").append('<input type="text" id="element" value="" />');var parsleyField=new Parsley($("#element")).addConstraint("required",!0);expect(parsleyField.isValid()).to.be(!1),$("#element").val("foo"),expect(parsleyField.isValid()).to.be(!0)}),it("should valid more complex `type` validator",function(){$("body").append('<input type="text" id="element" value="foo" />');var parsleyField=new Parsley($("#element")).addConstraint("type","email");expect(parsleyField.isValid()).to.be(!1),$("#element").val("foo"),expect(parsleyField.isValid()).to.be(!1),$("#element").val("foo@bar.baz"),expect(parsleyField.isValid()).to.be(!0)}),it("should valid most complex Callback() validator",function(){$("body").append('<input type="text" id="element" value="" />'),ParsleyValidator.addValidator("multiple",function(value,multiple){return!isNaN(parseFloat(value))&&isFinite(value)?!(Number(value)%multiple):!1},512);var parsleyField=new Parsley($("#element")).addConstraint("multiple",2);expect(parsleyField.isValid()).to.eql([]),$("#element").val("1"),expect(parsleyField.isValid()).to.be(!1),$("#element").val("2"),expect(parsleyField.isValid()).to.be(!0),parsleyField.updateConstraint("multiple",3),expect(parsleyField.isValid()).to.be(!1),$("#element").val("9"),expect(parsleyField.isValid()).to.be(!0),ParsleyValidator.removeValidator("multiple")}),it("should properly compute constraints on each validation",function(){$("body").append('<input type="email" data-parsley-required id="element" />'),ParsleyValidator.addValidator("foobazer",function(value){return"foobar"===value},2),ParsleyValidator.addValidator("multiple",function(value,multiple){return!isNaN(parseFloat(value))&&isFinite(value)?!(Number(value)%multiple):!1},512);var parsleyField=new Parsley($("#element")).addConstraint("multiple",4).addConstraint("foobazer",!0);parsleyField.refreshConstraints(),expect(parsleyField.constraints.length).to.be(4),$("#element").removeAttr("data-parsley-required"),parsleyField.refreshConstraints(),expect(parsleyField.constraints.length).to.be(3),parsleyField.removeConstraint("multiple").refreshConstraints(),expect(parsleyField.constraints.length).to.be(2),ParsleyValidator.removeValidator("foobazer"),ParsleyValidator.removeValidator("multiple")}),it("should handle constraints priorities on validation",function(){$("body").append('<input type="email" pattern="[A-F][0-9]{5}" required id="element" />');var parsleyField=new Parsley($("#element"));expect(parsleyField.isValid()).to.be(!1),expect(parsleyField.validationResult.length).to.be(1),expect(parsleyField.validationResult[0].assert.name).to.be("required"),$("#element").val("foo"),expect(parsleyField.isValid()).to.be(!1),expect(parsleyField.validationResult.length).to.be(1),expect(parsleyField.validationResult[0].assert.name).to.be("type"),$("#element").val("foo@bar.baz"),expect(parsleyField.isValid()).to.be(!1),expect(parsleyField.validationResult.length).to.be(1),expect(parsleyField.validationResult[0].assert.name).to.be("pattern")}),it("should handle all violations if `priorityEnabled` is set to false",function(){$("body").append('<input type="email" pattern="[A-F][0-9]{5}" required id="element" />');var parsleyField=new Parsley($("#element"),{priorityEnabled:!1});expect(parsleyField.isValid()).to.be(!1),expect(parsleyField.validationResult.length).to.be(3)}),it("should fire parsley:field:validate event",function(done){$("body").append('<input type="email" pattern="[A-F][0-9]{5}" required id="element" />'),$.listenTo($("#element").psly(),"parsley:field:validate",function(instance){expect(instance.validationResult.length).to.be(0),done()}),$("#element").psly().validate()}),it("should fire parsley:field:validated event",function(done){$("body").append('<input type="email" pattern="[A-F][0-9]{5}" required id="element" />'),$.listenTo($("#element").psly(),"parsley:field:validated",function(instance){expect(instance.validationResult.length).to.be(1),done()}),$("#element").psly().validate()}),it("should fire parsley:field:error event",function(done){$("body").append('<input type="email" pattern="[A-F][0-9]{5}" required id="element" />'),$.listenTo($("#element").psly(),"parsley:field:error",function(instance){expect(instance.validationResult.length).to.be(1),done()}),$("#element").psly().validate()}),it("should fire parsley:field:success event",function(done){$("body").append('<input type="email" required id="element" value="foo@bar.baz" />'),$.listenTo($("#element").psly(),"parsley:field:success",function(instance){expect(instance.validationResult).to.be(!0),done()}),$("#element").psly().validate()}),it("should have validateIfEmpty option",function(){$("body").append('<input type="email" data-parsley-rangelength="[5, 10]" id="element" />'),expect($("#element").psly().isValid()).to.be.eql([]),$("#element").attr("data-parsley-validate-if-empty",""),expect($("#element").psly().isValid()).to.be.eql(!1)}),it("should allow `this.value` alteration with parsley:field:validate event",function(){$("body").append('<input type="email" required id="element" />'),expect($("#element").parsley().validate()).not.to.be(!0),$("#element").parsley().subscribe("parsley:field:validate",function(fieldInstance){fieldInstance.value="foo@bar.baz"}),expect($("#element").parsley().validate()).to.be(!0)}),it("should have a force option for validate and isValid methods",function(){$("body").append('<input type="email" id="element" />'),expect($("#element").parsley().isValid()).to.be.eql([]),expect($("#element").parsley().validate()).to.be.eql([]),expect($("#element").parsley().isValid(!0)).to.be(!1),expect($("#element").parsley().validate(!0).length).to.be(1)}),it("should have a trim-value option",function(){$("body").append('<input type="text" id="element" value=" foo " />'),expect($("#element").parsley().getValue()).to.be(" foo "),$("#element").attr("data-parsley-trim-value",!0).parsley().actualizeOptions(),expect($("#element").parsley().getValue()).to.be("foo")}),it("should properly handle null or undefined values",function(){$("body").append('<input type="text" id="element" required value/>'),expect($("#element").parsley().isValid()).to.be(!1)}),afterEach(function(){window.ParsleyConfig={i18n:window.ParsleyConfig.i18n,validators:window.ParsleyConfig.validators},$("#element").length&&$("#element").remove(),$(".parsley-errors-list").length&&$(".parsley-errors-list").remove()})})}});