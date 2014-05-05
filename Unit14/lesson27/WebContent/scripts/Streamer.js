/**
 * Quote Streamer Client
 */

var Streamer = function() {

	var self = this;
	self.subscribers = [];

	self.subscribe = function(subscriber) {
		self.subscribers.push(subscriber);
	};

	self.updateQuote = function() {
		$.get("./GetQuote", function(quoteJSON) {

			if (quoteJSON) {
				var quote = $.parseJSON(quoteJSON);
				console.log(quote);

				if (self.subscribers && self.subscribers.length > 0) {
					$.each(self.subscribers, function(index, subscriber) {
						if (subscriber.updateQuote)
							subscriber.updateQuote(quote);
					});
				}
			}
		});
	};

	self.start = function() {
		window.setInterval(function() {
			self.updateQuote();
		}, 300);
	};

	self.start();

};
