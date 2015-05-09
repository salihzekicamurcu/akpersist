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
public class PersonelOdemeGecmis {

    public int getPerID() {
        return PerID;
    }

    public void setPerID(int PerID) {
        this.PerID = PerID;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getOdenen() {
        return odenen;
    }

    public void setOdenen(String odenen) {
        this.odenen = odenen;
    }

    public String getBilgilendirme() {
        return bilgilendirme;
    }

    public void setBilgilendirme(String bilgilendirme) {
        this.bilgilendirme = bilgilendirme;
    }

    public PersonelOdemeGecmis(String tarih, String odenen, String bilgilendirme) {
        this.tarih = tarih;
        this.odenen = odenen;
        this.bilgilendirme = bilgilendirme;
    }

    public int PerID;
    public String tarih;
    public String odenen;
    public String bilgilendirme;

}
