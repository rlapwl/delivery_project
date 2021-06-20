package fooddelivery.external;

public class Payment {

    private Long id;
    private final Long orderId;
    private final Long storeId;
    private final int price;

    public Payment(Long orderId, Long storeId, int price) {
        this.orderId = orderId;
        this.storeId = storeId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }
    
    public Long getStoreId() {
        return storeId;
    }
    
    public int getPrice() {
        return price;
    }

}
