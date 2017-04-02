describe("angular easypiechart directive",function(){var $compile,scope;beforeEach(module("easypiechart")),beforeEach(inject(function(_$compile_,$rootScope){scope=$rootScope,$compile=_$compile_})),it("should have percentage default value 0",function(){scope.percent=null;var element=angular.element('<div easypiechart percent="percent" options="options"></div>');$compile(element)(scope),scope.$digest(),expect(element.isolateScope().percent).toBe(0)}),it("inserts the element with a canvas element",function(){scope.percent=-45,scope.options={};var element=angular.element('<div easypiechart percent="percent" options="options"></div>');$compile(element)(scope),scope.$digest(),expect(element.html()).toContain("canvas")}),it("gets the options right",function(){scope.percent=0,scope.options={animate:{duration:0,enabled:!1},barColor:"#2C3E50",scaleColor:!1,lineWidth:20,lineCap:"circle"};var element=angular.element('<div easypiechart percent="percent" options="options"></div>');$compile(element)(scope),scope.$digest(),expect(element.isolateScope().options.animate.duration).toBe(0),expect(element.isolateScope().options.lineCap).toBe("circle")}),it("has its own default options",function(){scope.percent=0,scope.options={};var element=angular.element('<div easypiechart percent="percent" options="options"></div>');$compile(element)(scope),scope.$digest(),expect(element.isolateScope().options.size).toBe(110),expect(element.isolateScope().options.animate.enabled).toBe(!0)}),it("takes size option the right way",function(){scope.percent=0,scope.options={size:200};var element=angular.element('<div easypiechart percent="percent" options="options"></div>');$compile(element)(scope),scope.$digest(),expect(element.html()).toContain('height="200"'),expect(element.html()).toContain('width="200"')})});