/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistem.model;

/**
 *
 * @author salih
 */
public class Personel {

    public int getPerID() {
        return PerID;
    }

    public void setPerID(int PerID) {
        this.PerID = PerID;
    }

    public String getKartNo() {
        return KartNo;
    }

    public void setKartNo(String KartNo) {
        this.KartNo = KartNo;
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

    public Personel(int PerID, String KartNo, String Ad, String Soyad, String TC_KIMLIK_NO, String SIGORTA_NO, String IS_DURUMU, String KURUM_ID, String Fotograf, String Ogrenim_Turu, String Mezun_Oldugu_Okul, String Kan_Grubu, String Cinsiyet, String Medeni_Durum, String Giysi_Beden, String Ayakkabi_No, String Ozel_Durum, String Adres, String Ilce, String IL, String Is_Telefon, String Ev_Telefon, String Cep_Telefon, String Mail_Adresi, String Web) {
        this.PerID = PerID;
        this.KartNo = KartNo;
        this.Ad = Ad;
        this.Soyad = Soyad;
        this.TC_KIMLIK_NO = TC_KIMLIK_NO;
        this.SIGORTA_NO = SIGORTA_NO;
        this.IS_DURUMU = IS_DURUMU;
        this.KURUM_ID = KURUM_ID;
        this.Fotograf = Fotograf;
        this.Ogrenim_Turu = Ogrenim_Turu;
        this.Mezun_Oldugu_Okul = Mezun_Oldugu_Okul;
        this.Kan_Grubu = Kan_Grubu;
        this.Cinsiyet = Cinsiyet;
        this.Medeni_Durum = Medeni_Durum;
        this.Giysi_Beden = Giysi_Beden;
        this.Ayakkabi_No = Ayakkabi_No;
        this.Ozel_Durum = Ozel_Durum;
        this.Adres = Adres;
        this.Ilce = Ilce;
        this.IL = IL;
        this.Is_Telefon = Is_Telefon;
        this.Ev_Telefon = Ev_Telefon;
        this.Cep_Telefon = Cep_Telefon;
        this.Mail_Adresi = Mail_Adresi;
        this.Web = Web;
    }

    public void setCep_Telefon(String Cep_Telefon) {
        this.Cep_Telefon = Cep_Telefon;
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

    public int PerID;
    public String KartNo;
    public String Ad;
    public String Soyad;
    public String TC_KIMLIK_NO;
    public String SIGORTA_NO;
    public String IS_DURUMU;
    public String KURUM_ID;
    public String Fotograf;
    public String Ogrenim_Turu;
    public String Mezun_Oldugu_Okul;
    public String Kan_Grubu;
    public String Cinsiyet;
    public String Medeni_Durum;
    public String Giysi_Beden;
    public String Ayakkabi_No;
    public String Ozel_Durum;
    public String Adres;
    public String Ilce;
    public String IL;
    public String Is_Telefon;
    public String Ev_Telefon;
    public String Cep_Telefon;
    public String Mail_Adresi;
    public String Web;
}
