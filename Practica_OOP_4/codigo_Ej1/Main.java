package Practica_OOP_4.codigo_Ej1;

public class Main {
	
	public static void main(String args[]) {
		ShoppingCart shoppingCart = new ShoppingCart();
		
		Product product1 = new Product(1, "Product1", "Category1", -1.0, 2.0);
		Product product2 = new Product(2, "Product2", "Category2", 5.0, -6.0);
		Product product3 = new Product(3, "Product3", null, 5.0, 6.0);
		Product product4 = new Product(4, null, "Category4", 5.0, 6.0);
		Product product5 = new Product(4, "Product5", "Caregory5", 5.0, 6.0);
		Product product6 = new Product(-6, "Product6", "Caregory6", 5.0, 6.0);
		
		
		shoppingCart.addProduct(product1, 2);
		shoppingCart.addProduct(product2, 1);
		shoppingCart.addProduct(product3, 0);
		shoppingCart.addProduct(product4, -2);
		shoppingCart.addProduct(product5, 3);
		shoppingCart.addProduct(product6, 3);
		
		if(shoppingCart.removeProduct(product1) != null) {
			System.out.println("The product has been successfully deleted.");
		}
		
		shoppingCart.printShoppingCartContent();
	}
}