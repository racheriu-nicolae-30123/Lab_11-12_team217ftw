package aut.utcluj.isp.ex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author stefan
 */
public class StockController {
    private List<String> productList;
    private Map<String, List<Product>> catalogue;

    public StockController(){
        this.productList = new ArrayList<>();
        this.catalogue = new HashMap<>();
    }

    /**
     * Add product to catalogue
     *
     * @param product  - product information
     * @param quantity - number of times the product should be added
     * @apiNote: if products with the same products id already exists, assume that @param product has the same data
     */
    public void addProductToCatalogue(final Product product, final int quantity) {
        if(!this.catalogue.containsKey(product.getId())) {
            this.productList.add(product.getId());
            this.catalogue.put(product.getId(), new ArrayList<Product>());
        }
        for (int i = 0; i < quantity; i++)
            this.catalogue.get(product.getId()).add(product);
    }

    /**
     * Return catalogue information
     *
     * @return dictionary where the key is the product id and the value is an array of products with the same id
     */
    public Map<String, List<Product>> getCatalogue() {
        return this.catalogue;
    }

    /**
     * Return all the products with particular id
     *
     * @param productId - unique product id
     * @return - list of existing products with same id or null if not found
     */
    public List<Product> getProductsWithSameId(final String productId) {
        return this.catalogue.get(productId);
    }

    /**
     * Get total number of products from catalogue
     *
     * @return
     */
    public int getTotalNumberOfProducts() {
        int products = 0;
        for(String productId: productList)
            products += catalogue.get(productId).size();

        return products;
    }

    /**
     * Remove all products with same product id
     *
     * @param productId - unique product id
     * @return true if at least one product was deleted or false instead
     */
    public boolean removeAllProductsWitProductId(final String productId) {
        if (this.catalogue.containsKey(productId))
            return this.catalogue.get(productId).removeAll(this.catalogue.get(productId));
        return false;

    }

    /**
     * Update the price for all the products with same product id
     *
     * @param productId - unique product id
     * @param price     - new price to be added
     * @return true if at least one product was updated or false instead
     */
    public boolean updateProductPriceByProductId(final String productId, final Double price) {
        if(this.catalogue.containsKey(productId)) {
            this.catalogue.get(productId).stream().filter(e -> e.getId() == productId).forEach(e -> e.setPrice(price));
            return this.catalogue.get(productId).stream().filter(e -> e.getId() == productId).collect(Collectors.toList()).size() > 0;
        }
        return false;
    }
}
