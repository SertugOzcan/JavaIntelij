package com.barisd.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BaseEntity {
    /**
     * Tarih ve zaman damgası için genellikle Long veri türünü tabsiye ediyoruz. Zamanı ms cinsinden tutar.
     * Epoch time.
     */
    Long olusturmaTarihi;
    Long guncellemeTarihi;
    Integer durum;
}
