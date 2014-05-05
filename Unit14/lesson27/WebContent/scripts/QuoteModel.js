/**
 * Observable Quote Model
 */
var ObservableQuoteModel = function(quote) {
	this.symbol = ko.observable(quote.symbol);
	this.price = ko.observable(quote.price);
	this.quantity = ko.observable(quote.quantity);
	this.textColor = ko.observable(quote.textColor);
};