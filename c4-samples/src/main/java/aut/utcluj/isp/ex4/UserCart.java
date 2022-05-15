package aut.utcluj.isp.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author stefan
 */
public class UserCart implements ICartDetails{
    private List<Product> cartProducts;
    private double totalPrice;

    public UserCart(){
        this.cartProducts = new ArrayList<>();
        this.totalPrice = 0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getCardProducts() {
        return cartProducts;
    }

    /**
     * Add new product to user cart
     *
     * @param product  - product to be added
     * @param quantity - number of products of the same type to be added
     */
    public void addProductToCart(final Product product, int quantity) {
        for(int i = 0; i < quantity; i++) {
            this.cartProducts.add(product);
            totalPrice += product.getPrice();
        }
    }

    /**
     * Remove one product with product id from cart
     * If the product with desired id not found in the card, an {@link ProductNotFoundException} exception will be thrown
     *
     * @param productId - unique product id
     */
    public void removeProductFromCart(final String productId) throws ProductNotFoundException {
        for(Product product: this.cartProducts)
            if(product.getProductId().equals(productId)){
                this.cartProducts.remove(product);
                this.totalPrice -= product.getPrice();
                return;
            }
        throw new ProductNotFoundException();
    }

    /**
     * Reset user cart
     * Reset products and total price to default values
     */
    public void resetCart() {
        this.cartProducts = new ArrayList<>();
        this.totalPrice = 0;
    }

    public List<String> getAllProdutIds(){
        List<String> productIds = new ArrayList<>();
        for(Product product: this.cartProducts)
            if(!productIds.contains(product.getProductId()))
                productIds.add(product.getProductId());
        return productIds;
    }

    public int getItemsOfProduct(final String productId){
        return (int) this.cartProducts.stream().filter(e -> e.getProductId().equals(productId)).count();
    }


    @Override
    public String getCartDetails() {
        String result = "";
        List<String> ids = this.getAllProdutIds();
        for (String id: ids){
            result = result + "Product id: " + id + ", Items: " + this.getItemsOfProduct(id) + "\n";
        }
        result = result + "Total price: " + this.totalPrice;
        return  result;
    }
}
