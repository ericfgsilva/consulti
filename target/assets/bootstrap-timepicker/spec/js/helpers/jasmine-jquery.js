var readFixtures=function(){return jasmine.getFixtures().proxyCallTo_("read",arguments)},preloadFixtures=function(){jasmine.getFixtures().proxyCallTo_("preload",arguments)},loadFixtures=function(){jasmine.getFixtures().proxyCallTo_("load",arguments)},appendLoadFixtures=function(){jasmine.getFixtures().proxyCallTo_("appendLoad",arguments)},setFixtures=function(){jasmine.getFixtures().proxyCallTo_("set",arguments)},appendSetFixtures=function(){jasmine.getFixtures().proxyCallTo_("appendSet",arguments)},sandbox=function(attributes){return jasmine.getFixtures().sandbox(attributes)},spyOnEvent=function(selector,eventName){return jasmine.JQuery.events.spyOn(selector,eventName)},preloadStyleFixtures=function(){jasmine.getStyleFixtures().proxyCallTo_("preload",arguments)},loadStyleFixtures=function(){jasmine.getStyleFixtures().proxyCallTo_("load",arguments)},appendLoadStyleFixtures=function(){jasmine.getStyleFixtures().proxyCallTo_("appendLoad",arguments)},setStyleFixtures=function(){jasmine.getStyleFixtures().proxyCallTo_("set",arguments)},appendSetStyleFixtures=function(){jasmine.getStyleFixtures().proxyCallTo_("appendSet",arguments)},loadJSONFixtures=function(){return jasmine.getJSONFixtures().proxyCallTo_("load",arguments)},getJSONFixture=function(url){return jasmine.getJSONFixtures().proxyCallTo_("read",arguments)[url]};jasmine.spiedEventsKey=function(selector,eventName){return[$(selector).selector,eventName].toString()},jasmine.getFixtures=function(){return jasmine.currentFixtures_=jasmine.currentFixtures_||new jasmine.Fixtures},jasmine.getStyleFixtures=function(){return jasmine.currentStyleFixtures_=jasmine.currentStyleFixtures_||new jasmine.StyleFixtures},jasmine.Fixtures=function(){this.containerId="jasmine-fixtures",this.fixturesCache_={},this.fixturesPath="spec/js/fixtures"},jasmine.Fixtures.prototype.set=function(html){this.cleanUp(),this.createContainer_(html)},jasmine.Fixtures.prototype.appendSet=function(html){this.addToContainer_(html)},jasmine.Fixtures.prototype.preload=function(){this.read.apply(this,arguments)},jasmine.Fixtures.prototype.load=function(){this.cleanUp(),this.createContainer_(this.read.apply(this,arguments))},jasmine.Fixtures.prototype.appendLoad=function(){this.addToContainer_(this.read.apply(this,arguments))},jasmine.Fixtures.prototype.read=function(){for(var htmlChunks=[],fixtureUrls=arguments,urlCount=fixtureUrls.length,urlIndex=0;urlCount>urlIndex;urlIndex++)htmlChunks.push(this.getFixtureHtml_(fixtureUrls[urlIndex]));return htmlChunks.join("")},jasmine.Fixtures.prototype.clearCache=function(){this.fixturesCache_={}},jasmine.Fixtures.prototype.cleanUp=function(){$("#"+this.containerId).remove()},jasmine.Fixtures.prototype.sandbox=function(attributes){var attributesToSet=attributes||{};return $('<div id="sandbox" />').attr(attributesToSet)},jasmine.Fixtures.prototype.createContainer_=function(html){var container;html instanceof $?(container=$('<div id="'+this.containerId+'" />'),container.html(html)):container='<div id="'+this.containerId+'">'+html+"</div>",$(document.body).append(container)},jasmine.Fixtures.prototype.addToContainer_=function(html){var container=$(document.body).find("#"+this.containerId).append(html);container.length||this.createContainer_(html)},jasmine.Fixtures.prototype.getFixtureHtml_=function(url){return"undefined"==typeof this.fixturesCache_[url]&&this.loadFixtureIntoCache_(url),this.fixturesCache_[url]},jasmine.Fixtures.prototype.loadFixtureIntoCache_=function(relativeUrl){var url=this.makeFixtureUrl_(relativeUrl),request=$.ajax({type:"GET",url:url+"?"+(new Date).getTime(),async:!1});this.fixturesCache_[relativeUrl]=request.responseText},jasmine.Fixtures.prototype.makeFixtureUrl_=function(relativeUrl){return this.fixturesPath.match("/$")?this.fixturesPath+relativeUrl:this.fixturesPath+"/"+relativeUrl},jasmine.Fixtures.prototype.proxyCallTo_=function(methodName,passedArguments){return this[methodName].apply(this,passedArguments)},jasmine.StyleFixtures=function(){this.fixturesCache_={},this.fixturesNodes_=[],this.fixturesPath="spec/javascripts/fixtures"},jasmine.StyleFixtures.prototype.set=function(css){this.cleanUp(),this.createStyle_(css)},jasmine.StyleFixtures.prototype.appendSet=function(css){this.createStyle_(css)},jasmine.StyleFixtures.prototype.preload=function(){this.read_.apply(this,arguments)},jasmine.StyleFixtures.prototype.load=function(){this.cleanUp(),this.createStyle_(this.read_.apply(this,arguments))},jasmine.StyleFixtures.prototype.appendLoad=function(){this.createStyle_(this.read_.apply(this,arguments))},jasmine.StyleFixtures.prototype.cleanUp=function(){for(;this.fixturesNodes_.length;)this.fixturesNodes_.pop().remove()},jasmine.StyleFixtures.prototype.createStyle_=function(html){var styleText=$("<div></div>").html(html).text(),style=$("<style>"+styleText+"</style>");this.fixturesNodes_.push(style),$("head").append(style)},jasmine.StyleFixtures.prototype.clearCache=jasmine.Fixtures.prototype.clearCache,jasmine.StyleFixtures.prototype.read_=jasmine.Fixtures.prototype.read,jasmine.StyleFixtures.prototype.getFixtureHtml_=jasmine.Fixtures.prototype.getFixtureHtml_,jasmine.StyleFixtures.prototype.loadFixtureIntoCache_=jasmine.Fixtures.prototype.loadFixtureIntoCache_,jasmine.StyleFixtures.prototype.makeFixtureUrl_=jasmine.Fixtures.prototype.makeFixtureUrl_,jasmine.StyleFixtures.prototype.proxyCallTo_=jasmine.Fixtures.prototype.proxyCallTo_,jasmine.getJSONFixtures=function(){return jasmine.currentJSONFixtures_=jasmine.currentJSONFixtures_||new jasmine.JSONFixtures},jasmine.JSONFixtures=function(){this.fixturesCache_={},this.fixturesPath="spec/javascripts/fixtures/json"},jasmine.JSONFixtures.prototype.load=function(){return this.read.apply(this,arguments),this.fixturesCache_},jasmine.JSONFixtures.prototype.read=function(){for(var fixtureUrls=arguments,urlCount=fixtureUrls.length,urlIndex=0;urlCount>urlIndex;urlIndex++)this.getFixtureData_(fixtureUrls[urlIndex]);return this.fixturesCache_},jasmine.JSONFixtures.prototype.clearCache=function(){this.fixturesCache_={}},jasmine.JSONFixtures.prototype.getFixtureData_=function(url){return this.loadFixtureIntoCache_(url),this.fixturesCache_[url]},jasmine.JSONFixtures.prototype.loadFixtureIntoCache_=function(relativeUrl){var self=this,url=this.fixturesPath.match("/$")?this.fixturesPath+relativeUrl:this.fixturesPath+"/"+relativeUrl;$.ajax({async:!1,cache:!1,dataType:"json",url:url,success:function(data){self.fixturesCache_[relativeUrl]=data},fail:function(jqXHR,status,errorThrown){throw Error("JSONFixture could not be loaded: "+url+" (status: "+status+", message: "+errorThrown.message+")")}})},jasmine.JSONFixtures.prototype.proxyCallTo_=function(methodName,passedArguments){return this[methodName].apply(this,passedArguments)},jasmine.JQuery=function(){},jasmine.JQuery.browserTagCaseIndependentHtml=function(html){return $("<div/>").append(html).html()},jasmine.JQuery.elementToString=function(element){var domEl=$(element).get(0);return void 0==domEl||domEl.cloneNode?$("<div />").append($(element).clone()).html():element.toString()},jasmine.JQuery.matchersClass={},!function(namespace){var data={spiedEvents:{},handlers:[]};namespace.events={spyOn:function(selector,eventName){var handler=function(e){data.spiedEvents[jasmine.spiedEventsKey(selector,eventName)]=e};return $(selector).bind(eventName,handler),data.handlers.push(handler),{selector:selector,eventName:eventName,handler:handler,reset:function(){delete data.spiedEvents[jasmine.spiedEventsKey(selector,eventName)]}}},wasTriggered:function(selector,eventName){return!!data.spiedEvents[jasmine.spiedEventsKey(selector,eventName)]},wasPrevented:function(selector,eventName){var e;return(e=data.spiedEvents[jasmine.spiedEventsKey(selector,eventName)])&&e.isDefaultPrevented()},cleanUp:function(){data.spiedEvents={},data.handlers=[]}}}(jasmine.JQuery),!function(){var jQueryMatchers={toHaveClass:function(className){return this.actual.hasClass(className)},toHaveCss:function(css){for(var prop in css)if(this.actual.css(prop)!==css[prop])return!1;return!0},toBeVisible:function(){return this.actual.is(":visible")},toBeHidden:function(){return this.actual.is(":hidden")},toBeSelected:function(){return this.actual.is(":selected")},toBeChecked:function(){return this.actual.is(":checked")},toBeEmpty:function(){return this.actual.is(":empty")},toExist:function(){return $(document).find(this.actual).length},toHaveLength:function(length){return this.actual.length===length},toHaveAttr:function(attributeName,expectedAttributeValue){return hasProperty(this.actual.attr(attributeName),expectedAttributeValue)},toHaveProp:function(propertyName,expectedPropertyValue){return hasProperty(this.actual.prop(propertyName),expectedPropertyValue)},toHaveId:function(id){return this.actual.attr("id")==id},toHaveHtml:function(html){return this.actual.html()==jasmine.JQuery.browserTagCaseIndependentHtml(html)},toContainHtml:function(html){var actualHtml=this.actual.html(),expectedHtml=jasmine.JQuery.browserTagCaseIndependentHtml(html);return actualHtml.indexOf(expectedHtml)>=0},toHaveText:function(text){var trimmedText=$.trim(this.actual.text());return text&&$.isFunction(text.test)?text.test(trimmedText):trimmedText==text},toHaveValue:function(value){return this.actual.val()==value},toHaveData:function(key,expectedValue){return hasProperty(this.actual.data(key),expectedValue)},toBe:function(selector){return this.actual.is(selector)},toContain:function(selector){return this.actual.find(selector).length},toBeDisabled:function(){return this.actual.is(":disabled")},toBeFocused:function(){return this.actual[0]===this.actual[0].ownerDocument.activeElement},toHandle:function(event){var events=$._data(this.actual.get(0),"events");if(!events||!event||"string"!=typeof event)return!1;var namespaces=event.split("."),eventType=namespaces.shift(),sortedNamespaces=namespaces.slice(0).sort(),namespaceRegExp=new RegExp("(^|\\.)"+sortedNamespaces.join("\\.(?:.*\\.)?")+"(\\.|$)");if(!events[eventType]||!namespaces.length)return events[eventType]&&events[eventType].length>0;for(var i=0;i<events[eventType].length;i++){var namespace=events[eventType][i].namespace;if(namespaceRegExp.test(namespace))return!0}},toHandleWith:function(eventName,eventHandler){for(var stack=$._data(this.actual.get(0),"events")[eventName],i=0;i<stack.length;i++)if(stack[i].handler==eventHandler)return!0;return!1}},hasProperty=function(actualValue,expectedValue){return void 0===expectedValue?void 0!==actualValue:actualValue==expectedValue},bindMatcher=function(methodName){var builtInMatcher=jasmine.Matchers.prototype[methodName];jasmine.JQuery.matchersClass[methodName]=function(){if(this.actual&&(this.actual instanceof $||jasmine.isDomNode(this.actual))){this.actual=$(this.actual);var element,result=jQueryMatchers[methodName].apply(this,arguments);return this.actual.get&&(element=this.actual.get()[0])&&!$.isWindow(element)&&"HTML"!==element.tagName&&(this.actual=jasmine.JQuery.elementToString(this.actual)),result}return builtInMatcher?builtInMatcher.apply(this,arguments):!1}};for(var methodName in jQueryMatchers)bindMatcher(methodName)}(),beforeEach(function(){this.addMatchers(jasmine.JQuery.matchersClass),this.addMatchers({toHaveBeenTriggeredOn:function(selector){return this.message=function(){return["Expected event "+this.actual+" to have been triggered on "+selector,"Expected event "+this.actual+" not to have been triggered on "+selector]},jasmine.JQuery.events.wasTriggered(selector,this.actual)}}),this.addMatchers({toHaveBeenTriggered:function(){var eventName=this.actual.eventName,selector=this.actual.selector;return this.message=function(){return["Expected event "+eventName+" to have been triggered on "+selector,"Expected event "+eventName+" not to have been triggered on "+selector]},jasmine.JQuery.events.wasTriggered(selector,eventName)}}),this.addMatchers({toHaveBeenPreventedOn:function(selector){return this.message=function(){return["Expected event "+this.actual+" to have been prevented on "+selector,"Expected event "+this.actual+" not to have been prevented on "+selector]},jasmine.JQuery.events.wasPrevented(selector,this.actual)}}),this.addMatchers({toHaveBeenPrevented:function(){var eventName=this.actual.eventName,selector=this.actual.selector;return this.message=function(){return["Expected event "+eventName+" to have been prevented on "+selector,"Expected event "+eventName+" not to have been prevented on "+selector]},jasmine.JQuery.events.wasPrevented(selector,eventName)}})}),afterEach(function(){jasmine.getFixtures().cleanUp(),jasmine.getStyleFixtures().cleanUp(),jasmine.JQuery.events.cleanUp()});