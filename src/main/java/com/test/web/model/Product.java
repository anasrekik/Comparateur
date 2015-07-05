package com.test.web.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by anasrekik on 12/06/15.
 */
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String label;

    @Column
    private Float price;

    @Column
    private String mark;

    @Column
    private String category;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Provider provider;

    @Column
    private String barcode;

    @Column
    @Lob
    private byte[] image;

    public Product() {
    }

    public Product(String label, Float price, String mark, String category, Provider provider, String barcode, byte[] image) {
        this.label = label;
        this.price = price;
        this.mark = mark;
        this.category = category;
        this.provider = provider;
        this.barcode = barcode;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
