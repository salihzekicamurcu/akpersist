/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.topluIslemlerBean;
import com.personelyonetimsistemi.topluIslemlerBean.AnaSayfaBean;
import com.personelyonetimsistem.model.ManyetikKartListesiModel;
import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author salih
 */
public class PersonelGirisCikis extends VeritabaniIslem {

    /**
     * Creates a new instance of PersonelGirisCikis
     */
    public PersonelGirisCikis() {
  
        new AnaSayfaBean().girisCikisListele();
    }

    public int getKartNo() {
        return kartNo;
    }

    public void setKartNo(int kartNo) {
        this.kartNo = kartNo;
    }

    public String getBilgilendirmeMesaji() {
        return bilgilendirmeMesaji;
    }

    public void setBilgilendirmeMesaji(String bilgilendirmeMesaji) {
        this.bilgilendirmeMesaji = bilgilendirmeMesaji;
    }

    public int getCalismasaat() {
        return calismasaat;
    }

    public void setCalismasaat(int calismasaat) {
        this.calismasaat = calismasaat;
    }

    public int getMesaiolanid() {
        return mesaiplanid;
    }

    public void setMesaiolanid(int mesaiolanid) {
        this.mesaiplanid = mesaiolanid;
    }

    public String getCikisTarih() {
        return cikisTarih;
    }

    public void setCikisTarih(String cikisTarih) {
        this.cikisTarih = cikisTarih;
    }

    public String getGirisTarih() {
        return girisTarih;
    }

