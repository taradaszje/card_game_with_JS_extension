var random = function(cards){
	var wynik = Math.floor((Math.random() * cards.length) );
	
	print("Komp: "+cards[wynik]);
	
	return wynik;
	
};