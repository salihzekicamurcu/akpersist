/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.personelBean;

import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import com.personelyonetimsistem.model.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author salih
 */
public class PersonelMesaiAtama extends VeritabaniIslem {

    /**
     * Creates a new instance of PersonelMesaiAtama
     */
    public PersonelMesaiAtama() {
        mesaiPlanListele();
    }

    public int getMesaiPlanId() {
        return MesaiPlanId;
    }

    public void setMesaiPlanId(int MesaiPlanId) {
        this.MesaiPlanId = MesaiPlanId;
    }

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    public String getGirisTarih() {
        return GirisTarih;
    }

    public void setGirisTarih(String GirisTarih) {
        this.GirisTarih = GirisTarih;
    }

    public String getBilgi() {
        return bilgi;
    }

    public void setBilgi(String bilgi) {
        this.bilgi = bilgi;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public String getMesaiEtiket() {
        return mesaiEtiket;
    }

    public void setMesaiEtiket(String mesaiEtiket) {
        this.mesaiEtiket = mesaiEtiket;
    }

    public String getBilgilendirme() {
        return bilgilendirme;
    }

    public void setBilgilendirme(String bilgilendirme) {
        this.bilgilendirme = bilgilendirme;
    }

    public boolean isTablodurum1() {
        return tablodurum1;
    }

    public void setTablodurum1(boolean tablodurum1) {
        this.tablodurum1 = tablodurum1;
    }

    public boolean isTablodurum2() {
        return tablodurum2;
    }

    public void setTablodurum2(boolean tablodurum2) {
        this.tablodurum2 = tablodurum2;
    }

    private boolean tablodurum1 = true;
    private boolean tablodurum2 = false;
    private String bilgilendirme;
    private String mesaiEtiket;
    private String adsoyad;
    private int MesaiPlanId;
    private int perId;
    private String GirisTarih;
    private String bilgi;
    private ArrayList<MesaiPlan> mesaiPlanListesi;

    public ArrayList<MesaiPlan> getMesaiPlanListesi() {
        return mesaiPlanListesi;
    }

    public void setMesaiPlanListesi(ArrayList<MesaiPlan> mesaiPlanListesi) {
        this.mesaiPlanListesi = mesaiPlanListesi;
    }

    public void mesaiPlanListele() {
        tablodurum1 = true;
        tablodurum2 = false;
        mesaiPlanListesi = new ArrayList<MesaiPlan>();

        try {
            SQLSorgu = "select *  from mesaiplan";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);

            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {

                sonuclar = Sorgu.getResultSet();
                while (this.sonuclar.next()) {

                    int db_mesaiPlanId = sonuclar.getInt(1);
                    String db_isBaslangicSaat = sonuclar.getString(2);
                    String db_isBitisSaat = sonuclar.getString(3);
                    String db_gecikmeTolerans = sonuclar.getString(4);
                    float db_mesaiSaatUcret = sonuclar.getFloat(5);
                    int db_mesaiCalismaSaat = sonuclar.getInt(6);
                    float db_ekMesaiUcret = sonuclar.getFloat(7);
                    String db_aciklama = sonuclar.getString(8);
                    MesaiPlan nesne = new MesaiPlan(db_mesaiPlanId, db_isBaslangicSaat, db_isBitisSaat, db_gecikmeTolerans, db_mesaiSaatUcret, db_ekMesaiUcret, db_mesaiCalismaSaat, db_aciklama);
                    this.mesaiPlanListesi.add(nesne);

                    //PersonelOdemeGecmis nesne = new PersonelOdemeGecmis(p_tarih, "" + p_odenen, "" + p_bilgilendirme);
                    //    personelOdemeGecmisListesi.add(nesne);
                }
            } else {
                //   this.uyariMesaji = "bilgi yok";
            }
        } catch (Exception ex) {

        }
    }

    private void tarihYaz() {
        Date simdikiZaman = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.GirisTarih = df.format(simdikiZaman);
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
                    this.adsoyad = db_adsoyad;
                    break;
                }

            }
        } catch (Exception ex) {

        } finally {
            tarihYaz();
        }
    }

    public void tablodanMesaiAta(int mesai_id, String mesaiEtiket) {
        this.MesaiPlanId = mesai_id;
        this.mesaiEtiket = mesaiEtiket;
    }

    public void personelMesaiKaydet() {
        this.bilgilendirme = "mesaiplanid" + this.MesaiPlanId + "perid" + this.perId + "Aciklama:" + this.bilgi;

        try {

            this.SQLSorgu = "insert into mesaikayit(perid,giristarih,bilgi,mesaiplanid) values(?,?,?,?)";
            this.Sorgu = this.baglanti.prepareStatement(this.SQLSorgu);
            this.Sorgu.setInt(1, this.perId);
            java.util.Date today = new java.util.Date();
            this.Sorgu.setDate(2, new java.sql.Date(today.getTime()));
            this.Sorgu.setString(3, this.bilgi);
            this.Sorgu.setInt(4, this.MesaiPlanId);
            int sorguSonuc = Sorgu.executeUpdate();
            if (sorguSonuc > 0) {
                this.bilgilendirme = "Mesai Bilgisi Atandi";

            }

        } catch (Exception ex) {
            //this.uyariMesaj = "Hata:" + ex.getMessage();
        }

    }

    private ArrayList<MesaiPlanListesi> personelMesaiPlanListe;

    public ArrayList<MesaiPlanListesi> getPersonelMesaiPlanListe() {
        return personelMesaiPlanListe;
    }

    public void setPersonelMesaiPlanListe(ArrayList<MesaiPlanListesi> personelMesaiPlanListe) {
        this.personelMesaiPlanListe = personelMesaiPlanListe;
    }

    public void personelAtanmisMesaiListele() {
        tablodurum1 = false;
        tablodurum2 = true;
        personelMesaiPlanListe = new ArrayList<MesaiPlanListesi>();
        try {
            SQLSorgu = "select personel.ad ||' '|| personel.soyad as adsoyad,mesaiplan.aciklama,mesaikayit.giristarih,"
                    + "mesaikayit.bilgi,mesaikayit.mesaiplanid,personel.perid"
                    + " from mesaiplan,mesaikayit,personel"
                    + " where mesaikayit.mesaiplanid=mesaiplan.mesaiplanid and personel.perid=mesaikayit.perid";

            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {
                this.sonuclar = Sorgu.getResultSet();
                MesaiPlanListesi nesne;
                while (this.sonuclar.next()) {
                    String db_adsoyad = sonuclar.getString(1);
                    String db_mesaietiket = sonuclar.getString(2);
                    String db_tarih = sonuclar.getString(3);
                    String db_bilgi = sonuclar.getString(4);
                    int db_mesaiplanid = sonuclar.getInt(5);
                    int db_perid = sonuclar.getInt(6);
                    nesne = new MesaiPlanListesi(db_adsoyad, db_mesaietiket, db_tarih, db_bilgi, db_mesaiplanid, db_perid);
                    this.personelMesaiPlanListe.add(nesne);

                }
                bilgilendirme = "Sayac" + this.personelMesaiPlanListe.size();

            }
        } catch (Exception ex) {
            this.bilgilendirme = "Hata:" + ex.getMessage();
        }

    }

    public void alanlariTemizle() {
        bilgilendirme = "";
        mesaiEtiket = "";
        adsoyad = "";
        MesaiPlanId = 0;
        perId = 0;
        bilgi = "";
    }

}
