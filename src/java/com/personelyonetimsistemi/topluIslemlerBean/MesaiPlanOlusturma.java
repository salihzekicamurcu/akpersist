/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.topluIslemlerBean;

import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import com.personelyonetimsistem.model.MesaiPlan;
import java.util.ArrayList;

/**
 *
 * @author salih
 */
public class MesaiPlanOlusturma extends VeritabaniIslem {

    /**
     * Creates a new instance of MesaiPlanOlusturma
     */
    public MesaiPlanOlusturma() {
        mesaiPlanListele();
    }

    public String getIsBaslangicSaat() {
        return isBaslangicSaat;
    }

    public void setIsBaslangicSaat(String isBaslangicSaat) {
        this.isBaslangicSaat = isBaslangicSaat;
    }

    public String getIsBitisSaat() {
        return isBitisSaat;
    }

    public void setIsBitisSaat(String isBitisSaat) {
        this.isBitisSaat = isBitisSaat;
    }

    public String getGecikmeTolerans() {
        return gecikmeTolerans;
    }

    public void setGecikmeTolerans(String gecikmeTolerans) {
        this.gecikmeTolerans = gecikmeTolerans;
    }

    public float getMesaiSaatUcret() {
        return mesaiSaatUcret;
    }

    public void setMesaiSaatUcret(float mesaiSaatUcret) {
        this.mesaiSaatUcret = mesaiSaatUcret;
    }

    public float getEkMesaiUcret() {
        return ekMesaiUcret;
    }

    public void setEkMesaiUcret(float ekMesaiUcret) {
        this.ekMesaiUcret = ekMesaiUcret;
    }

    public int getMesaiCalismaSaat() {
        return mesaiCalismaSaat;
    }

    public void setMesaiCalismaSaat(int mesaiCalismaSaat) {
        this.mesaiCalismaSaat = mesaiCalismaSaat;
    }

    public String getBilgilendirmeMesaj() {
        return bilgilendirmeMesaj;
    }

    public void setBilgilendirmeMesaj(String bilgilendirmeMesaj) {
        this.bilgilendirmeMesaj = bilgilendirmeMesaj;
    }

    public String getUyariMesaj() {
        return uyariMesaj;
    }

    public void setUyariMesaj(String uyariMesaj) {
        this.uyariMesaj = uyariMesaj;
    }
    private ArrayList<MesaiPlan> mesaiPlanListesi;

    public ArrayList<MesaiPlan> getMesaiPlanListesi() {
        return mesaiPlanListesi;
    }

    public void setMesaiPlanListesi(ArrayList<MesaiPlan> mesaiPlanListesi) {
        this.mesaiPlanListesi = mesaiPlanListesi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    private String aciklama;
    public String uyariMesaj;
    public String bilgilendirmeMesaj;
    private String isBaslangicSaat;
    private String isBitisSaat;
    private String gecikmeTolerans;
    private float mesaiSaatUcret;
    private float ekMesaiUcret;
    private int mesaiCalismaSaat;

    public void mesaiPlanKaydet() {
        try {
            SQLSorgu = "insert into mesaiplan("
                    + "mesaisaatucret,"
                    + "ekmesaiucret,"
                    + "mesaicalismasaat,"
                    + "isbaslangicsaat,"
                    + "isbitissaat,"
                    + "gecikmetolerans,aciklama)"
                    + "values(?,?,?,?,?,?,?)";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            Sorgu.setFloat(1, this.mesaiSaatUcret);
            Sorgu.setFloat(2, this.ekMesaiUcret);
            Sorgu.setInt(3, this.mesaiCalismaSaat);
            Sorgu.setString(4, this.isBaslangicSaat);
            Sorgu.setString(5, this.isBitisSaat);
            Sorgu.setString(6, this.gecikmeTolerans);
            Sorgu.setString(7, this.aciklama);
            int sonuc = Sorgu.executeUpdate();
            if (sonuc > 0) {

                this.bilgilendirmeMesaj = "Maas Programi Kayit Edildi";

            } else {
                this.bilgilendirmeMesaj = "Maas Programi Kayıt Edilemedi";
            }

        } catch (Exception ex) {
            this.uyariMesaj = "Hata:" + ex.getMessage();
        } finally {
            mesaiPlanListele();
        }

    }

    public void mesaiPlanListele() {
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
                    String db_aciklama=sonuclar.getString(8);
                    MesaiPlan nesne = new MesaiPlan(db_mesaiPlanId, db_isBaslangicSaat, db_isBitisSaat, db_gecikmeTolerans, db_mesaiSaatUcret, db_ekMesaiUcret, db_mesaiCalismaSaat,db_aciklama);
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

}
