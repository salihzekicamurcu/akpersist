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
public class PersonelGirisCikisModel {

    public int getPerid() {
        return perid;
    }

    public void setPerid(int perid) {
        this.perid = perid;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public String getGirisTarih() {
        return girisTarih;
    }

    public void setGirisTarih(String girisTarih) {
        this.girisTarih = girisTarih;
    }

    public String getCikiTarih() {
        return cikiTarih;
    }

    public void setCikiTarih(String cikiTarih) {
        this.cikiTarih = cikiTarih;
    }

    public String getKurumAdi() {
        return kurumAdi;
    }

    public void setKurumAdi(String kurumAdi) {
        this.kurumAdi = kurumAdi;
    }

    public String getMesaiAdi() {
        return mesaiAdi;
    }

    public void setMesaiAdi(String mesaiAdi) {
        this.mesaiAdi = mesaiAdi;
    }

    public PersonelGirisCikisModel(int perid, String adsoyad, String girisTarih, String cikiTarih, String kurumAdi, String mesaiAdi) {
        this.perid = perid;
        this.adsoyad = adsoyad;
        this.girisTarih = girisTarih;
        this.cikiTarih = cikiTarih;
        this.kurumAdi = kurumAdi;
        this.mesaiAdi = mesaiAdi;
    }
    
    private int perid;
    private String adsoyad;
    private String girisTarih;
    private String cikiTarih;
    private String kurumAdi;
    private String mesaiAdi;
}
