/*   
Template Name: Color Admin - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.2.0
Version: 1.4.0
Author: Sean Ngu
Website: http://www.seantheme.com/color-admin-v1.4/
*/var handleJqueryFileUpload=function(){$("#fileupload").fileupload({autoUpload:false,disableImageResize:/Android(?!.*Chrome)|Opera/.test(window.navigator.userAgent),maxFileSize:5e6,acceptFileTypes:/(\.|\/)(gif|jpe?g|png)$/i});$("#fileupload").fileupload("option","redirect",window.location.href.replace(/\/[^\/]*$/,"/cors/result.html?%s"));if($.support.cors){$.ajax({type:"HEAD"}).fail(function(){$('<div class="alert alert-danger"/>').text("Upload server currently unavailable - "+new Date).appendTo("#fileupload")})}$("#fileupload").addClass("fileupload-processing");$.ajax({url:$("#fileupload").fileupload("option","url"),dataType:"json",context:$("#fileupload")[0]}).always(function(){$(this).removeClass("fileupload-processing")}).done(function(e){$(this).fileupload("option","done").call(this,$.Event("done"),{result:e})})};var FormMultipleUpload=function(){"use strict";return{init:function(){handleJqueryFileUpload()}}}()
