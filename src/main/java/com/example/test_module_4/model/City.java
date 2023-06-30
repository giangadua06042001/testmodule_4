package com.example.test_module_4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenThanhpho;
    @ManyToOne
    private Country country;
    private double dienTich;
    private int danSo;
    private double GDP;
    private String motavethanhPho;




}
