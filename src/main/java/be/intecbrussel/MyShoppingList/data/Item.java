package be.intecbrussel.MyShoppingList.data;

import javax.persistence.*;


@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable=false)
    private String itemName;

    @Column(nullable=false)
    private Integer amount;

    @Column(nullable=false)
    private Double price;

    private double totalPrice;


    public Item(String itemName, Integer amount, Double price) {
        this.itemName = itemName;
        this.amount = amount;
        this.price = price;
    }

    public Item() {

    }

    public double getTotalPrice() {
        return this.amount*this.price;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
