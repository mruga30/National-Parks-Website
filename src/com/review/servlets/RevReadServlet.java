package com.review.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.model.Review;
import com.review.service.ReviewService;

/**
 * Servlet implementation class RevReadServlet
 */
public class RevReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReviewService service = new ReviewService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			ArrayList<Review> reviews = service.findAll();
			HttpSession session = request.getSession();
			session.setAttribute("reviews", reviews);
			request.getRequestDispatcher("/html/ReviewPages/displayReviews.jsp").forward(request, response);
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String name = request.getParameter("fullName");
		PrintWriter out = response.getWriter();
		
		if (action.contentEquals("Search by Full Name:")) {
			
			if (name.isEmpty()) {
				
				out.println("<meta http-equiv='refresh' content='3';URL='html/ReviewPages/displayReviews.jsp'>");
				out.println("<p style='color:red;'>Fields can not be empty! Redirecting in 3 secs.</p>");
				
			}
			
			else {
				
				Review review = service.getByName(name);
				System.out.println(review);
				
				if(!service.hasName(name)) {
					
					out.println("<meta http-equiv='refresh' content='3';URL='html/ReviewPages/displayReviews.jsp'>");
					out.println("<p style='color:red;'>Oops, looks like your review does not exist. Add a new review! Redirecting in 3 secs.</p>");
					
				}
				
				else {
					
					HttpSession session = request.getSession();
					session.setAttribute("review", review);
					request.getRequestDispatcher("/html/ReviewPages/update.jsp").forward(request, response);
					
				}
				
			}
			
		}
		
		else if (action.contentEquals("Search by Rating:")) {
			
			int rating = Integer.parseInt(request.getParameter("rating"));
			ArrayList<Review> reviews = service.searchByRating(rating);
			HttpSession session = request.getSession();
			session.setAttribute("reviews", reviews);
			request.getRequestDispatcher("/html/ReviewPages/displayReviews.jsp").forward(request, response);
			
		}
		
		else if (action.contentEquals("Search by Recommendation:")) {
			
			int recommendation = Integer.parseInt(request.getParameter("recommendation"));
			ArrayList<Review> reviews = service.searchByRecommendation(recommendation);
			HttpSession session = request.getSession();
			session.setAttribute("reviews", reviews);
			request.getRequestDispatcher("/html/ReviewPages/displayReviews.jsp").forward(request, response);
			
		}
		
	}

}
