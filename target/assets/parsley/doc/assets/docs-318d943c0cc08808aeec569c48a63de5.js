!function($){$(function(){{var $window=$(window),$body=$(document.body);$(".navbar").outerHeight(!0)+10}$body.scrollspy({target:".sidebar"}),$body.on("activate.bs.scrollspy",function(event){1===event.target.childNodes.length&&(window.location.hash="psly-"+$(event.target.children[0]).attr("href").slice(1))}),$window.on("load",function(){if($body.scrollspy("refresh"),/^#psly-/i.test(window.location.hash)){var h=window.location.hash.replace("psly-","");$(h).length&&(window.location.hash=h)}}),$(".back-to-top").on("click",function(){$(".sidebar .active").each(function(){$(this).removeClass("active")}),$(".sidebar ul:first li:first").addClass("active")}),setTimeout(function(){var $sideBar=$(".sidebar");$sideBar.affix({offset:{top:function(){var offsetTop=$sideBar.offset().top,sideBarMargin=parseInt($sideBar.children(0).css("margin-top"),10),navOuterHeight=10;return this.top=offsetTop-navOuterHeight-sideBarMargin},bottom:function(){return this.bottom=$(".footer").outerHeight(!0)}}})},100),setTimeout(function(){$(".top").affix()},100)})}(window.jQuery);