package ru.rkhayrit.computershop.model;

import jakarta.persistence.*;

@Entity
public class HardDisk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "serial_number", unique=true)
    private Integer serialNumber;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price")
    private Integer price;

    @Column(name = "available_On_The_Stock")
    private Integer availableOnTheStock;

    @Column(name = "volume")
    private Integer volume;

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

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
