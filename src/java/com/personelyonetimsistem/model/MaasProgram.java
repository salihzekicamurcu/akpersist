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
public class MaasProgram {

    public MaasProgram(int PerID, String Donem, String Maas, String Kesinti, String Avans, String ekMesai,String toplam) {
        this.PerID = PerID;
        this.Donem = Donem;
        this.Maas = Maas;
        this.Kesinti = Kesinti;
        this.Avans = Avans;
        this.ekMesai = ekMesai;
        this.Ad = Ad;
        this.Soyad = Soyad;
        this.toplam=toplam;
       //this.toplam =  Float.parseFloat(this.Maas) + Float.parseFloat(this.Avans) + Float.parseFloat(this.ekMesai)-Float.parseFloat(this.Kesinti);
    }

    public int getPerID() {
        return PerID;
    }

    public void setPerID(int PerID) {
        this.PerID = PerID;
    }

    public String getDonem() {
        return Donem;
    }

    public void setDonem(String Donem) {
        this.Donem = Donem;
    }

    public String getMaas() {
        return Maas;
    }

    public void setMaas(String Maas) {
        this.Maas = Maas;
    }

    public String getKesinti() {
        return Kesinti;
    }

    public void setKesinti(String Kesinti) {
        this.Kesinti = Kesinti;
    }

    public String getAvans() {
        return Avans;
    }

    public void setAvans(String Avans) {
        this.Avans = Avans;
    }

    public String getEkMesai() {
        return ekMesai;
    }

    public void setEkMesai(String ekMesai) {
        this.ekMesai = ekMesai;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    private int PerID;
    private String Donem;
    private String Maas;
    private String Kesinti;

    private String Avans;
    private String ekMesai;
    private String Ad;
    private String Soyad;
    private String toplam ;

    public String getToplam() {

        return toplam;
    }

    public void setToplam(String toplam) {
        this.toplam = toplam;
    }

}
