!function($){$.countdown.regionalOptions.bs={labels:["Godina","Mjeseci","Sedmica","Dana","Sati","Minuta","Sekundi"],labels1:["Godina","Mjesec","Sedmica","Dan","Sat","Minuta","Sekunda"],labels2:["Godine","Mjeseca","Sedmica","Dana","Sata","Minute","Sekunde"],compactLabels:["g","m","t","d"],whichLabels:function(amount){return 1==amount?1:amount>=2&&4>=amount?2:0},digits:["0","1","2","3","4","5","6","7","8","9"],timeSeparator:":",isRTL:!1},$.countdown.setDefaults($.countdown.regionalOptions.bs)}(jQuery);