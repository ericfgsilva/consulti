var fakeElement={};fakeElement.constanants="b c d f g k l m n p q r s t v x z".split(" "),fakeElement.vowels="a e i o u y".split(" "),fakeElement.categories="alkali alkaline-earth lanthanoid actinoid transition post-transition".split(" "),fakeElement.suffices="on ium ogen".split(" "),fakeElement.getRandom=function(property){var values=fakeElement[property];return values[Math.floor(Math.random()*values.length)]},fakeElement.create=function(){var widthClass=10*Math.random()>6?"width2":"width1";return heightClass=10*Math.random()>6?"height2":"height1",category=fakeElement.getRandom("categories"),className="element fake metal "+category+" "+widthClass+" "+heightClass,letter1=fakeElement.getRandom("constanants").toUpperCase(),letter2=fakeElement.getRandom("constanants"),symbol=letter1+letter2,name=letter1+fakeElement.getRandom("vowels")+letter2+fakeElement.getRandom("vowels")+fakeElement.getRandom("constanants")+fakeElement.getRandom("suffices"),number=~~(21+100*Math.random()),weight=~~(2*number+15*Math.random()),'<div class="'+className+'" data-symbol="'+symbol+'" data-category="'+category+'"><p class="number">'+number+'</p><h3 class="symbol">'+symbol+'</h3><h2 class="name">'+name+'</h2><p class="weight">'+weight+"</p></div>"},fakeElement.getGroup=function(){for(var i=Math.ceil(3*Math.random()+1),newEls="";i--;)newEls+=fakeElement.create();return newEls};