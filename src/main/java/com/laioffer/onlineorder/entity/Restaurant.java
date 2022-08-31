package com.laioffer.onlineorder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 2455760938054036111L;

    @Id
    private int id;

    @OneToMany(mappedBy = "restaurant",//这说明fk是定义在对面的class里面，这个名字必须和menuItem里面的那个fk一样
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
            //eager operation: o load it together with the rest of the fields (eagerly)
            //lazy operation: To load it on-demand (i.e. lazily) when you call the restaurant's get method.
    )
    private List<MenuItem> menuItemList;

    private String address;

    private String name;

    private String phone;

    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }
}

