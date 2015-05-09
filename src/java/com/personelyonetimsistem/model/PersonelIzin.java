/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistem.model;

/**
 *
 * @author salih
 */
public class PersonelIzin {

    public PersonelIzin(int perID, String adsoyad, String aciklama, String izinBaslangic, String izinBitis) {
        this.aciklama = aciklama;
        this.adsoyad = adsoyad;
        this.perID = perID;
        this.izinBaslangic = izinBaslangic;
        this.izinBitis = izinBitis;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public int getPerID() {
        return perID;
    }

    public void setPerID(int perID) {
        this.perID = perID;
    }

    public String getIzinBaslangic() {
        return izinBaslangic;
    }

    public void setIzinBaslangic(String izinBaslangic) {
        this.izinBaslangic = izinBaslangic;
    }

    public String getIzinBitis() {
        return izinBitis;
    }

    public void setIzinBitis(String izinBitis) {
        this.izinBitis = izinBitis;
    }

    private String aciklama;
    private String adsoyad;
    private int perID;
    private String izinBaslangic;
    private String izinBitis;
}
