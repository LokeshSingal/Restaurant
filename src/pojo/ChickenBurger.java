package pojo;

public class ChickenBurger extends Burger{
	private float price;
	private String name;
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
		return  name;
	}

}
