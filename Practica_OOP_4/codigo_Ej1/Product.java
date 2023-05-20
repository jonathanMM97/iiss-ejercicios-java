package Practica_OOP_4.codigo_Ej1;

public class Product {

    private int code;
    private String name;
    private String category;
    private double weight;
    private double height;

    public Product(int code, String name, String category, double weight, double height) {
        assert code >= 0 : "Code cannot be negative";
        assert name != null && !name.isEmpty() : "Name cannot be null or empty";
        assert category != null && !category.isEmpty() : "Category cannot be null or empty";
        assert weight >= 0 : "Weight cannot be negative";
        assert height >= 0 : "Height cannot be negative";

        this.code = code;
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.height = height;
    }

    public int getCode() {
		return code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return this.height;
	}
}
