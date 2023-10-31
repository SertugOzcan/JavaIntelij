package com.barisd.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tblsatisdetay")
public class SatisDetay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long satisId;
    Long urunid;
    Integer adet;
    BigDecimal fiyat;
    BigDecimal toplamFiyat;
    @Embedded
    BaseEntity baseEntity;
}
