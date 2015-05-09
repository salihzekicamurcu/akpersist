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
public class MesaiPlanListesi {

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public String getMesaietiket() {
        return mesaietiket;
    }

    public void setMesaietiket(String mesaietiket) {
        this.mesaietiket = mesaietiket;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getBilgi() {
        return bilgi;
    }

    public void setBilgi(String bilgi) {
        this.bilgi = bilgi;
    }

    public int getMesaiid() {
        return mesaiid;
    }

    public void setMesaiid(int mesaiid) {
        this.mesaiid = mesaiid;
    }

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    private String adsoyad;
    private String mesaietiket;
    private String tarih;
    private String bilgi;
    private int mesaiid;
    private int perId;

   

    public MesaiPlanListesi(String adsoyad, String mesaietiket, String tarih, String bilgi, int mesaiid, int perId) {
        this.adsoyad = adsoyad;
        this.mesaietiket = mesaietiket;
        this.tarih = tarih;
        this.bilgi = bilgi;
        this.mesaiid = mesaiid;
        this.perId = perId;
    }

}
