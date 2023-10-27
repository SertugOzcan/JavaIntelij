package org.barisd.repository.entity;

public class BaseEntity {
    int state;
    long olusturmatarihi;
    long guncellemetarihi;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getOlusturmatarihi() {
        return olusturmatarihi;
    }

    public void setOlusturmatarihi(long olusturmatarihi) {
        this.olusturmatarihi = olusturmatarihi;
    }

    public long getGuncellemetarihi() {
        return guncellemetarihi;
    }

    public void setGuncellemetarihi(long guncellemetarihi) {
        this.guncellemetarihi = guncellemetarihi;
    }
}
