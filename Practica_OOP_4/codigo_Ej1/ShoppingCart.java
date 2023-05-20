package Practica_OOP_4.codigo_Ej1;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    Map<Product, Integer> shoppingCart;

    public ShoppingCart() {
        shoppingCart = new HashMap<Product, Integer>();
    }

    public void addProduct(Product product, int number) {
        assert number > 0 : "Number of units must be greater than zero";
        assert !shoppingCart.containsKey(product) : "Product already exists in the shopping cart";

        shoppingCart.put(product, number);
    }

    public Product removeProduct(Product product) {
        assert shoppingCart.containsKey(product) : "Product does not exist in the shopping cart";

        shoppingCart.remove(product);
        return product;
    }

    public void printShoppingCartContent() {
		System.out.println("The shopping cart content is: ");
		
		for(Product product: shoppingCart.keySet()) {
			System.out.println(product.getCode() + " - " + product.getName() + " : " + shoppingCart.get(product));
		}
		
	}
}
