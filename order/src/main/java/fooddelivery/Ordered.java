package fooddelivery;

public class Ordered extends AbstractEvent {

    private final Long id;
    private final Long storeId;
    private final String productName;
    private final int quantity;
    private final int price;
    private final String status;
    
    public Ordered(Long id, Long storeId, String productName, int quantity, int price, String status) {
        this.id = id;
        this.storeId = storeId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
    
}
