!function($){$.fn.calendar=function(options){var args=$.extend({},$.fn.calendar.defaults,options);return this.each(function(){function showCalendar(){lblDaysMonth=$('<table class="daysmonth table table">'),list_week();var dateObj=new Date,dateText=elem.val();if(""!=dateText&&validateDate(dateText)){var dateTextArray=dateText.split("/");2==dateTextArray[2].length&&("0"==dateTextArray[2].charAt(0)&&(dateTextArray[2]=dateTextArray[2].substring(1)),dateTextArray[2]=parseInt(dateTextArray[2]),dateTextArray[2]<50&&(dateTextArray[2]+=2e3)),dateObj=new Date(dateTextArray[2],dateTextArray[1]-1,dateTextArray[0])}var month=dateObj.getMonth(),year=dateObj.getFullYear();showDaysOfMonth(month,year);var btnNextMonth=$('<td><i class="icon-arrow-right"></i></td>');btnNextMonth.click(function(e){e.stopPropagation(),e.preventDefault(),month=(month+1)%12,0==month&&year++,change_month(month,year)});var btnPrevMonth=$('<td><i class="icon-arrow-left"></i></td>');btnPrevMonth.click(function(e){e.stopPropagation(),e.preventDefault(),month-=1,-1==month&&(year--,month=11),change_month(month,year)}),$(".icon-arrow-left").css("cursor","pointer"),$(".icon-arrow-right").css("cursor","pointer");var lblDate=$('<table class="table header"><tr></tr></table>'),lblDateControl=$('<td colspan=5 class="year span6"></td>');lblDate.append(btnPrevMonth),lblDate.append(lblDateControl),lblDate.append(btnNextMonth),lblDateControl.append(lblTextMonth),calendar=$('<div class="calendar" id="'+calendar_id+'" ></div>'),calendar.prepend(lblDate),calendar.append(lblDaysMonth),elem.append(calendar),check_events(month,year)}function change_month(month,year){lblDaysMonth.empty(),list_week(),showDaysOfMonth(month,year),check_events(month,year)}function list_week(){if(0!=show_days){var lblWeek=$('<tr class="week_days" >'),insertCode="";$(days).each(function(key,value){insertCode+="<td",0==key&&(insertCode+=' class="first"'),6==key&&(insertCode+=' class="last"'),insertCode+=">"+value+"</td>"}),insertCode+="</tr>",lblWeek.append(insertCode),lblDaysMonth.append(lblWeek)}}function showDaysOfMonth(month,year){lblTextMonth.text(months[month]+" "+year);for(var day_counter=1,firstDay=calculateWeekday(1,month,year),lastDaymonth=lastDay(month,year),next_month=month+1,lblDaysMonth_string="",i=0;7>i;i++){if(firstDay>i){var dayCode="";0==i&&(dayCode+="<tr>"),dayCode+='<td class="invalid',0==i&&(dayCode+=" first"),dayCode+='"></td>'}else{var dayCode="";0==i&&(dayCode+="<tr>"),dayCode+='<td id="'+calendar_id+"_"+day_counter+"_"+next_month+"_"+year+'" ',0==i&&(dayCode+=' class="first"'),6==i&&(dayCode+=' class="last"'),dayCode+="><a>"+day_counter+"</a></span>",6==i&&(dayCode+="</tr>"),day_counter++}lblDaysMonth_string+=dayCode}for(var currentWeekDay=1;lastDaymonth>=day_counter;){var dayCode="";currentWeekDay%7==1&&(dayCode+="<tr>"),dayCode+='<td id="'+calendar_id+"_"+day_counter+"_"+next_month+"_"+year+'" ',currentWeekDay%7==1&&(dayCode+=' class="first"'),currentWeekDay%7==0&&(dayCode+=' class="last"'),dayCode+="><a>"+day_counter+"</a></td>",currentWeekDay%7==0&&(dayCode+="</tr>"),day_counter++,currentWeekDay++,lblDaysMonth_string+=dayCode}if(currentWeekDay--,currentWeekDay%7!=0){dayCode="";for(var i=currentWeekDay%7+1;7>=i;i++){var dayCode="";dayCode+='<td class="invalid',7==i&&(dayCode+=" last"),dayCode+='"></td>',7==i&&(dayCode+="</tr>"),lblDaysMonth_string+=dayCode}}lblDaysMonth.append(lblDaysMonth_string)}function calculateWeekday(day,month,year){var dateObj=new Date(year,month,day),numDay=dateObj.getDay();return numDay}function checkdate(m,d,y){return m>0&&13>m&&y>0&&32768>y&&d>0&&d<=new Date(y,m,0).getDate()}function lastDay(month,year){for(var last_day=28;checkdate(month+1,last_day+1,year);)last_day++;return last_day}function validateDate(date){var dateArray=date.split("/");return 3!=dateArray.length?!1:checkdate(dateArray[1],dateArray[0],dateArray[2])}function check_events(month,year){0!=req_ajax?$.ajax({type:req_ajax.type,url:req_ajax.url,data:{month:month+1,year:year},dataType:"json"}).done(function(data){events=[],$.each(data,function(k){events.push(data[k])}),markEvents(month,year)}):markEvents(month,year)}function markEvents(month,year){for(var t_month=month+1,i=0;i<events.length;i++)events[i][0].split("/")[1]==t_month&&events[i][0].split("/")[2]==year&&($("#"+calendar_id+"_"+events[i][0].replace(/\//g,"_")).addClass("event"),$("#"+calendar_id+"_"+events[i][0].replace(/\//g,"_")+" a").attr("data-original-title",events[i][1]),events[i][3]&&$("#"+calendar_id+"_"+events[i][0].replace(/\//g,"_")).css("background",events[i][3]),""==events[i][2]||"#"==events[i][2]?""!=events[i][4]?($("#"+calendar_id+"_"+events[i][0].replace(/\//g,"_")+" a").attr("data-trigger","manual"),$("#"+calendar_id+"_"+events[i][0].replace(/\//g,"_")+" a").addClass("manual_popover")):$("#"+calendar_id+"_"+events[i][0].replace(/\//g,"_")+" a").attr("href","javascript:false;"):$("#"+calendar_id+"_"+events[i][0].replace(/\//g,"_")+" a").attr("href",events[i][2]),events[i][4]?($("#"+calendar_id+"_"+events[i][0].replace(/\//g,"_")).addClass("event_popover"),$("#"+calendar_id+"_"+events[i][0].replace(/\//g,"_")+" a").attr("rel","popover"),$("#"+calendar_id+"_"+events[i][0].replace(/\//g,"_")+" a").attr("data-content",events[i][4])):($("#"+calendar_id+"_"+events[i][0].replace(/\//g,"_")).addClass("event_tooltip"),$("#"+calendar_id+"_"+events[i][0].replace(/\//g,"_")+" a").attr("rel","tooltip")));$("#"+calendar_id+" .event_tooltip a").tooltip(tooltip_options),$("#"+calendar_id+" .event_popover a").popover(popover_options),$(".manual_popover").click(function(){$(this).popover("toggle")})}var calendar,lblDaysMonth,days,lblTextMonth=$('<div class="visualmonthyear"></div>'),calendar_id="cal_"+Math.floor(99999*Math.random()).toString(36),events=args.events;days="undefined"!=typeof args.days?args.days:["S","M","T","W","T","F","S"];var months;months="undefined"!=typeof args.months?args.months:["January","February","March","April","May","June","July","August","September","October","November","December"];var show_days;show_days="undefined"!=typeof args.show_days?args.show_days:!0;var popover_options;popover_options="undefined"!=args.popover_options?args.popover_options:{placement:"top"};var tooltip_options;tooltip_options="undefined"!=typeof args.tooltip_options?args.tooltip_options:{placement:"top"};var req_ajax;req_ajax="undefined"!=typeof args.req_ajax?args.req_ajax:!1;var elem=$(this);showCalendar()}),this}}(jQuery);