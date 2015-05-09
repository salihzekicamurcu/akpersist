/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.topluIslemlerBean;

import com.personelyonetimsistem.model.PersonelGirisCikisModel;
import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import com.personelyonetimsistemi.personelBean.*;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author salih
 */
public class AnaSayfaBean extends VeritabaniIslem {

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public String getAy() {
        return ay;
    }

    public void setAy(String ay) {
        this.ay = ay;
    }

    public String getYil() {
        return yil;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    private String gun;
    private String ay = "4";
    private String yil = "2015";

    public List<String> getGunler() {
        return gunler;
    }

    public void setGunler(List<String> gunler) {
        this.gunler = gunler;
    }

    public List<String> getAylar() {
        return aylar;
    }

    public void setAylar(List<String> aylar) {
        this.aylar = aylar;
    }

    public List<String> getYillar() {
        return yillar;
    }

    public void setYillar(List<String> yillar) {
        this.yillar = yillar;
    }

    private List<String> gunler;
    private List<String> aylar;
    private List<String> yillar;

    public AnaSayfaBean() {
        gunler = new ArrayList<String>();
        aylar = new ArrayList<String>();
        yillar = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            gunler.add(new String("" + i));
        }
        for (int i = 1; i <= 12; i++) {
            aylar.add(new String("" + i));
        }
        for (int i = 2010; i <= 2030; i++) {
            yillar.add(new String("" + i));
        }
        girisCikisListele();

    }

    public String getBilgilendirmeMesaji() {
        return bilgilendirmeMesaji;
    }

    public void setBilgilendirmeMesaji(String bilgilendirmeMesaji) {
        this.bilgilendirmeMesaji = bilgilendirmeMesaji;
    }
    String bilgilendirmeMesaji;

    public List<PersonelGirisCikisModel> getGirisCikisListesi() {
        return girisCikisListesi;
    }

    public void setGirisCikisListesi(List<PersonelGirisCikisModel> girisCikisListesi) {
        this.girisCikisListesi = girisCikisListesi;
    }

    List<PersonelGirisCikisModel> girisCikisListesi;

    public List<PersonelGirisCikisModel> girisCikisListele() {
        girisCikisListesi = new ArrayList<PersonelGirisCikisModel>();
        this.bilgilendirmeMesaji = "Bugunun listesi:";
        try {

            SQLSorgu = "select * from hareketkayit where islemtarihi=?";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);

            java.util.Date today = new java.util.Date();
            this.bilgilendirmeMesaji += today.toString();
            this.Sorgu.setDate(1, new java.sql.Date(today.getTime()));

            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {

                sonuclar = Sorgu.getResultSet();
                while (this.sonuclar.next()) {
                    int db_perid = sonuclar.getInt(3);
                    String db_cikisTarih = "" + sonuclar.getString(4);
                    String db_girisTarih = "" + sonuclar.getString(5);
                    SQLSorgu = "select personel.ad,personel.soyad,personel.kurumid,mesaikayit.perid,mesaiplan.aciklama from mesaiplan,mesaikayit,personel "
                            + "where mesaiplan.mesaiplanid=mesaikayit.mesaiplanid and personel.perid=? and personel.perid=mesaikayit.perid";
                    Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                    this.Sorgu.setInt(1, db_perid);
                    boolean sonuc2 = Sorgu.execute();
                    ResultSet sonuclar2 = Sorgu.getResultSet();
                    if (sonuclar2.next()) {
                        String db_adsoyad = sonuclar2.getString(1) + " ";
                        db_adsoyad += sonuclar2.getString(2);
                        String db_kurumadi = sonuclar2.getString(3);
                        String db_mesaiadi = sonuclar2.getString(5);

                        girisCikisListesi.add(new PersonelGirisCikisModel(db_perid, db_adsoyad, db_girisTarih, db_cikisTarih, db_kurumadi, db_mesaiadi));
                    }

                }

            } else {
                //  this.aramaBilgilendirme = "İşlem Gerçekleştirilemedi";
            }
        } catch (Exception ex) {

        }
        return girisCikisListesi;
    }

    public void girisCikisAra(String pGun, String pAy, String pYil) {
        //  this.bilgilendirmeMesaji = "Gun:" + pGun + "Ay:" + pAy + "Yil:" + pYil;

        girisCikisListesi = new ArrayList<PersonelGirisCikisModel>();

        try {

            SQLSorgu = "select * from hareketkayit where islemtarihi = ?";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(pYil + "-" + pAy + "-" + pGun);

            this.Sorgu.setDate(1, new java.sql.Date(date.getTime()));
            this.bilgilendirmeMesaji = "Tarihe gore bilgilendirme:" + date.toString();
            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {

                sonuclar = Sorgu.getResultSet();
                while (this.sonuclar.next()) {
                    int db_perid = sonuclar.getInt(3);
                    String db_girisTarih = "" + sonuclar.getString(4);
                    String db_cikisTarih = "" + sonuclar.getString(5);
                    SQLSorgu = "select personel.ad,"
                            + "personel.soyad,"
                            + "personel.kurumid,"
                            + "mesaikayit.perid,"
                            + "mesaiplan.aciklama"
                            + " from mesaiplan,mesaikayit,personel "
                            + "where mesaiplan.mesaiplanid=mesaikayit.mesaiplanid and personel.perid=? and personel.perid=mesaikayit.perid";
                    // this.bilgilendirmeMesaji += SQLSorgu;
                    Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                    this.Sorgu.setInt(1, db_perid);
                    boolean sonuc2 = Sorgu.execute();
                    ResultSet sonuclar2 = Sorgu.getResultSet();
                    if (sonuclar2.next()) {
                        String db_adsoyad = sonuclar2.getString(1) + " ";
                        db_adsoyad += sonuclar2.getString(2);
                        String db_kurumadi = sonuclar2.getString(3);
                        String db_mesaiadi = sonuclar2.getString(5);
                        girisCikisListesi.add(new PersonelGirisCikisModel(db_perid, db_adsoyad, db_girisTarih, db_cikisTarih, db_kurumadi, db_mesaiadi));
                    }

                }

            } else {
                //  this.aramaBilgilendirme = "İşlem Gerçekleştirilemedi";
            }
        } catch (Exception ex) {
            this.bilgilendirmeMesaji = "Hata:Tarihe Göre Arama," + ex.getMessage();
        }

    }
}
