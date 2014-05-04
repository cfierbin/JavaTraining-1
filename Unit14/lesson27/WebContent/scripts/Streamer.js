/**
 * 
 */


var Streamer = function(){
	
	this.subscribers = {};
	
	this.subscribe = function(subscriber){
		//subscribers = 1;
	};
	
	this.getQuote = function(){
		
		return new QuoteModel("GOOG",12.33,100);
	};
	
	
};