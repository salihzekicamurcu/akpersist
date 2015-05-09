/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.personelBean;

import com.personelyonetimsistem.model.*;
import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import java.util.ArrayList;

/**
 *
 * @author salih
 */
public class PersonelMuhasebeGecmisi extends VeritabaniIslem {

    public String getPerID() {
        return perID;
    }

    public void setPerID(String perID) {
        this.perID = perID;
    }

    public String getPersonelSoyad() {
        return personelSoyad;
    }

    public void setPersonelSoyad(String personelSoyad) {
        this.personelSoyad = personelSoyad;
    }

    public String getPersonelAd() {
        return personelAd;
    }

    public void setPersonelAd(String personelAd) {
        this.personelAd = personelAd;
    }
    private String personelSoyad;
    private String personelAd;
    private String perID;
    public String uyariMesaji;

    public String getPersonelBolum() {
        return personelBolum;
    }

    public void setPersonelBolum(String personelBolum) {
        this.personelBolum = personelBolum;
    }
    private String personelBolum;

    public String getUyariMesaji() {
        return uyariMesaji;
    }

    public void setUyariMesaji(String uyariMesaji) {
        this.uyariMesaji = uyariMesaji;
    }

    public ArrayList<PersonelOdemeGecmis> getPersonelOdemeGecmisListesi() {
        return personelOdemeGecmisListesi;
    }

    public void setPersonelOdemeGecmisListesi(ArrayList<PersonelOdemeGecmis> personelOdemeGecmisListesi) {
        this.personelOdemeGecmisListesi = personelOdemeGecmisListesi;
    }

    private ArrayList<PersonelOdemeGecmis> personelOdemeGecmisListesi;

    public PersonelMuhasebeGecmisi() {
        sorgula();
    }

    public void sorgula() {
        personelOdemeGecmisListesi=new ArrayList<PersonelOdemeGecmis>();
        int int_perid = 0;
        try {
            personelBilgileriYukle();
            int_perid = Integer.parseInt(this.perID);
            SQLSorgu = "select tarih,odenen,bilgi   from odeme  where perid=?";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            Sorgu.setInt(1, int_perid);
            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {
                this.uyariMesaji = "Bilgi var";
                sonuclar = Sorgu.getResultSet();
                while (this.sonuclar.next()) {
                    String p_tarih = sonuclar.getString(1);
                    double p_odenen = sonuclar.getDouble(2);
                    String p_bilgilendirme = sonuclar.getString(3);
                    PersonelOdemeGecmis nesne = new PersonelOdemeGecmis(p_tarih, "" + p_odenen, "" + p_bilgilendirme);
                    personelOdemeGecmisListesi.add(nesne);
                }
            } else {
                this.uyariMesaji = "bilgi yok";
            }

        } catch (Exception ex) {

        }
        this.uyariMesaji += "Sayac:";
    }

    public void personelBilgileriYukle() {
        int int_perid = 0;
        try {
            int_perid = Integer.parseInt(this.perID);
            SQLSorgu = "select "
                    + "personel.perid,"
                    + "personel.ad,"
                    + "personel.soyad,personel.kurumid from personel where perid=?  ";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            Sorgu.setInt(1, int_perid);
            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {

                sonuclar = Sorgu.getResultSet();
                try {
                    if (this.sonuclar.next()) {

                        this.perID = "" + sonuclar.getInt(1);
                        this.personelAd = sonuclar.getString(2);
                        this.personelSoyad = sonuclar.getString(3);
                        this.personelBolum = sonuclar.getString(4);
                    } else {
                        this.uyariMesaji = "Personel Bulunamadi";
                    }
                } catch (Exception ex) {

                }

            }

        } catch (Exception ex) {

        }
    }

}
