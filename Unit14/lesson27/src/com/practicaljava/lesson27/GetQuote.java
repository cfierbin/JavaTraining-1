package com.practicaljava.lesson27;

import java.io.IOException;
import java.io.PrintWriter;

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
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetQuote() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		QuoteModel quote = new QuoteModel("MSFT", 100, 12.45);
		PrintWriter out = response.getWriter();
		out.println(quote.toJSON());
	}

}
