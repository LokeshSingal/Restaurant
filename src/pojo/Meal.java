package pojo;

import java.sql.Timestamp;

public class Meal {
	public int getMealId() {
		return mealId;
	}
	public void setMealId(int mealId) {
		this.mealId = mealId;
	}
	public Timestamp getMealTime() {
		return mealTime;
	}
	public void setMealTime(Timestamp mealTime) {
		this.mealTime = mealTime;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	private int mealId;
	private Timestamp mealTime;
	private float totalPrice;
}
