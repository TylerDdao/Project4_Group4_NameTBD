package Main;

public class Plant {
	private int id;
	private String name;
	private float price;
	private int quantity;
	private String imagePath;
	
	public Plant() {
		this.id = -1;
		this.name = null;
		this.price = 0;
		this.quantity = -1;
		this.imagePath = null;
	}
	
	public Plant(int id, String name, float price, int quantity, String imagePath) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.imagePath = imagePath;
	}
	
	public int GetId() {
		return id;
	}
	
	public void SetQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String GetName() {
		return name;
	}
	
	public float GetPrice() {
		return price;
	}
	
	public int GetQuantity() {
		return quantity;
	}
	
	public String GetImagePath() {
		return imagePath;
	}
}