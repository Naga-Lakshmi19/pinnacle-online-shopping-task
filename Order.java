import java.util.List;

public class Order {
    private User user;
    private List<CartItem> items;
    private double totalPrice;

    public Order(User user, List<CartItem> items, double totalPrice) {
        this.user = user;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
