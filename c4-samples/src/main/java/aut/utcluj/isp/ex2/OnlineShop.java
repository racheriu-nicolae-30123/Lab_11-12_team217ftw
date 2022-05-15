package aut.utcluj.isp.ex2;

import java.util.Objects;

/**
 * @author stefan
 */
public class OnlineShop {
    private Shop shop;
    private String webAddress;

    public OnlineShop(String name, String city, String webAddress) {
        this.shop = new Shop(name, city);
        this.webAddress = webAddress;
    }

    public Shop getShop() {
        return shop;
    }

    public String getWebAddress() {
        return webAddress;
    }

    @Override
    public String toString() {
        return "Shop: " + shop.getName() + " City: " + shop.getCity() + " Web address: " + webAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnlineShop that = (OnlineShop) o;
        return Objects.equals(shop, that.shop) && Objects.equals(webAddress, that.webAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shop, webAddress);
    }
}
