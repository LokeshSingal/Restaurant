package model;

import daoAbstract.Burger;


public class VegBurger extends Burger{
	private int id;
	private float price;
	private String name=this.getName();
	private String itemType="Burger";
	@Override
	public void setPrice(float price) {
		// TODO Auto-generated method stub
		this.price=price;
	}

	@Override
	public float getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setItemType(String itemType) {
		// TODO Auto-generated method stub
		this.itemType=itemType;
	}

	@Override
	public String getItemType() {
		// TODO Auto-generated method stub
		return itemType;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id=id;
	}

}
