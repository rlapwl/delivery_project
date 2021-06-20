package fooddelivery;

import javax.persistence.*;

import fooddelivery.external.Payment;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long storeId;
    private String productName;
    private int quantity;
    private int price;
    private String status = "Order";

    @PostPersist
    public void onPostPersist() {

        Payment payment = new Payment(this.getId(), this.getStoreId(), this.getPrice() * this.getQuantity());
        OrderApplication.applicationContext.getBean(fooddelivery.external.PaymentService.class)
            .pay(payment);

        Ordered ordered = new Ordered(this.getId(), this.getStoreId(), this.getProductName(), this.getQuantity(), this.getPrice(), "Paid");
        ordered.publishAfterCommit();
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

    public void setStatus(String status) {
        this.status = status;
    }

}
