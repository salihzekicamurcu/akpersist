/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.personelBean;

import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import java.sql.SQLException;
import static org.apache.taglibs.standard.functions.Functions.trim;

/**
 *
 * @author salih
 */
public class PersonelDuzenlemeIslemleri extends VeritabaniIslem {

    public String getPerID() {
        return perID;
    }

    public void setPerID(String perID) {
        this.perID = perID;
    }

    public String getKartNo() {
        return KartNo;
    }

    public void setKartNo(String KartNo) {
        this.KartNo = KartNo;
    }

    public String getAd() {
        return trim(Ad);
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

    public String getTC_KIMLIK_NO() {
        return TC_KIMLIK_NO;
    }

    public void setTC_KIMLIK_NO(String TC_KIMLIK_NO) {
        this.TC_KIMLIK_NO = TC_KIMLIK_NO;
    }

    public String getSIGORTA_NO() {
        return SIGORTA_NO;
    }

    public void setSIGORTA_NO(String SIGORTA_NO) {
        this.SIGORTA_NO = SIGORTA_NO;
    }

    public String getIS_DURUMU() {
        return IS_DURUMU;
    }

    public void setIS_DURUMU(String IS_DURUMU) {
        this.IS_DURUMU = IS_DURUMU;
    }

    public String getKURUM_ID() {
        return KURUM_ID;
    }

    public void setKURUM_ID(String KURUM_ID) {
        this.KURUM_ID = KURUM_ID;
    }

    public String getFotograf() {
        return Fotograf;
    }

    public void setFotograf(String Fotograf) {
        this.Fotograf = Fotograf;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public String getOgrenim_Turu() {
        return Ogrenim_Turu;
    }

    public void setOgrenim_Turu(String Ogrenim_Turu) {
        this.Ogrenim_Turu = Ogrenim_Turu;
    }

    public String getMezun_Oldugu_Okul() {
        return Mezun_Oldugu_Okul;
    }

    public void setMezun_Oldugu_Okul(String Mezun_Oldugu_Okul) {
        this.Mezun_Oldugu_Okul = Mezun_Oldugu_Okul;
    }

    public String getKan_Grubu() {
        return Kan_Grubu;
    }

    public void setKan_Grubu(String Kan_Grubu) {
        this.Kan_Grubu = Kan_Grubu;
    }

    public String getCinsiyet() {
        return Cinsiyet;
    }

    public void setCinsiyet(String Cinsiyet) {
        this.Cinsiyet = Cinsiyet;
    }

    public String getMedeni_Durum() {
        return Medeni_Durum;
    }

    public void setMedeni_Durum(String Medeni_Durum) {
        this.Medeni_Durum = Medeni_Durum;
    }

    public String getGiysi_Beden() {
        return Giysi_Beden;
    }

    public void setGiysi_Beden(String Giysi_Beden) {
        this.Giysi_Beden = Giysi_Beden;
    }

    public String getAyakkabi_No() {
        return Ayakkabi_No;
    }

    public void setAyakkabi_No(String Ayakkabi_No) {
        this.Ayakkabi_No = Ayakkabi_No;
    }

    public String getOzel_Durum() {
        return Ozel_Durum;
    }

    public void setOzel_Durum(String Ozel_Durum) {
        this.Ozel_Durum = Ozel_Durum;
    }

    public String getDuzenlemeUyari() {
        return duzenlemeUyari;
    }

    public void setDuzenlemeUyari(String duzenlemeUyari) {
        this.duzenlemeUyari = duzenlemeUyari;
    }

    public String getAdres() {
        return Adres;
    }

    public void setAdres(String Adres) {
        this.Adres = Adres;
    }

    public String getIlce() {
        return Ilce;
    }

    public void setIlce(String Ilce) {
        this.Ilce = Ilce;
    }

    public String getIL() {
        return IL;
    }

    public void setIL(String IL) {
        this.IL = IL;
    }

    public String getIs_Telefon() {
        return Is_Telefon;
    }

    public void setIs_Telefon(String Is_Telefon) {
        this.Is_Telefon = Is_Telefon;
    }

    public String getEv_Telefon() {
        return Ev_Telefon;
    }

    public void setEv_Telefon(String Ev_Telefon) {
        this.Ev_Telefon = Ev_Telefon;
    }

    public String getCep_Telefon() {
        return Cep_Telefon;
    }

    public void setCep_Telefon(String Cep_Telefon) {
        this.Cep_Telefon = trim(Cep_Telefon);
    }

    public String getMail_Adresi() {
        return Mail_Adresi;
    }

    public void setMail_Adresi(String Mail_Adresi) {
        this.Mail_Adresi = Mail_Adresi;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String Web) {
        this.Web = Web;
    }

    private String perID;
    private String KartNo;
    private String Ad;
    private String Soyad;
    private String TC_KIMLIK_NO;
    private String SIGORTA_NO;
    private String IS_DURUMU;
    private String KURUM_ID;
    private String Fotograf;
    private String sonuc;

    private String Ogrenim_Turu;
    private String Mezun_Oldugu_Okul;
    private String Kan_Grubu;
    private String Cinsiyet;
    private String Medeni_Durum;
    private String Giysi_Beden;
    private String Ayakkabi_No;
    private String Ozel_Durum;
    public String duzenlemeUyari;

    private String Adres;
    private String Ilce;
    private String IL;
    private String Is_Telefon;
    private String Ev_Telefon;
    private String Cep_Telefon;
    private String Mail_Adresi;
    private String Web;
    int aramaPersonelID;

    public PersonelDuzenlemeIslemleri() {
    }

    public void duzenlemeBilgiArama() {

        if (this.perID.length() == 0) {
            duzenlemeUyari = "Personel Numarasini Girmediniz";
        } else {
            try {
                aramaPersonelID = Integer.parseInt(this.perID);
                this.SQLSorgu = "select * from personel where perid=?";
                this.Sorgu = this.baglanti.prepareStatement(this.SQLSorgu);
                this.Sorgu.setInt(1, aramaPersonelID);
                boolean sonuc = this.Sorgu.execute();
                if (sonuc == true) {
                    this.sonuclar = this.Sorgu.getResultSet();
                    try {
                        if (this.sonuclar.next()) {

                            this.perID = "" + this.sonuclar.getInt(1);
                            this.KartNo = this.sonuclar.getString(8);
                            this.Ad = this.sonuclar.getString(2);
                            this.Soyad = this.sonuclar.getString(3);
                            this.TC_KIMLIK_NO = this.sonuclar.getString(4);
                            this.SIGORTA_NO = this.sonuclar.getString(5);
                            this.IS_DURUMU = this.sonuclar.getString(6);

                            this.Fotograf = this.sonuclar.getString(7);

                            this.Ogrenim_Turu = this.sonuclar.getString(17);
                            this.Mezun_Oldugu_Okul = this.sonuclar.getString(18);
                            this.Kan_Grubu = this.sonuclar.getString(19);
                            this.Cinsiyet = this.sonuclar.getString(20);
                            this.Medeni_Durum = this.sonuclar.getString(21);
                            this.Giysi_Beden = this.sonuclar.getString(22);
                            this.Ayakkabi_No = this.sonuclar.getString(23);
                            this.Ozel_Durum = this.sonuclar.getString(24);

                            this.Adres = this.sonuclar.getString(9);
                            this.Ilce = this.sonuclar.getString(10);
                            this.IL = this.sonuclar.getString(11);
                            this.Ev_Telefon = this.sonuclar.getString(12);
                            this.Cep_Telefon = this.sonuclar.getString(13);
                            this.Mail_Adresi = this.sonuclar.getString(14);
                            this.Web = this.sonuclar.getString(15);
                            this.Is_Telefon = this.sonuclar.getString(16);
                            this.KURUM_ID = this.sonuclar.getString(25);
                            duzenlemeUyari = "Aradığınız Personel:" + this.Ad + " " + this.Soyad + " Bilgileri Yüklendi";
                        } else {
                            duzenlemeUyari = "" + aramaPersonelID + ":Bulunamadı";
                        }
                    } catch (Exception ex) {
                        duzenlemeUyari += "Personel Arama Islemleri Hata1:" + ex.getMessage();
                    }
                } else {
                    duzenlemeUyari = "0 hatasi";
                }
            } catch (Exception ex) {
                duzenlemeUyari = "Personel Numarasını Doğru Giriniz" + ex.getMessage();
            }
        }
    }

    public void kontrolEt() {

    }

    public void duzenle() {
        try {
            this.SQLSorgu = "update  personel"
                    + " set ad=?,"
                    + " soyad=?,"
                    + " tc_kimlik_no=?,"
                    + " sigorta_no=?,"
                    + " is_durumu=?,"
                    + " kurumid=?,"
                    + " fotograf=?,"
                    + " kartno=?,"
                    + " ogrenimturu=?,"
                    + " mezunolduguokul=?,"
                    + " kangrubu=?,"
                    + " cinsiyet=?,"
                    + " medenidurum=?,"
                    + " giysibeden=?,"
                    + " ayakkabino=?,"
                    + " ozeldurum=?,"
                    + " adres=?,"
                    + " ilce=?,"
                    + " il=?,"
                    + " evtelefon=?,"
                    + " ceptelefon=?,"
                    + " istelefon=?,"
                    + " mailadresi=?,"
                    + " webadresi=?  where perid=?";
            this.Sorgu = this.baglanti.prepareStatement(this.SQLSorgu);
            this.Sorgu.setString(1, this.Ad);
            this.Sorgu.setString(2, this.Soyad);
            this.Sorgu.setString(3, this.TC_KIMLIK_NO);
            this.Sorgu.setString(4, this.SIGORTA_NO);
            this.Sorgu.setString(5, this.IS_DURUMU);
            Sorgu.setString(6, this.KURUM_ID);
            Sorgu.setString(7, Fotograf);
            Sorgu.setString(8, KartNo);
            Sorgu.setString(9, this.Ogrenim_Turu);
            Sorgu.setString(10, this.Mezun_Oldugu_Okul);
            Sorgu.setString(11, this.Kan_Grubu);
            Sorgu.setString(12, this.Cinsiyet);
            Sorgu.setString(13, this.Medeni_Durum);
            Sorgu.setString(14, this.Giysi_Beden);
            Sorgu.setString(15, this.Ayakkabi_No);
            Sorgu.setString(16, this.Ozel_Durum);
            Sorgu.setString(17, Adres);
            Sorgu.setString(18, Ilce);
            Sorgu.setString(19, IL);
            Sorgu.setString(20, Ev_Telefon);
            Sorgu.setString(21, Cep_Telefon);
            Sorgu.setString(22, Is_Telefon);
            Sorgu.setString(23, Mail_Adresi);
            Sorgu.setString(24, Web);
            aramaPersonelID = Integer.parseInt(this.perID);
            Sorgu.setInt(25, aramaPersonelID);
            Sorgu.executeUpdate();
            this.sonuc = "" + this.Ad + " " + this.Soyad + "Bilgileri Başarı İle Güncellendi";

        } catch (SQLException ex) {
            this.sonuc = "Güncelleme Hatasi" + ex.getMessage();
        }

    }

}
