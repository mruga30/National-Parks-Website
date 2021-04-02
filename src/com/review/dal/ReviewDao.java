package com.review.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.review.model.*;
import com.review.utilities.*;

public class ReviewDao implements DaoInterface<Review>{
	
	public static final String TABLE = "PARK_REVIEW";
	
	public ArrayList<Review> findAll() {
		
		ArrayList<Review> reviews = new ArrayList<>();

		Connection con = DbCon.getConnection();

		try {
			String qry = "select * from " + TABLE;
			PreparedStatement st = con.prepareStatement(qry);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Review review = new Review();
				review.setReviewId(rs.getInt(1));
				review.setUserName(rs.getNString(2));
				review.setReviewBody(rs.getNString(3));
				review.setReviewTitle(rs.getNString(4));
				review.setRating(rs.getInt(5));
				review.setRecommendation(rs.getInt(6));
				reviews.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return reviews;
	}

	
	public ArrayList<Review> searchByRating(int rating) {
		
		ArrayList<Review> reviews = new ArrayList<>();
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "SELECT * FROM " + TABLE + " WHERE RATING = ?";
			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1, rating);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Review review = new Review();
				review.setReviewId(rs.getInt(1));
				review.setUserName(rs.getNString(2));
				review.setReviewBody(rs.getNString(3));
				review.setReviewTitle(rs.getNString(4));
				review.setRating(rs.getInt(5));
				review.setRecommendation(rs.getInt(6));
				reviews.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return reviews;
	}


	public ArrayList<Review> searchByRecommendation(int recommendation) {
		
		ArrayList<Review> reviews = new ArrayList<>();
		
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "SELECT * FROM " + TABLE + " WHERE RECOMMENDATION = ?";
			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1, recommendation);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Review review = new Review();
				review.setReviewId(rs.getInt(1));
				review.setUserName(rs.getNString(2));
				review.setReviewBody(rs.getNString(3));
				review.setReviewTitle(rs.getNString(4));
				review.setRating(rs.getInt(5));
				review.setRecommendation(rs.getInt(6));
				reviews.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return reviews;
	}


	public void update(Review rev) {
		
		Connection con = DbCon.getConnection();

		try {
			String qry = "UPDATE " + TABLE + " SET REVIEW_BODY = ?, "+
					"REVIEW_TITLE = ?, RATING = ?, RECOMMENDATION = ? where REVIEW_ID = ?";
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, rev.getReviewBody());
			st.setString(2, rev.getReviewTitle());
			st.setInt(3, rev.getRating());
			st.setInt(4, rev.getRecommendation());
			st.setInt(5, rev.getReviewId());

			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
	}


	public void save(Review rev) {
		
		Connection con = DbCon.getConnection();

		try {
			String qry = "INSERT INTO " + TABLE + " VALUES (REVIEW_ID_SEQ.nextval, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, rev.getUserName());
			st.setString(2, rev.getReviewBody());
			st.setString(3, rev.getReviewTitle());
			st.setInt(4, rev.getRating());
			st.setInt(5, rev.getRecommendation());

			st.executeUpdate();
			System.out.println("Saved");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
	}


	public void delete(int id) {
		
		Connection con = DbCon.getConnection();

		try {

			String qry = "DELETE FROM " + TABLE + " where REVIEW_ID = ?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
	}


	@Override
	public Review getByName(String name) {
		
		Connection con = DbCon.getConnection();
		Review review = new Review();
		
		try {
			String qry = "SELECT * FROM " + TABLE + " WHERE FIRST_NAME = ?";
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, name);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				review.setReviewId(rs.getInt(1));
				review.setUserName(rs.getNString(2));
				review.setReviewBody(rs.getNString(3));
				review.setReviewTitle(rs.getNString(4));
				review.setRating(rs.getInt(5));
				review.setRecommendation(rs.getInt(6));
				System.out.println(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return review;
		
	}

}
