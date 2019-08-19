package com.longnguyen.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuocGia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tenQuocGia;


    @OneToMany(targetEntity = ThanhPho.class)
    private List<ThanhPho> thanhPhos;

    public List<ThanhPho> getThanhPhos() {
        return thanhPhos;
    }

    public QuocGia() {
    }

    public void setThanhPhos(List<ThanhPho> thanhPhos) {
        this.thanhPhos = thanhPhos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }
}
