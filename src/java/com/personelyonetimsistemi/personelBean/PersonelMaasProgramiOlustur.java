/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.personelBean;

import com.personelyonetimsistem.model.*;
import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salih
 */
public class PersonelMaasProgramiOlustur extends VeritabaniIslem {

    private String PerID;
    private String Donem;
    private String Maas;
    private String Kesinti;

    private String Avans;
    private String ekMesai;
    private String Ad;
    private String Soyad;
    public String uyariMesaj;
    public String bilgilendirmeMesaj;
    boolean maasDuzenle;    
    public boolean isMaasDuzenle() {
        return maasDuzenle;
    }

    public void setMaasDuzenle(boolean maasDuzenle) {
        this.maasDuzenle = maasDuzenle;
    }
    
    public List<MaasProgram> getPersonelMaasProgramListesi() {
        return personelMaasProgramListesi;
    }

    public void setPersonelMaasProgramListesi(List<MaasProgram> personelMaasProgramListesi) {
        this.personelMaasProgramListesi = personelMaasProgramListesi;
    }

    public List<MaasProgram> personelMaasProgramListesi;

    int arananPerID;

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

    public String getAvans() {
        return Avans;
    }

    public void setAvans(String Avans) {
        this.Avans = Avans;
    }

    public String getNetUcret() {
        return netUcret;
    }

    public void setNetUcret(String netUcret) {
        this.netUcret = netUcret;
    }
    private String netUcret;

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

    public void personelMaasBilgisiTablola() {
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

                    }

                } catch (Exception ex) {
                    uyariMesaj = "Hata:" + ex;
                }
            } catch (Exception e) {
                uyariMesaj = "donusum hatasi" + e.getMessage();
                return;
            }
        } else {
            uyariMesaj = "Personel Numarasi Giriniz.";
            return;
        }

    }

    public void personelBilgileriYukle() {
        if (this.PerID.length() > 0) {
            arananPerID = Integer.parseInt(this.PerID);
        } else {
            uyariMesaj = "Personel Numarasi Giriniz.";

        }
        try {

            SQLSorgu = "select "
                    + "personel.perid,"
                    + "personel.ad,"
                    + "personel.soyad from personel where perid=?  ";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            Sorgu.setInt(1, arananPerID);
            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {

                sonuclar = Sorgu.getResultSet();
                try {
                    if (this.sonuclar.next()) {

                        this.PerID = "" + sonuclar.getInt(1);
                        this.Ad = sonuclar.getString(2);
                        this.Soyad = sonuclar.getString(3);

                    } else {
                        uyariMesaj = "Personel Bulunamadi";
                    }
                } catch (Exception ex) {

                }

            } else {

            }

        } catch (Exception ex) {

        } finally {
            personelMaasBilgisiTablola();
        }

    }

    public void personelMaasHesapla() {

        if (this.Maas.length() == 0) {
            uyariMesaj = "Maas Alani Bos Olamaz";
            return;
        }
        if (this.Avans.length() == 0) {
            this.Avans = "0";
        }
        if (this.ekMesai.length() == 0) {
            this.ekMesai = "0";
        }
        if (this.Kesinti.length() == 0) {
            this.Kesinti = "0";
        }
        try {
            float fmaas = Float.parseFloat(this.Maas);
            float favans = Float.parseFloat(this.Avans);
            float fkesinti = Float.parseFloat(this.Kesinti);
            float fekmesai = Float.parseFloat(this.ekMesai);
            float net = fmaas + favans - fkesinti + fekmesai;
            netUcret = "" + net;

        } catch (Exception ex) {
            uyariMesaj = "Hata:" + ex.getMessage();
            return;
        }

    }

    public void personelMaasProgramiKaydet() {
        int aranan = -1;
        int donem = -1;
        try {
            if (this.PerID.length() > 0 && this.Donem.length() > 0) {
                aranan = Integer.parseInt(this.PerID);
                donem = Integer.parseInt(this.Donem);
            } else {
                uyariMesaj = "Personel Numarasi  ve Ay Giriniz.";
                return;
            }
            if (this.Avans.length() == 0) {
                uyariMesaj = "Avans Bos";
                return;
            } else if (this.Maas.length() == 0) {
                uyariMesaj = "Maas Bos";
                return;
            } else if (this.Kesinti.length() == 0) {
                uyariMesaj = "Kesinti Bos";
                return;
            } else if (this.ekMesai.length() == 0) {
                uyariMesaj = "Ek Mesai Bos";
                return;
            } else {
                SQLSorgu = "insert into maasprogram("
                        + "perid,"
                        + "donem,"
                        + "maas,"
                        + "avans,"
                        + "kesinti,"
                        + "ekmesai)"
                        + "values(?,?,?,?,?,?)";
                Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                Sorgu.setInt(1, aranan);
                Sorgu.setInt(2, donem);
                Sorgu.setString(3, Maas);
                Sorgu.setString(4, Avans);
                Sorgu.setString(5, Kesinti);
                Sorgu.setString(6, ekMesai); 
                int sonuc = Sorgu.executeUpdate();
                if (sonuc > 0) {

                    bilgilendirmeMesaj = "Maas Programi Kayit Edildi";

                } else {
                    bilgilendirmeMesaj = "Maas Programi Kayıt Edilemedi";
                }
            }

        } catch (Exception ex) {
            aranan++;
            uyariMesaj = "Hata Maaş Kayıt:" + aranan;

        } finally {
            personelMaasBilgisiTablola();
        }

    }

}
