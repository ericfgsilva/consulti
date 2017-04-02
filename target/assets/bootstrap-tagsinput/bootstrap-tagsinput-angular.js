angular.module("bootstrap-tagsinput",[]).directive("bootstrapTagsinput",[function(){function getItemProperty(scope,property){return property?angular.isFunction(scope.$parent[property])?scope.$parent[property]:function(item){return item[property]}:void 0}return{restrict:"EA",scope:{model:"=ngModel"},template:"<select multiple></select>",replace:!1,link:function(scope,element,attrs){$(function(){angular.isArray(scope.model)||(scope.model=[]);var select=$("select",element);select.tagsinput({typeahead:{source:angular.isFunction(scope.$parent[attrs.typeaheadSource])?scope.$parent[attrs.typeaheadSource]:null},itemValue:getItemProperty(scope,attrs.itemvalue),itemText:getItemProperty(scope,attrs.itemtext),tagClass:angular.isFunction(scope.$parent[attrs.tagclass])?scope.$parent[attrs.tagclass]:function(){return attrs.tagclass}});for(var i=0;i<scope.model.length;i++)select.tagsinput("add",scope.model[i]);select.on("itemAdded",function(event){-1===scope.model.indexOf(event.item)&&scope.model.push(event.item)}),select.on("itemRemoved",function(event){var idx=scope.model.indexOf(event.item);-1!==idx&&scope.model.splice(idx,1)});var prev=scope.model.slice();scope.$watch("model",function(){var i,added=scope.model.filter(function(i){return-1===prev.indexOf(i)}),removed=prev.filter(function(i){return-1===scope.model.indexOf(i)});for(prev=scope.model.slice(),i=0;i<removed.length;i++)select.tagsinput("remove",removed[i]);for(select.tagsinput("refresh"),i=0;i<added.length;i++)select.tagsinput("add",added[i])},!0)})}}}]);