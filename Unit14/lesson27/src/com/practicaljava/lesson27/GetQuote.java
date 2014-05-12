package com.practicaljava.lesson27;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practicaljava.lesson27.model.QuoteModel;

/**
 * Servlet implementation class GetQuote
 */
@WebServlet("/GetQuote")
public class GetQuote extends HttpServlet {
//	private static final long serialVersionUID = 1L;

	private final String[] symbols = { "APPL", "GOOG", "MSFT", "YNDX", "IBM", "YHOO", "ORCL" };
	private Random numericGenerator;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetQuote() {
		super();
		numericGenerator = new Random();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Create random quote
		QuoteModel quote = new QuoteModel(symbols[numericGenerator.nextInt(7)],
				numericGenerator.nextInt(100)+100, numericGenerator.nextDouble()
						+ numericGenerator.nextInt(100) + 90);

		// Send quote
		PrintWriter out = response.getWriter();
//		out.println(quote.toJSON());
		out.println("symbol: " + quote.symbol + " quantity: " + quote.quantity + " price: " + quote.price);
	}

}
