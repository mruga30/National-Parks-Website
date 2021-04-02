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
 * Servlet implementation class ReviewWriteServlet
 */
public class ReviewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReviewService service = new ReviewService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/html/ReviewPages/insert.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get all fields from the form and create a review object.
		String action = request.getParameter("action");
		String userName = request.getParameter("firstName");
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewBody = request.getParameter("reviewBody");
		int rating = Integer.parseInt(request.getParameter("rating"));
		int recommendation = Integer.parseInt(request.getParameter("recommendation"));

		Review review = new Review();
		review.setUserName(userName);
		review.setReviewTitle(reviewTitle);
		review.setReviewBody(reviewBody);
		review.setRating(rating);
		review.setRecommendation(recommendation);
		
		PrintWriter out = response.getWriter();
		
		if(action.contentEquals("add")) {
			
			// Check if the fields are empty and display error message.
			if(userName.isEmpty() || reviewTitle.isEmpty() || reviewBody.isEmpty()) {
				
				out.println("<meta http-equiv='refresh' content='3';URL='html/ReviewPages/insert.jsp'>");
				out.println("<p style='color:red;'>Fields can not be empty! Redirecting in 3 secs.</p>");
			
			}
			
			// Check if User already exists
			else if (service.hasName(userName)) {
				
				out.println("<meta http-equiv='refresh' content='3';URL='html/ReviewPages/insert.jsp'>");
				out.println("<p style='color:red;'>User already exists! Redirecting in 3 secs.</p>");
				
			}
			
			else {
				
				service.save(review);
				ArrayList<Review> reviews = service.findAll();
				HttpSession session = request.getSession();
				session.setAttribute("reviews", reviews);
				request.getRequestDispatcher("/html/ReviewPages/displayReviews.jsp").forward(request, response);
				
			}
			
		}
		
		else if(action.contentEquals("Update")){
			
			int id = Integer.parseInt(request.getParameter("review_id"));
			review.setReviewId(id);

			// Check if the fields are empty and display error message.
			if (reviewTitle.isEmpty() || reviewBody.isEmpty()) {
							
				out.println("<meta http-equiv='refresh' content='3';URL='/html/ReviewPages/displayReviews.jsp'>");
				out.println("<p style='color:red;'>Fields can not be empty! Redirecting in 3 secs.</p>");
						
			}
			
			else {
				
				service.update(review);
				ArrayList<Review> reviews = service.findAll();
				HttpSession session = request.getSession();
				session.setAttribute("reviews", reviews);
				request.getRequestDispatcher("/html/ReviewPages/displayReviews.jsp").forward(request, response);
				
			}
			
		}
		
		else if (action.contentEquals("Delete")){
			
			int id = Integer.parseInt(request.getParameter("review_id"));
			service.delete(id);
			ArrayList<Review> reviews = service.findAll();
			HttpSession session = request.getSession();
			session.setAttribute("reviews", reviews);
			request.getRequestDispatcher("/html/ReviewPages/displayReviews.jsp").forward(request, response);
			
		}
		
	}
	
}

