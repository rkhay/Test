package ru.rkhayrit.computershop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class NoteBook {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "serial_number", unique=true)
    private Integer serialNumber;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price")
    private Integer price;

    @Column(name = "available_On_The_Stock")
    private Integer availableOnTheStock;

    @Column(name = "size")
    private Integer size;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAvailableOnTheStock() {
        return availableOnTheStock;
    }

    public void setAvailableOnTheStock(Integer availableOnTheStock) {
        this.availableOnTheStock = availableOnTheStock;
    }

}
