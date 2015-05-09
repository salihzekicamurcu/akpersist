/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.raporlarBean;

import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import com.personelyonetimsistem.model.ManyetikKartListesiModel;
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
public class ManyetikKartListesi extends VeritabaniIslem {

    /**
     * Creates a new instance of ManyetikKartListesi
     */
    public ManyetikKartListesi() {
        kullanilanManyetikKartlariListele();
    }

    public int getPerID() {
        return perID;
    }

    public void setPerID(int perID) {
        this.perID = perID;
    }

    public int getKartNumarasi() {
        return kartNumarasi;
    }

    public void setKartNumarasi(int kartNumarasi) {
        this.kartNumarasi = kartNumarasi;
    }

    public String getVerilisTarih() {
        return VerilisTarih;
    }

    public void setVerilisTarih(String VerilisTarih) {
        this.VerilisTarih = VerilisTarih;
    }

    public String getAlisTarih() {
        return AlisTarih;
    }

    public void setAlisTarih(String AlisTarih) {
        this.AlisTarih = AlisTarih;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getBilgilendirmeMesaji() {
        return bilgilendirmeMesaji;
    }

    public void setBilgilendirmeMesaji(String bilgilendirmeMesaji) {
        this.bilgilendirmeMesaji = bilgilendirmeMesaji;
    }

    public String bilgilendirmeMesaji;
    private int perID;
    private int kartNumarasi;
    private String adSoyad;
    private String VerilisTarih;
    private String AlisTarih;
    private String aciklama;

    public int getAranan() {
        return aranan;
    }

    public void setAranan(int aranan) {
        this.aranan = aranan;
    }

    private int aranan;

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
                Date simdikiZaman = new Date();
                // System.out.println(simdikiZaman.toString());
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                this.VerilisTarih = df.format(simdikiZaman);

            }
        } catch (Exception ex) {

        }
    }

    public void manyetikKartVer() {
        try {
            this.SQLSorgu = "insert into kart(kartnumarasi,perid,veristarih,bilgi)"
                    + " values(?,?,?,?)";
            this.Sorgu = this.baglanti.prepareStatement(this.SQLSorgu);
            this.Sorgu.setInt(1, this.kartNumarasi);

            this.Sorgu.setInt(2, this.perID);
            java.util.Date today = new java.util.Date();
            this.Sorgu.setDate(3, new java.sql.Date(today.getTime()));
            this.Sorgu.setString(4, this.aciklama);

            int sorguSonuc = Sorgu.executeUpdate();
            if (sorguSonuc > 0) {
                this.bilgilendirmeMesaji = "Kart Verildi";
                kullanilanManyetikKartlariListele();
                //  alanlariSifirla();
            } else {
                this.bilgilendirmeMesaji = "Kart Verilemedi";
            }

        } catch (Exception ex) {
            bilgilendirmeMesaji = ex.getMessage();
        }
    }

    public List<ManyetikKartListesiModel> getManyetlikKartListe() {
        return manyetlikKartListe;
    }

    public void setManyetlikKartListe(List<ManyetikKartListesiModel> manyetlikKartListe) {
        this.manyetlikKartListe = manyetlikKartListe;
    }

    List<ManyetikKartListesiModel> manyetlikKartListe;

    public void kullanilanManyetikKartlariListele() {
        this.bilgilendirmeMesaji = "Verilen Manyetik kartlari listele";
        manyetlikKartListe = new ArrayList<ManyetikKartListesiModel>();

        try {

            SQLSorgu = "select * from kart where alistarih is null";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);

            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {

                sonuclar = Sorgu.getResultSet();
                while (this.sonuclar.next()) {

                    int db_kartnumarasi = sonuclar.getInt(6);
                    String db_bilgi = sonuclar.getString(4);
                    String db_alisTarih = "" + sonuclar.getDate(3);
                    String db_verilisTarih = "" + sonuclar.getDate(2);

                    int db_perid = sonuclar.getInt(1);
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

                    ManyetikKartListesiModel nesne = new ManyetikKartListesiModel(db_perid, db_adsoyad, db_kartnumarasi, db_verilisTarih, db_alisTarih, db_bilgi);
                    manyetlikKartListe.add(nesne);
                }
                this.bilgilendirmeMesaji = "Kart Sayısı:" + manyetlikKartListe.size();
            } else {
                this.bilgilendirmeMesaji = "İşlem Gerçekleştirilemedi";
            }
        } catch (Exception ex) {
            this.bilgilendirmeMesaji = "Hata:" + ex.getMessage();
        }

    }
    public void verilenManyetikKartlariListele() {
        this.bilgilendirmeMesaji = "Verilen Manyetik kartlari listele";
        manyetlikKartListe = new ArrayList<ManyetikKartListesiModel>();

        try {

            SQLSorgu = "select * from kart ";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);

            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {

                sonuclar = Sorgu.getResultSet();
                while (this.sonuclar.next()) {

                    int db_kartnumarasi = sonuclar.getInt(6);
                    String db_bilgi = sonuclar.getString(4);
                    String db_alisTarih = "" + sonuclar.getDate(3);
                    String db_verilisTarih = "" + sonuclar.getDate(2);

                    int db_perid = sonuclar.getInt(1);
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

                    ManyetikKartListesiModel nesne = new ManyetikKartListesiModel(db_perid, db_adsoyad, db_kartnumarasi, db_verilisTarih, db_alisTarih, db_bilgi);
                    manyetlikKartListe.add(nesne);
                }
                this.bilgilendirmeMesaji = "Kart Sayısı:" + manyetlikKartListe.size();
            } else {
                this.bilgilendirmeMesaji = "İşlem Gerçekleştirilemedi";
            }
        } catch (Exception ex) {
            this.bilgilendirmeMesaji = "Hata:" + ex.getMessage();
        }

    }

    public void verilenManyetikKartlariAraListele(int p_aranan) {
        this.bilgilendirmeMesaji = "Verilen Manyetik kartlari listele";
        manyetlikKartListe = new ArrayList<ManyetikKartListesiModel>();

        try {

            SQLSorgu = "select * from kart where perid=? ";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            this.Sorgu.setInt(1, p_aranan);
            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {

                sonuclar = Sorgu.getResultSet();
                while (this.sonuclar.next()) {

                    int db_kartnumarasi = sonuclar.getInt(6);
                    String db_bilgi = sonuclar.getString(4);
                    String db_alisTarih = "" + sonuclar.getDate(3);
                    String db_verilisTarih = "" + sonuclar.getDate(2);
                    int db_perid = sonuclar.getInt(1);
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

                    ManyetikKartListesiModel nesne = new ManyetikKartListesiModel(db_perid, db_adsoyad, db_kartnumarasi, db_verilisTarih, db_alisTarih, db_bilgi);
                    manyetlikKartListe.add(nesne);
                }
                this.bilgilendirmeMesaji = "Kart Sayısı:" + manyetlikKartListe.size();
            } else {
                this.bilgilendirmeMesaji = "İşlem Gerçekleştirilemedi";
            }
        } catch (Exception ex) {
            this.bilgilendirmeMesaji = "Hata:" + ex.getMessage();
        }

    }

    public void verilenManyetikKartlariAraListeleKartNo(int p_aranan) {
        this.bilgilendirmeMesaji = "Verilen Manyetik kartlari listele";
        manyetlikKartListe = new ArrayList<ManyetikKartListesiModel>();

        try {

            SQLSorgu = "select * from kart where kartnumarasi=? ";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            this.Sorgu.setInt(1, p_aranan);
            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {

                sonuclar = Sorgu.getResultSet();
                while (this.sonuclar.next()) {

                    int db_kartnumarasi = sonuclar.getInt(6);
                    String db_bilgi = sonuclar.getString(4);
                    String db_alisTarih = "" + sonuclar.getDate(3);
                    String db_verilisTarih = "" + sonuclar.getDate(2);
                    int db_perid = sonuclar.getInt(1);
                    SQLSorgu = "select ad,soyad from personel where perID=?";
                    Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                    this.Sorgu.setInt(1, db_perid);
                    boolean sonuc2 = Sorgu.execute();
                    ResultSet sonuclar2 = Sorgu.getResultSet();
                    String db_adsoyad = "";
                    String db_kurum="";
                    if (sonuclar2.next()) {
                        db_adsoyad = sonuclar2.getString(1) + " ";
                        db_adsoyad += sonuclar2.getString(2);

                    }

                    ManyetikKartListesiModel nesne = new ManyetikKartListesiModel(db_perid, db_adsoyad, db_kartnumarasi, db_verilisTarih, db_alisTarih, db_bilgi);
                    manyetlikKartListe.add(nesne);
                }
                this.bilgilendirmeMesaji = "Kart Sayısı:" + manyetlikKartListe.size();
            } else {
                this.bilgilendirmeMesaji = "İşlem Gerçekleştirilemedi";
            }
        } catch (Exception ex) {
            this.bilgilendirmeMesaji = "Hata:" + ex.getMessage();
        }

    }

    public void kartGeriAl(int kartnumarasi) {
        this.bilgilendirmeMesaji = "Geri Alinacak Kart no:" + kartnumarasi;
        try {
            this.SQLSorgu = "update  kart set alistarih=? where kartnumarasi=?";
            this.Sorgu = this.baglanti.prepareStatement(this.SQLSorgu);
            java.util.Date today = new java.util.Date();
            this.Sorgu.setDate(1, new java.sql.Date(today.getTime()));
            this.Sorgu.setInt(2, kartnumarasi);
            int sorguSonuc = Sorgu.executeUpdate();
            if (sorguSonuc > 0) {
                this.bilgilendirmeMesaji = "Kart Geri Alindi";
                //  alanlariSifirla();
                verilenManyetikKartlariListele();
            } else {
                this.bilgilendirmeMesaji = "Kart Geri Alinma İşlemi Tamamlanamadi";
            }

        } catch (Exception ex) {
            bilgilendirmeMesaji = ex.getMessage();
        }

    }

    

}
