package com.test.web.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by anasrekik on 16/06/15.
 */
@Entity
public class Provider implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    public Provider() {
    }

    public Provider(String title, Double latitude, Double longitude) {
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
