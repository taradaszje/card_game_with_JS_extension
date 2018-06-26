var madry = function(cardsPlayer,cardsComp,playerCard){
	var temp = -1;
	var temp2 = 50;
	for each (var el in cardsPlayer ){
		if(el>temp)
			temp=el;
	}	
	for each (var el in cardsComp ){
		if(el<temp2)
			temp2=el;	
	}
	for each (var el in cardsComp){
		if(el>playerCard)
			return el;
	}
	for each (var el in cardsComp ){
		if(el>temp){
			print(el);
			return el;
		}
	
		else {
			print(temp2);
			return temp2;
		}
	}	
}