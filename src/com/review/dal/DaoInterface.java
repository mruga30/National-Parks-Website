package com.review.dal;

import java.util.ArrayList;

public interface DaoInterface<T> {
	
	ArrayList<T> findAll();
	
	ArrayList<T> searchByRating(int rating);
	
	ArrayList<T> searchByRecommendation(int recommendation);
	
	
	T getByName(String name);
	
	void update(T obj);
	
	void save(T obj);
	
	void delete(int id);
	
}