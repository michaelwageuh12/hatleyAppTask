package com.example.hatley.task.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supermarkets")
public class SuperMarket {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "arabic_name")
    private String arabicName;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "address")
    private String address;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "active")
    private Boolean active = true;
}
