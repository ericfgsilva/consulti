!function($){"use strict";var Constructor=function(options){this.init("typeaheadjs",options,Constructor.defaults)};$.fn.editableutils.inherit(Constructor,$.fn.editabletypes.text),$.extend(Constructor.prototype,{render:function(){this.renderClear(),this.setClass(),this.setAttr("placeholder"),this.$input.typeahead(this.options.typeahead),"bs3"===$.fn.editableform.engine&&(this.$input.hasClass("input-sm")&&this.$input.siblings("input.tt-hint").addClass("input-sm"),this.$input.hasClass("input-lg")&&this.$input.siblings("input.tt-hint").addClass("input-lg"))}}),Constructor.defaults=$.extend({},$.fn.editabletypes.list.defaults,{tpl:'<input type="text">',typeahead:null,clear:!0}),$.fn.editabletypes.typeaheadjs=Constructor}(window.jQuery);