function randInt(num){return Math.floor(Math.random()*num)}function getChar(){var code;return code=Math.random()<.05?randInt(10)+48:randInt(24)+65,String.fromCharCode(code)}function makeBigGraphProject(){for(var year=2001+randInt(11),i=Math.floor(2*Math.random()+3),title="";i--;)title+=getChar();var program=programs[randInt(programsLen)];return status=statuses[randInt(statusesLen)],scale=randInt(20),project='<div class="project '+program+'" data-year="'+year+'" data-program="'+program+'" data-scale="'+scale+'" data-status="'+status+'" ><div class="icon"></div><p class="title">'+title+"</p></div>"}var programs="commercial urbanism public-space culture body-culture health education housing hotel media".split(" "),programsLen=programs.length,statuses="idea in-progress under-construction completed".split(" "),statusesLen=statuses.length;