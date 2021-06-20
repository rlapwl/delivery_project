package fooddelivery;

import javax.persistence.*;

@Entity
@Table(name="payments")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private Long storeId;
    private int price;

    @PostPersist
    public void onPostPersist() {
        PayApproved payApproved = new PayApproved(this.getId(), this.getOrderId(), this.getStoreId(), this.getPrice());
        payApproved.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        PayCanceled payCanceled = new PayCanceled(this.getId(), this.getOrderId(), this.getStoreId(), this.getPrice());
        payCanceled.publishAfterCommit();
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
