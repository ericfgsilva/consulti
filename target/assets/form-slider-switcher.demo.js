var green="#00acac",red="#ff5b57",blue="#348fe2",purple="#727cb6",orange="#f59c1a",black="#2d353c",renderSwitcher=function(){0!==$("[data-render=switchery]").length&&$("[data-render=switchery]").each(function(){var themeColor=green;if($(this).attr("data-theme"))switch($(this).attr("data-theme")){case"red":themeColor=red;break;case"blue":themeColor=blue;break;case"purple":themeColor=purple;break;case"orange":themeColor=orange;break;case"black":themeColor=black}var option={};option.color=themeColor,option.secondaryColor=$(this).attr("data-secondary-color")?$(this).attr("data-secondary-color"):"#dfdfdf",option.className=$(this).attr("data-classname")?$(this).attr("data-classname"):"switchery",option.disabled=$(this).attr("data-disabled")?!0:!1,option.disabledOpacity=$(this).attr("data-disabled-opacity")?$(this).attr("data-disabled-opacity"):.5,option.speed=$(this).attr("data-speed")?$(this).attr("data-speed"):"0.5s";new Switchery(this,option)})},checkSwitcherState=function(){$('[data-click="check-switchery-state"]').live("click",function(){alert($('[data-id="switchery-state"]').prop("checked"))}),$('[data-change="check-switchery-state-text"]').live("change",function(){$('[data-id="switchery-state-text"]').text($(this).prop("checked"))})},renderPowerRangeSlider=function(){0!==$('[data-render="powerange-slider"]').length&&$('[data-render="powerange-slider"]').each(function(){var option={};option.decimal=$(this).attr("data-decimal")?$(this).attr("data-decimal"):!1,option.disable=$(this).attr("data-disable")?$(this).attr("data-disable"):!1,option.disableOpacity=$(this).attr("data-disable-opacity")?$(this).attr("data-disable-opacity"):.5,option.hideRange=$(this).attr("data-hide-range")?$(this).attr("data-hide-range"):!1,option.klass=$(this).attr("data-class")?$(this).attr("data-class"):"",option.min=$(this).attr("data-min")?$(this).attr("data-min"):0,option.max=$(this).attr("data-max")?$(this).attr("data-max"):100,option.start=$(this).attr("data-start")?$(this).attr("data-start"):null,option.step=$(this).attr("data-step")?$(this).attr("data-step"):null,option.vertical=$(this).attr("data-vertical")?$(this).attr("data-vertical"):!1,$(this).attr("data-height")&&$(this).closest(".slider-wrapper").height($(this).attr("data-height"));new Switchery(this,option),new Powerange(this,option)})},FormSliderSwitcher=function(){"use strict";return{init:function(){renderSwitcher(),checkSwitcherState(),renderPowerRangeSlider()}}}();