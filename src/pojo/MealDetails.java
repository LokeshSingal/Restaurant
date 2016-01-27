package pojo;

public class MealDetails {
private int mealDetailsId;
private int mealId;
private int itemId;
private int qty;
private float price;
public int getMealDetailsId() {
	return mealDetailsId;
}
public void setMealDetailsId(int mealDetailsId) {
	this.mealDetailsId = mealDetailsId;
}
public int getMealId() {
	return mealId;
}
public void setMealId(int mealId) {
	this.mealId = mealId;
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
}
