package com.review.service;

import java.util.ArrayList;

import com.review.dal.ReviewDao;
import com.review.model.Review;

public class ReviewService {

	private ReviewDao dao = new ReviewDao();
	
	public ArrayList<Review> findAll(){
		return dao.findAll();
	}
	
	public ArrayList<Review> searchByRating(int rating){
		return dao.searchByRating(rating);
	}
	
	public ArrayList<Review> searchByRecommendation(int recommendation){
		return dao.searchByRecommendation(recommendation);
	}
	
	public Review getByName(String name) {
		return dao.getByName(name);
	}
	
	public void update(Review rev) {
		dao.update(rev);
	}
	
	public void save(Review rev) {
		dao.save(rev);
	}
	
	public void delete(int id) {
		dao.delete(id);
	}
	
	// Checks if name already exists in database
	public boolean hasName(String name) {
		boolean check = false;
		
		ArrayList<Review> reviews = dao.findAll();
		for(Review review: reviews) {
			if(review.getUserName().equals(name)) {
				check = true;
			}
		}
		
		return check;
	}
	
}
