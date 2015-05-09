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
public class ManyetikKartListesiModel {

    public int getPerid() {
        return perid;
    }

    public void setPerid(int perid) {
        this.perid = perid;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public int getKartNumarasi() {
        return kartNumarasi;
    }

    public void setKartNumarasi(int kartNumarasi) {
        this.kartNumarasi = kartNumarasi;
    }

    public String getVerilisTarihi() {
        return verilisTarihi;
    }

    public void setVerilisTarihi(String verilisTarihi) {
        this.verilisTarihi = verilisTarihi;
    }

    public String getAlisTarihi() {
        return alisTarihi;
    }

    public void setAlisTarihi(String alisTarihi) {
        this.alisTarihi = alisTarihi;
    }



    public ManyetikKartListesiModel(int perid, String adSoyad, int kartNumarasi, String verilisTarihi, String alisTarihi, String notu) {
        this.perid = perid;
        this.adSoyad = adSoyad;
        this.kartNumarasi = kartNumarasi;
        this.verilisTarihi = verilisTarihi;
        this.alisTarihi = alisTarihi;
        this.aciklama = notu;
    }
  
    public int perid;
    public String adSoyad;
    public int kartNumarasi;
    public String verilisTarihi;
    public String alisTarihi;

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
    public String aciklama;
    
}
