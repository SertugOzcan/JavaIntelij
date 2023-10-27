package com.barisd.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // boş constructor oluşturur.
@AllArgsConstructor // dolu constructor oluşturur.
@Data
@Entity
@Table(name = "tblsepet")
public class Sepet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int urunid;


    public Sepet(int urunid) {
        this.urunid = urunid;
    }

}
