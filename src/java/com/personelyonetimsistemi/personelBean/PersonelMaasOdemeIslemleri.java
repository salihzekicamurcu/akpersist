/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.personelBean;

import com.personelyonetimsistem.model.MaasProgram;
import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.faces.event.ValueChangeEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author salih
 */
public class PersonelMaasOdemeIslemleri extends VeritabaniIslem {

    public ArrayList<MaasProgram> getPersonelMaasProgramListesi() {
        return personelMaasProgramListesi;
    }

    public void setPersonelMaasProgramListesi(ArrayList<MaasProgram> personelMaasProgramListesi) {
        this.personelMaasProgramListesi = personelMaasProgramListesi;
    }

    public String getPerID() {
        return PerID;
    }

    public void setPerID(String PerID) {
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

    public String getUyariMesaj() {
        return uyariMesaj;
    }

    public void setUyariMesaj(String uyariMesaj) {
        this.uyariMesaj = uyariMesaj;
    }

    public String getBilgilendirmeMesaj() {
        return bilgilendirmeMesaj;
    }

    public void setBilgilendirmeMesaj(String bilgilendirmeMesaj) {
        this.bilgilendirmeMesaj = bilgilendirmeMesaj;
    }

    public String getOdemeBilgilendirme() {
        return odemeBilgilendirme;
    }

    public void setOdemeBilgilendirme(String odemeBilgilendirme) {
        this.odemeBilgilendirme = odemeBilgilendirme;
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
    private ArrayList<MaasProgram> personelMaasProgramListesi;

    private String PerID;
    private String Donem;
    private String Maas;
    private String Kesinti;
    public String odenen;
    private String Avans;
    private String ekMesai;
    private String Ad;
    private String Soyad;

    private String bilgilendirme;

    public String uyariMesaj;
    public String bilgilendirmeMesaj;
    public String odemeBilgilendirme;

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {

        this.tarih = tarih;
    }
    public String tarih;

    public void tarihYaz() {
        Date simdikiZaman = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.tarih = df.format(simdikiZaman);
    }

    public PersonelMaasOdemeIslemleri() {
        tarihYaz();
    }

    public void personelMaasBilgisiTablola(String parametre) {
        this.PerID = parametre;
        this.bilgilendirmeMesaj = "Aranan Per id=" + PerID;
        int aranan = -1;
        this.personelMaasProgramListesi = new ArrayList<MaasProgram>();
        if (this.PerID.length() > 0) {
            try {
                aranan = Integer.parseInt(this.PerID);
                try {
                   
                    SQLSorgu = "select * from maasprogram where perid=? order by donem asc ";
                    Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                    Sorgu.setInt(1, aranan);
                    boolean sonuc = Sorgu.execute();
                    if (sonuc == true) {
                        this.sonuclar = Sorgu.getResultSet();

                        while (this.sonuclar.next()) {
                            int db_perid = sonuclar.getInt(2);
                            String db_avans = sonuclar.getString(3);
                            String db_kesinti = sonuclar.getString(4);
                            String db_ekmesai = sonuclar.getString(5);
                            String db_maas = sonuclar.getString(6);
                            int db_donem = sonuclar.getInt(7);
                            float toplam = Float.parseFloat(db_maas) + Float.parseFloat(db_avans) - Float.parseFloat(db_kesinti) + Float.parseFloat(db_ekmesai);
                            this.personelMaasProgramListesi.add(new MaasProgram(
                                    db_perid,
                                    "" + db_donem,
                                    db_maas,
                                    db_kesinti,
                                    db_avans,
                                    db_ekmesai,
                                    "" + toplam));

                        }
                        try {
                            SQLSorgu = "select Ad,Soyad from personel where perid=? ";
                            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                            Sorgu.setInt(1, aranan);
                            boolean sonuc2 = Sorgu.execute();
                            if (sonuc2 == true) {
                                this.sonuclar = Sorgu.getResultSet();

                                while (this.sonuclar.next()) {

                                    this.Ad = sonuclar.getString(1);
                                    this.Soyad = sonuclar.getString(2);
                                    tarihYaz();
                                    break;
                                }

                            }
                        } catch (Exception ex) {
                            uyariMesaj = "Hata:" + ex.getMessage();
                        }
                    }

                } catch (Exception ex) {
                    uyariMesaj = "Hata:" + ex;
                }
            } catch (Exception e) {
                uyariMesaj = "donusum hatasi2" + e.getMessage();
                return;
            }
        } else {
            uyariMesaj = "Personel Numarasi Giriniz.";
            return;
        }

    }

    public void personelOdenecekMiktarBul(ValueChangeEvent e) {

        String ay = e.getNewValue().toString();
        // personelMaasBilgisiTablola();

        int aranan = Integer.parseInt(this.PerID);
        int ayAranan = Integer.parseInt(ay);
        this.bilgilendirmeMesaj = "Maaş Ödenen Ay:" + ay;
        //this.odenen="salih";
        try {
            SQLSorgu = "select   avans,kesinti,ekmesai,maas from maasprogram where perid=? and donem=? ";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            Sorgu.setInt(1, aranan);
            Sorgu.setInt(2, ayAranan);
            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {
                this.sonuclar = Sorgu.getResultSet();
                if (this.sonuclar.next()) {
                    float db_avans = sonuclar.getFloat(1);
                    float db_kesinti = sonuclar.getFloat(2);
                    float db_ekmesai = sonuclar.getFloat(3);
                    float db_maas = sonuclar.getFloat(4);
                    float toplam = db_avans - db_kesinti + db_maas + db_ekmesai;
                    this.odemeBilgilendirme = "Toplam Odenmesi Gereken:" + toplam;

                } else {
                    this.odemeBilgilendirme = "Bu Ay İçin Bir Ödeme Planı Yok";
                }
            } else {
                this.odemeBilgilendirme = "Toplam Odenmesi Gereken:0";
                this.uyariMesaj = "sorgu calismadi";

            }

        } catch (Exception ex) {

        }

    }

    public void alanlariSifirla() {
        this.PerID = "";
        this.Ad = "";
        this.Soyad = "";
        this.odenen = "";
        this.tarih = "";
        this.bilgilendirmeMesaj = "";

    }

    public void maasOdeme() {
        int int_perID = 0;
        float float_odenen = 0;

        try {
            int_perID = Integer.parseInt(this.PerID);
            float_odenen = Float.parseFloat(this.odenen);
            this.uyariMesaj = "maas odeme:perid:" + this.PerID + "Odenen:" + this.odenen + "Tarih:" + this.tarih + "Bilgi:" + this.bilgilendirmeMesaj;
            this.SQLSorgu = "insert into odeme(perid,odenen,tarih,bilgi) values(?,?,?,?)";
            this.Sorgu = this.baglanti.prepareStatement(this.SQLSorgu);
            this.Sorgu.setInt(1, int_perID);
            this.Sorgu.setFloat(2, float_odenen);
            java.util.Date today = new java.util.Date();
            this.Sorgu.setDate(3, new java.sql.Date(today.getTime()));
            this.Sorgu.setString(4, this.bilgilendirme);
            int sorguSonuc = Sorgu.executeUpdate();
            if (sorguSonuc > 0) {
                this.uyariMesaj = "Ödeme  Kayit Edildi";

            }

        } catch (NumberFormatException | SQLException ex) {
            this.uyariMesaj = "Hata:" + ex.getMessage();
        }

    }

}
