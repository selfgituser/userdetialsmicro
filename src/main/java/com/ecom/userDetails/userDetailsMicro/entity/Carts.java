package com.ecom.userDetails.userDetailsMicro.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "carts")
public class Carts implements Serializable  {

    private Integer id;
    private String Status;

    private Date createdAt;

    private Date updatedAt;

    private UserDetails user;
    @JsonManagedReference
    private List<cartItems> items;


    public Carts() {
    }

    public Carts(Integer id, String status, Date createdAt, Date updatedAt, UserDetails user, List<cartItems> items) {
        this.id = id;
        Status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.items = items;
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

    @Column(name = "status" , length = 20)
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
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

    @Column(name = "UPDATED_AT" , length = 7)
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @OneToOne
    @JoinColumn(name = "user_id")
    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
    public List<cartItems> getItems() {
        return items;
    }

    public void setItems(List<cartItems> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Carts{" +
                "id=" + id +
                ", Status='" + Status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", user=" + user +
                ", items=" + items +
                '}';
    }
}
