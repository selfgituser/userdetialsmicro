package com.ecom.userDetails.userDetailsMicro.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CART_ITEMS")
public class cartItems {

    private Integer id;
    private Long productId;
    private Integer quantity;
    private Double price;

    private Date createdAt;

    private Date updatedAt;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name= "cart_id")
    private Carts cart;


    public cartItems() {
    }

    public cartItems(Integer id, Long productId, Integer quantity, Double price, Date createdAt, Date updatedAt, Carts cart) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.cart = cart;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID" , unique = true , nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "product_id" , length = 100)
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column(name = "quantity" , length = 10)
    public Integer getQuantity() {
        return quantity;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(name = "price" , length = 20)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    @Column(name = "CREATED_AT" , length = 7)
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name = "UPDATED_AT" , length = 7)
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public Carts getCart() {
        return cart;
    }

    public void setCart(Carts cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "cartItems{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", cart=" + cart +
                '}';
    }
}
