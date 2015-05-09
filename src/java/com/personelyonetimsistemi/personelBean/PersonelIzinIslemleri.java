/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.personelBean;

import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import com.personelyonetimsistem.model.MaasProgram;
import com.personelyonetimsistem.model.PersonelIzin;
import java.sql.ResultSet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author salih
 */
public class PersonelIzinIslemleri extends VeritabaniIslem {

    public int getPerID() {
        return perID;
    }

    public void setPerID(int perID) {
        this.perID = perID;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getSure() {
        return sure;
    }

    public void setSure(int sure) {
        this.sure = sure;
    }

    public String getTarih() {
        return tarih;
    }

    /**
     * Creates a new instance of PersonelIzınIslemleri
     */
    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    private int perID;
    private String aciklama;
    private int sure;
    private String tarih;
    Date sonTarihi;

    public String getAramaBilgilendirme() {
        return aramaBilgilendirme;
    }

    public void setAramaBilgilendirme(String aramaBilgilendirme) {
        this.aramaBilgilendirme = aramaBilgilendirme;
    }
    private String aramaBilgilendirme;

    public String getAranan() {
        return aranan;
    }

    public void setAranan(String aranan) {
        this.aranan = aranan;
    }
    private String aranan;

    public String getSonTarih() {
        return sonTarih;
    }

    public void setSonTarih(String sonTarih) {
        this.sonTarih = sonTarih;
    }
    private String sonTarih;
    private String adSoyad;
    Date simdikiZaman;

    public String getBilgilendirmeMesaj() {
        return bilgilendirmeMesaj;
    }

    public void setBilgilendirmeMesaj(String bilgilendirmeMesaj) {
        this.bilgilendirmeMesaj = bilgilendirmeMesaj;
    }
    public String bilgilendirmeMesaj;

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public PersonelIzinIslemleri() {
        simdikiZaman = new Date();
        // System.out.println(simdikiZaman.toString());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.tarih = df.format(simdikiZaman);

    }

    public void personelSorgula(int pid) {
        try {
            SQLSorgu = "select Ad,Soyad from personel where perid=? ";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            Sorgu.setInt(1, pid);
            boolean sonuc2 = Sorgu.execute();
            if (sonuc2 == true) {
                this.sonuclar = Sorgu.getResultSet();
                String db_adsoyad;
                while (this.sonuclar.next()) {

                    db_adsoyad = sonuclar.getString(1).trim() + " ";
                    db_adsoyad += sonuclar.getString(2).trim();
                    this.adSoyad = db_adsoyad;
                    break;
                }

            }
        } catch (Exception ex) {

        }
    }

    public void izinSuresiHesapla(ValueChangeEvent e) {

        String sure = e.getNewValue().toString();
        int saat = Integer.parseInt(sure);
        saat = saat * 24;

        Date sonTarihi = new Date(simdikiZaman.getTime() + (1000 * 60 * 60 * saat));
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.sonTarih = df.format(sonTarihi);

    }

    public void personelIzınKaydet() {

        try {
            this.SQLSorgu = "insert into izin(PerID,tarih,aciklama,sontarih) values(?,?,?,?)";
            this.Sorgu = this.baglanti.prepareStatement(this.SQLSorgu);
            this.Sorgu.setInt(1, this.perID);
            java.util.Date today = new java.util.Date();

            this.Sorgu.setDate(2, new java.sql.Date(today.getTime()));

            this.Sorgu.setString(3, this.aciklama);
            int saat = sure * 24;
            Date st = new Date(today.getTime() + (1000 * 60 * 60 * saat));
            this.Sorgu.setDate(4, new java.sql.Date(st.getTime()));

            int sorguSonuc = Sorgu.executeUpdate();
            if (sorguSonuc > 0) {
                this.bilgilendirmeMesaj = "izin  Kayit Edildi";
                //  alanlariSifirla();
            } else {
                this.bilgilendirmeMesaj = "izin  Kayit Edilemedi";
            }

        } catch (Exception ex) {
            bilgilendirmeMesaj = ex.getMessage();
        }

        //  alanlariSifirla();
    }

    /*
    
     aramalar
    
     */
    private ArrayList<PersonelIzin> personelIzinListesi;

    public ArrayList<PersonelIzin> getPersonelIzinListesi() {
        return personelIzinListesi;
    }

    public void setPersonelIzinListesi(ArrayList<PersonelIzin> personelIzinListesi) {
        this.personelIzinListesi = personelIzinListesi;
    }

    public void personelAra(String aranan) {
        this.aramaBilgilendirme = "Personel No ya göre arama:" + aranan;
        try {
            personelIzinListesi = new ArrayList<PersonelIzin>();
            int p_perid = Integer.parseInt(aranan);
            SQLSorgu = "select * from izin where perid=?";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            this.Sorgu.setInt(1, p_perid);
            boolean sonuc = Sorgu.execute();

            if (sonuc == true) {

                sonuclar = Sorgu.getResultSet();
                while (this.sonuclar.next()) {
                    String db_aciklama = sonuclar.getString(1);
                    int db_perid = sonuclar.getInt(3);
                    SQLSorgu = "select ad,soyad from personel where perID=?";
                    Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                    this.Sorgu.setInt(1, db_perid);
                    boolean sonuc2 = Sorgu.execute();
                    ResultSet sonuclar2 = Sorgu.getResultSet();
                    String db_adsoyad = "";
                    if (sonuclar2.next()) {
                        db_adsoyad = sonuclar2.getString(1) + " ";
                        db_adsoyad += sonuclar2.getString(2);

                    }

                    String db_baslangicTarih = sonuclar.getDate(4).toString();
                    String db_sonTarih = sonuclar.getDate(5).toString();
                    PersonelIzin nesne = new PersonelIzin(db_perid, db_adsoyad, db_aciklama, db_baslangicTarih, db_sonTarih);
                    personelIzinListesi.add(nesne);
                }
                this.aramaBilgilendirme = "Kayıt Sayısı:" + personelIzinListesi.size();
            } else {
                this.aramaBilgilendirme = "İşlem Gerçekleştirilemedi";
            }
        } catch (Exception ex) {

        }
    }

    public void izinliPersonelListesi(String aranan) {
        this.aramaBilgilendirme = "Tarihe göre izinli personel Listesi:" + aranan;
        personelIzinListesi = new ArrayList<PersonelIzin>();

    }

    public void gunlukIzinliPersonel() {
        this.aramaBilgilendirme = "Bugun izinli personel";
        simdikiZaman = new Date();
        // System.out.println(simdikiZaman.toString());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        this.tarih = df.format(simdikiZaman);
        this.aranan = this.tarih;
        personelIzinListesi = new ArrayList<PersonelIzin>();

        try {

            SQLSorgu = "select * from izin where ?  BETWEEN tarih AND sonTarih;";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);

            java.util.Date today = new java.util.Date();

            this.Sorgu.setDate(1, new java.sql.Date(today.getTime()));

            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {

                sonuclar = Sorgu.getResultSet();
                while (this.sonuclar.next()) {
                    String db_aciklama = sonuclar.getString(1);
                    int db_perid = sonuclar.getInt(3);
                    SQLSorgu = "select ad,soyad from personel where perID=?";
                    Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                    this.Sorgu.setInt(1, db_perid);
                    boolean sonuc2 = Sorgu.execute();
                    ResultSet sonuclar2 = Sorgu.getResultSet();
                    String db_adsoyad = "";
                    if (sonuclar2.next()) {
                        db_adsoyad = sonuclar2.getString(1) + " ";
                        db_adsoyad += sonuclar2.getString(2);

                    }

                    String db_baslangicTarih = sonuclar.getDate(4).toString();
                    String db_sonTarih = sonuclar.getDate(5).toString();
                    PersonelIzin nesne = new PersonelIzin(db_perid, db_adsoyad, db_aciklama, db_baslangicTarih, db_sonTarih);
                    personelIzinListesi.add(nesne);
                }
                this.aramaBilgilendirme = "İzinli Personel Sayısı:" + personelIzinListesi.size();
            } else {
                this.aramaBilgilendirme = "İşlem Gerçekleştirilemedi";
            }
        } catch (Exception ex) {

        }

    }

    public void alanlariSifirla() {
        this.perID = 0;
        this.adSoyad = "";
        this.sonTarih = "";
        this.tarih = "";
        this.sure = 0;
        this.aciklama = "";
    }

    public void tariheGoreIzinliPersonel() {
        

    }

}
