/**
 * 
 */
var WatchListViewModel = function() {

	var self = this;
	self.quotes = ko.observableArray([]);

	self.searchQuoteBySymbol = function(arr, symbol) {
		var quote = ko.utils.arrayFirst(arr, function(currentQuote) {
			return currentQuote.symbol() == symbol;
		});
		return quote;
	};

	self.onChange = function (){
	};
	
	self.updateQuote = function(quote) {

		$.extend(quote, {
			"textColor" : "blackColor"
		});

		var obsevableQuote = new ObservableQuoteModel(quote);

		var storedQuote = self.searchQuoteBySymbol(self.quotes(),
				obsevableQuote.symbol());

		if (storedQuote) {

			if (parseFloat(obsevableQuote.price()) >= parseFloat(storedQuote
					.price())) {
				obsevableQuote.textColor("greenColor");
			} else {
				obsevableQuote.textColor("redColor");
			}

			self.quotes.replace(storedQuote, obsevableQuote);
			self.onChange();
		}
	};

	self.addSymbol = function(symbol) {
		var storedQuote = self.searchQuoteBySymbol(self.quotes(), symbol);
		if (!storedQuote) {
			self.quotes.push(new ObservableQuoteModel({
				"symbol" : symbol,
				"price" : 0,
				"quantity" : 0,
				"textColor" : "blackColor"
			}));
			self.onChange();
		}
	};

};