package com.test;

import java.util.ArrayList;

import com.review.dal.ReviewDao;
import com.review.model.Review;

public class ReviewDemo {
	
	private static ReviewDao dao = new ReviewDao();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Review> reviews = new ArrayList<>();
		reviews = dao.searchByRating(5);
		for(Review review: reviews) {
			System.out.println(review);
		}
		
		Review review = new Review();
		review = dao.getByName("Krishnil Prasad");
		System.out.println(review);
		
		Review review2 = dao.getByName("Test One");
		System.out.println(review2);
		
		review2.setUserName("Tester");
		dao.update(review2);
		
	}


}
