package com.practicaljava.unit2;

public class CurrencyConverter {

	static double fromUSDToEUR(double amountUSD) {
		return amountUSD * Config.USD_EUR_RATE;
	}

	static double fromEURToUSD(double amountEUR) {
		return amountEUR * Config.EUR_USD_RATE;
	}

}
