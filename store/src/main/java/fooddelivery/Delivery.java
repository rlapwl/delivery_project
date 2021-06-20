package fooddelivery;

import javax.persistence.*;

@Entity
@Table(name="delivery_table")
public class Delivery {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long storeId;
    private Long orderId;

    private Delivery() {
    }

    public Delivery(Long storeId, Long orderId) {
        this.storeId = storeId;
        this.orderId = orderId;
    }

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this.getId(), this.getStoreId(), this.getOrderId());
        deliveryStarted.publishAfterCommit();
    }
    
    @PreRemove
    public void onPreRemove() {
        DeliveryCanceled deliveryCanceled = new DeliveryCanceled(this.getId(), this.getStoreId(), this.getOrderId());
        deliveryCanceled.publishAfterCommit();
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
