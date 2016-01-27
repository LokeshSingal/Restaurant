package daoInterface;

public interface Item {
	public void setId(int id);
	public int getId();
	public void setItemType(String itemType);
	public String getItemType();
	public void setPrice(float price);
	public float getPrice();
	public void setName(String name);
	public String getName();
}
