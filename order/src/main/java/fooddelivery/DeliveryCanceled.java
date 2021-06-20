
package fooddelivery;

public class DeliveryCanceled extends AbstractEvent {

    private final Long id;
    private final Long storeId;
    private final Long orderId;

    public DeliveryCanceled(Long id, Long storeId, Long orderId) {
        this.id = id;
        this.storeId = storeId;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public Long getOrderId() {
        return orderId;
    }
}

