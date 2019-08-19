package com.longnguyen.model;

import javax.persistence.*;

@Entity
public class ThanhPho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tenThanhPho;
    private String quocgia;
    private double dienTich;
    private Long danSo;
    private Long GDP;
    private String moTaThanhPho;

    @ManyToOne(targetEntity = QuocGia.class)
    @JoinColumn(name = "quocgia_id")
    private QuocGia quocGia;

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public ThanhPho() {
    }

    public ThanhPho(QuocGia quocGia) {
        this.quocGia = quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    public void setQuocGia(String quocgia) {
        this.quocgia = quocgia;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public Long getDanSo() {
        return danSo;
    }

    public void setDanSo(Long danSo) {
        this.danSo = danSo;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getMoTaThanhPho() {
        return moTaThanhPho;
    }

    public void setMoTaThanhPho(String moTaThanhPho) {
        this.moTaThanhPho = moTaThanhPho;
    }
}
