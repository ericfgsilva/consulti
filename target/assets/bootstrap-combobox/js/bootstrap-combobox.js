!function($){"use strict";var Combobox=function(element,options){this.options=$.extend({},$.fn.combobox.defaults,options),this.$source=$(element),this.$container=this.setup(),this.$element=this.$container.find("input[type=text]"),this.$target=this.$container.find("input[type=hidden]"),this.$button=this.$container.find(".dropdown-toggle"),this.$menu=$(this.options.menu).appendTo("body"),this.matcher=this.options.matcher||this.matcher,this.sorter=this.options.sorter||this.sorter,this.highlighter=this.options.highlighter||this.highlighter,this.shown=!1,this.selected=!1,this.refresh(),this.transferAttributes(),this.listen()};Combobox.prototype={constructor:Combobox,setup:function(){var combobox=$(this.options.template);return this.$source.before(combobox),this.$source.hide(),combobox},parse:function(){var that=this,map={},source=[],selected=!1,selectedValue="";return this.$source.find("option").each(function(){var option=$(this);return""===option.val()?void(that.options.placeholder=option.text()):(map[option.text()]=option.val(),source.push(option.text()),void(option.prop("selected")&&(selected=option.text(),selectedValue=option.val())))}),this.map=map,selected&&(this.$element.val(selected),this.$target.val(selectedValue),this.$container.addClass("combobox-selected"),this.selected=!0),source},transferAttributes:function(){this.options.placeholder=this.$source.attr("data-placeholder")||this.options.placeholder,this.$element.attr("placeholder",this.options.placeholder),this.$target.prop("name",this.$source.prop("name")),this.$target.val(this.$source.val()),this.$source.removeAttr("name"),this.$element.attr("required",this.$source.attr("required")),this.$element.attr("rel",this.$source.attr("rel")),this.$element.attr("title",this.$source.attr("title")),this.$element.attr("class",this.$source.attr("class")),this.$element.attr("tabindex",this.$source.attr("tabindex")),this.$source.removeAttr("tabindex")},select:function(){var val=this.$menu.find(".active").attr("data-value");return this.$element.val(this.updater(val)).trigger("change"),this.$target.val(this.map[val]).trigger("change"),this.$source.val(this.map[val]).trigger("change"),this.$container.addClass("combobox-selected"),this.selected=!0,this.hide()},updater:function(item){return item},show:function(){var pos=$.extend({},this.$element.position(),{height:this.$element[0].offsetHeight});return this.$menu.insertAfter(this.$element).css({top:pos.top+pos.height,left:pos.left}).show(),this.shown=!0,this},hide:function(){return this.$menu.hide(),this.shown=!1,this},lookup:function(){return this.query=this.$element.val(),this.process(this.source)},process:function(items){var that=this;return items=$.grep(items,function(item){return that.matcher(item)}),items=this.sorter(items),items.length?this.render(items.slice(0,this.options.items)).show():this.shown?this.hide():this},matcher:function(item){return~item.toLowerCase().indexOf(this.query.toLowerCase())},sorter:function(items){for(var item,beginswith=[],caseSensitive=[],caseInsensitive=[];item=items.shift();)item.toLowerCase().indexOf(this.query.toLowerCase())?~item.indexOf(this.query)?caseSensitive.push(item):caseInsensitive.push(item):beginswith.push(item);return beginswith.concat(caseSensitive,caseInsensitive)},highlighter:function(item){var query=this.query.replace(/[\-\[\]{}()*+?.,\\\^$|#\s]/g,"\\$&");return item.replace(new RegExp("("+query+")","ig"),function($1,match){return"<strong>"+match+"</strong>"})},render:function(items){var that=this;return items=$(items).map(function(i,item){return i=$(that.options.item).attr("data-value",item),i.find("a").html(that.highlighter(item)),i[0]}),items.first().addClass("active"),this.$menu.html(items),this},next:function(){var active=this.$menu.find(".active").removeClass("active"),next=active.next();next.length||(next=$(this.$menu.find("li")[0])),next.addClass("active")},prev:function(){var active=this.$menu.find(".active").removeClass("active"),prev=active.prev();prev.length||(prev=this.$menu.find("li").last()),prev.addClass("active")},toggle:function(){this.$container.hasClass("combobox-selected")?(this.clearTarget(),this.triggerChange(),this.clearElement()):this.shown?this.hide():(this.clearElement(),this.lookup())},clearElement:function(){this.$element.val("").focus()},clearTarget:function(){this.$source.val(""),this.$target.val(""),this.$container.removeClass("combobox-selected"),this.selected=!1},triggerChange:function(){this.$source.trigger("change")},refresh:function(){this.source=this.parse(),this.options.items=this.source.length},listen:function(){this.$element.on("focus",$.proxy(this.focus,this)).on("blur",$.proxy(this.blur,this)).on("keypress",$.proxy(this.keypress,this)).on("keyup",$.proxy(this.keyup,this)),this.eventSupported("keydown")&&this.$element.on("keydown",$.proxy(this.keydown,this)),this.$menu.on("click",$.proxy(this.click,this)).on("mouseenter","li",$.proxy(this.mouseenter,this)).on("mouseleave","li",$.proxy(this.mouseleave,this)),this.$button.on("click",$.proxy(this.toggle,this))},eventSupported:function(eventName){var isSupported=eventName in this.$element;return isSupported||(this.$element.setAttribute(eventName,"return;"),isSupported="function"==typeof this.$element[eventName]),isSupported},move:function(e){if(this.shown){switch(e.keyCode){case 9:case 13:case 27:e.preventDefault();break;case 38:e.preventDefault(),this.prev();break;case 40:e.preventDefault(),this.next()}e.stopPropagation()}},keydown:function(e){this.suppressKeyPressRepeat=~$.inArray(e.keyCode,[40,38,9,13,27]),this.move(e)},keypress:function(e){this.suppressKeyPressRepeat||this.move(e)},keyup:function(e){switch(e.keyCode){case 40:case 39:case 38:case 37:case 36:case 35:case 16:case 17:case 18:break;case 9:case 13:if(!this.shown)return;this.select();break;case 27:if(!this.shown)return;this.hide();break;default:this.clearTarget(),this.lookup()}e.stopPropagation(),e.preventDefault()},focus:function(){this.focused=!0},blur:function(){var that=this;this.focused=!1;var val=this.$element.val();this.selected||""===val||(this.$element.val(""),this.$source.val("").trigger("change"),this.$target.val("").trigger("change")),!this.mousedover&&this.shown&&setTimeout(function(){that.hide()},200)},click:function(e){e.stopPropagation(),e.preventDefault(),this.select(),this.$element.focus()},mouseenter:function(e){this.mousedover=!0,this.$menu.find(".active").removeClass("active"),$(e.currentTarget).addClass("active")},mouseleave:function(){this.mousedover=!1}},$.fn.combobox=function(option){return this.each(function(){var $this=$(this),data=$this.data("combobox"),options="object"==typeof option&&option;data||$this.data("combobox",data=new Combobox(this,options)),"string"==typeof option&&data[option]()})},$.fn.combobox.defaults={template:'<div class="combobox-container"><input type="hidden" /><input type="text" autocomplete="off" /><span class="add-on btn dropdown-toggle" data-dropdown="dropdown"><span class="caret"/><span class="combobox-clear"><i class="icon-remove"/></span></span></div>',menu:'<ul class="typeahead typeahead-long dropdown-menu"></ul>',item:'<li><a href="#"></a></li>'},$.fn.combobox.Constructor=Combobox}(window.jQuery);