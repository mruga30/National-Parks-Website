package com.review.model;

public class Review {

	private int reviewId;
	private String userName;
	private String reviewTitle;
	private String reviewBody;
	private int rating;
	private int recommendation;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewBody() {
		return reviewBody;
	}

	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}
	
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", userName=" + userName + ", reviewTitle=" + reviewTitle
				+ ", reviewBody=" + reviewBody + ", rating=" + rating + ", recommendation=" + recommendation + "]";
	}

}