    public void setGirisTarih(String girisTarih) {
        this.girisTarih = girisTarih;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public int getPerid() {
        return perid;
    }

    public void setPerid(int perid) {
        this.perid = perid;
    }

    public ManyetikKartListesiModel getManyetikKartNesne() {
        return manyetikKartNesne;
    }

    public void setManyetikKartNesne(ManyetikKartListesiModel manyetikKartNesne) {
        this.manyetikKartNesne = manyetikKartNesne;
    }

    public String getMesaiPlanNot() {
        return mesaiPlanNot;
    }

    public void setMesaiPlanNot(String mesaiPlanNot) {
        this.mesaiPlanNot = mesaiPlanNot;
    }

    public int getMesaiplanid() {
        return mesaiplanid;
    }

    public void setMesaiplanid(int mesaiplanid) {
        this.mesaiplanid = mesaiplanid;
    }

    public String getKurumAdi() {
        return kurumAdi;
    }

    public void setKurumAdi(String kurumAdi) {
        this.kurumAdi = kurumAdi;
    }

    public int getMesaiID() {
        return mesaiID;
    }

    public void setMesaiID(int mesaiID) {
        this.mesaiID = mesaiID;
    }

    public String getIsBaslangicSaat() {
        return isBaslangicSaat;
    }

    public void setIsBaslangicSaat(String isBaslangicSaat) {
        this.isBaslangicSaat = isBaslangicSaat;
    }

    public String getIsBitirSaat() {
        return isBitirSaat;
    }

    public void setIsBitirSaat(String isBitirSaat) {
        this.isBitirSaat = isBitirSaat;
    }

    public double getMesaiSaatUcret() {
        return mesaiSaatUcret;
    }

    public void setMesaiSaatUcret(double mesaiSaatUcret) {
        this.mesaiSaatUcret = mesaiSaatUcret;
    }

    public String getGecikmeTolerans() {
        return gecikmeTolerans;
    }

    public void setGecikmeTolerans(String gecikmeTolerans) {
        this.gecikmeTolerans = gecikmeTolerans;
    }

    public int getGirisOnay() {
        return girisOnay;
    }

    public void setGirisOnay(int girisOnay) {
        this.girisOnay = girisOnay;
    }

    private int girisOnay = 0;
    private int mesaiID;
    private String isBaslangicSaat;
    private String isBitirSaat;
    private double mesaiSaatUcret;
    private String gecikmeTolerans;

    private String kurumAdi;
    private String mesaiPlanNot;
    private int calismasaat;
    private int mesaiplanid;
    private String cikisTarih;
    private String girisTarih;
    private String adsoyad;
    private int perid;
    private String bilgilendirmeMesaji = " ";
    private int kartNo;

    /*
    
    
    
     */
    public void kartOkut() {
        this.bilgilendirmeMesaji = "kart No" + this.kartNo;
        personelBilgisiBul(this.kartNo);
         new AnaSayfaBean().girisCikisListele();
        

    }
    private ManyetikKartListesiModel manyetikKartNesne;

    public void personelBilgisiBul(int p_aranan) {
        try {

            SQLSorgu = "select * from kart where kartnumarasi=? ";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            this.Sorgu.setInt(1, p_aranan);
            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {

                sonuclar = Sorgu.getResultSet();
                if (this.sonuclar.next()) {

                    int db_kartnumarasi = sonuclar.getInt(6);
                    String db_bilgi = sonuclar.getString(4);
                    String db_alisTarih = "" + sonuclar.getDate(3);
                    String db_verilisTarih = "" + sonuclar.getDate(2);
                    int db_perid = sonuclar.getInt(1);
                    SQLSorgu = "select ad,soyad,kurumid from personel where perID=?";
                    Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                    this.Sorgu.setInt(1, db_perid);
                    boolean sonuc2 = Sorgu.execute();
                    ResultSet sonuclar2 = Sorgu.getResultSet();
                    String db_adsoyad = "";
                    String db_kurumid = "";
                    if (sonuclar2.next()) {
                        db_adsoyad = sonuclar2.getString(1) + " ";
                        db_adsoyad += sonuclar2.getString(2);
                        this.kurumAdi = sonuclar2.getString(3);
                        this.adsoyad = db_adsoyad;
                        this.perid = db_perid;
                        try {
                            SQLSorgu = "select mesaikayit.mesaiid,mesaiplan.aciklama,mesaiplan.isbaslangicsaat,mesaiplan.isbitissaat,mesaiplan.gecikmetolerans,"
                                    + "mesaiplan.mesaisaatucret from mesaikayit,mesaiplan where perid=? and mesaiplan.mesaiplanid=mesaikayit.mesaiplanid";

                            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                            this.Sorgu.setInt(1, perid);
                            boolean sonuc3 = Sorgu.execute();
                            ResultSet sonuclar3 = Sorgu.getResultSet();
                            if (sonuclar3.next()) {
                                this.mesaiID = sonuclar3.getInt(1);
                                this.mesaiPlanNot = sonuclar3.getString(2);
                                this.isBaslangicSaat = sonuclar3.getString(3);
                                this.isBitirSaat = sonuclar3.getString(4) + ":00";
                                this.gecikmeTolerans = sonuclar3.getString(5);
                                this.mesaiSaatUcret = sonuclar3.getDouble(6);
                                girisOnay = 1;
                                mesaiKayit();
                            } else {
                                this.bilgilendirmeMesaji = "Personelin Mesai Kaydı Yoktur";
                                this.isBaslangicSaat = "";
                            }
                        } catch (Exception ex) {
                            this.bilgilendirmeMesaji = "Hata ic:" + ex.getMessage();
                        }
                    }

                }

            } else {
                this.bilgilendirmeMesaji = "İşlem Gerçekleştirilemedi";
            }
        } catch (Exception ex) {
            this.bilgilendirmeMesaji += "Hata:" + ex.getMessage();
        } finally {

        }
    }

    public void mesaiKayit() {
        int islemDurum = 0;
        if (girisOnay == 0) {
            this.bilgilendirmeMesaji = "Giris Onaylanmadi";
            this.isBaslangicSaat = "";
            this.mesaiID = 0;
        } else {
            this.bilgilendirmeMesaji = "Giris Yapılıyor";
            try {
                SQLSorgu = "select islemtarihi from hareketkayit where perid=? and islemtarihi=? ";
                Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                this.Sorgu.setInt(1, this.perid);
                java.util.Date today = new java.util.Date();
                this.Sorgu.setDate(2, new java.sql.Date(today.getTime()));
                boolean sonuc = Sorgu.execute();
                if (sonuc == true) {

                    sonuclar = Sorgu.getResultSet();
                    if (this.sonuclar.next()) {
                        //cikis yap
                        Date db_islemtarihi = sonuclar.getDate(1);
                        this.bilgilendirmeMesaji = "Çıkış İşlemi";
                        islemDurum = 1;
                        this.SQLSorgu = "update  hareketkayit set isbitis=? where perid=? and  islemtarihi=?";
                        this.Sorgu = this.baglanti.prepareStatement(this.SQLSorgu);
                        this.Sorgu.setDate(1, new java.sql.Date(today.getTime()));
                        this.Sorgu.setInt(2, this.perid);
                        this.Sorgu.setDate(3, (java.sql.Date) db_islemtarihi);
                        int sorguSonuc2 = Sorgu.executeUpdate();
                        if (sorguSonuc2 > 0) {
                            this.bilgilendirmeMesaji += "\nÇıkış Gerçekleşti";
                        } else {
                            this.bilgilendirmeMesaji += "\nYeniden Deneyiniz";
                        }

                    } else {
                        this.bilgilendirmeMesaji = "Giriş İşlemi:";
                        islemDurum = 0;
                        try {
                            this.SQLSorgu = "insert into hareketkayit(islemtarihi,kartnumarasi,mesaiid,perid)  values(?,?,?,?)";
                            this.Sorgu = this.baglanti.prepareStatement(this.SQLSorgu);

                            this.Sorgu.setDate(1, new java.sql.Date(today.getTime()));
                            this.Sorgu.setInt(2, this.kartNo);
                            this.Sorgu.setInt(3, this.mesaiID);
                            this.Sorgu.setInt(4, this.perid);

                            int sorguSonuc2 = Sorgu.executeUpdate();
                            if (sorguSonuc2 > 0) {
                                this.bilgilendirmeMesaji += "\nGiriş İşlemi Gerçekleşti";
                            } else {
                                this.bilgilendirmeMesaji += "\nYeniden Deneyiniz";
                            }
                        } catch (SQLException ex) {
                            this.bilgilendirmeMesaji = "Hata:Giriş Yapma:" + ex.getMessage();
                        }
                        //girisyap
                    }
                }
            } catch (Exception ex) {
            }
        }
    }
}
