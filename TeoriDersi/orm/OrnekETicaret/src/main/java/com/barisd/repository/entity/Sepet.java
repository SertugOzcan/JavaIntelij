package com.barisd.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@NoArgsConstructor // boş constructor oluşturur.
@AllArgsConstructor // dolu constructor oluşturur.
@Data
@Entity
@Builder
@Table(name = "tblsepet")
public class Sepet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /*
    K-> urun idleri olacak.
    V-> adetleri olacak.
     */
    @ElementCollection
    Map<Long,Integer> urunids;

    Long musteriid;

    @Embedded
    BaseEntity baseEntity;
}
