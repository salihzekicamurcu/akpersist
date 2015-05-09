/*
 * Yeni Bir personel eklenmek istediginde yapilacak islemlerin yer aldıgi bean 
 * 
 * 
 */
package com.personelyonetimsistemi.personelBean;

import com.personelyonetimsistem.model.Personel;
import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salih
 */
public class PersonelKayitIslemleri extends VeritabaniIslem {

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

    public int getPersonel_Iletisim_ID() {
        return Personel_Iletisim_ID;
    }

    public void setPersonel_Iletisim_ID(int Personel_Iletisim_ID) {
        this.Personel_Iletisim_ID = Personel_Iletisim_ID;
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

    private String KartNo;
    private String Ad;
    private String Soyad;
    private String TC_KIMLIK_NO;
    private String SIGORTA_NO;
    private String IS_DURUMU;
    private String KURUM_ID;
    private int Personel_Iletisim_ID;
    private String Fotograf;
    private String sonuc;

    /*
    
     Kisisel Bilgiler
    
     */
    private String Ogrenim_Turu;
    private String Mezun_Oldugu_Okul;
    private String Kan_Grubu;
    private String Cinsiyet;
    private String Medeni_Durum;
    private String Giysi_Beden;
    private String Ayakkabi_No;
    private String Ozel_Durum;

    public List<Ayakkabi> getAyakkabinumaralari() {
        return ayakkabinumaralari;
    }

    public List<Ayakkabi> ayakkabinumaralari;

    public class Ayakkabi {

        public String getAnumara() {
            return anumara;
        }

        public void setAnumara(String anumara) {
            this.anumara = anumara;
        }

        public String anumara;

        public Ayakkabi(String a) {
            this.anumara = a;
        }
    }

    void ayakkabinoata() {
        ayakkabinumaralari = new ArrayList<Ayakkabi>();
        for (int i = 30; i < 60; i++) {
            ayakkabinumaralari.add(new Ayakkabi("" + i));
        }
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
    /*
     iletisim bilgileri
     */
    Personel personelNesne;
    private String Adres;
    private String Ilce;
    private String IL;
    private String Is_Telefon;
    private String Ev_Telefon;
    private String Cep_Telefon;
    private String Mail_Adresi;
    private String Web;
    private boolean kontrol = false;

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

    public String getUyarilar() {
        return uyarilar;
    }

    public void setUyarilar(String uyarilar) {
        this.uyarilar = uyarilar;
    }

    private String uyarilar = "";
 
    public PersonelKayitIslemleri() {
        /*
         Sayfaya İlk Değer Atamasi
         */
        ayakkabinoata();
    }

    public void kaydiBitir() {
        kontrolEt();
        try {

            //Personel Bilgi Ekleme
            this.SQLSorgu = "insert into  personel("
                    + "ad,"
                    + "soyad,"
                    + "tc_kimlik_no,"
                    + "sigorta_no,"
                    + "is_durumu,"
                    + "kurumid,"
                    + "fotograf,"
                    + "kartno,"
                    + "ogrenimturu,"
                    + "mezunolduguokul,"
                    + "kangrubu,"
                    + "cinsiyet,"
                    + "medenidurum,"
                    + "giysibeden,"
                    + "ayakkabino,"
                    + "ozeldurum,"
                    + "adres,"
                    + "ilce,"
                    + "il,"
                    + "evtelefon,"
                    + "ceptelefon,"
                    + "istelefon,"
                    + "mailadresi,"
                    + "webadresi) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            int sorguSonuc = Sorgu.executeUpdate();
            if (sorguSonuc > 0) {
                sonuc = "Personel Bilgileri Kayıt Edildi.";
                alanlariSifirla();
            }

        } catch (Exception ex) {
            Logger.getLogger(PersonelKayitIslemleri.class
                    .getName()).log(Level.SEVERE, null, ex);
            sonuc = "hata:" + ex.getMessage();
        }
        //this.BaglantiKapat();

    }

    public void kontrolEt() {
        if (Ad.length() == 0) {
            uyarilar += "Personel Bilgileri:Ad Giriniz,";
            return;
        } else if (Soyad.length() == 0) {
            uyarilar += "Personel Bilgileri:Soyad Giriniz,";
            return;
        } else if (TC_KIMLIK_NO.length() == 0) {
            uyarilar += "Personel Bilgileri:Kimlik Numarası Giriniz,";
            return;
        } else if (Cep_Telefon.length() == 0) {
            uyarilar += "İletisim Bilgileri:Cep Telefonu Numarası Giriniz";
            return;
        } else {
            kontrol = true;
            uyarilar = "Kaydı Tamamlayabilirsiniz";
        }
    }

    public void alanlariSifirla() {   /*
         Yeni Kayit İcin Alanlari Temizle
         */

        KartNo = "";
        Ad = "";
        Soyad = "";
        TC_KIMLIK_NO = "";
        SIGORTA_NO = "";
        IS_DURUMU = "";
        KURUM_ID = "";
        Ogrenim_Turu = "";
        Mezun_Oldugu_Okul = "";
        Kan_Grubu = "";
        Cinsiyet = "";
        Medeni_Durum = "";
        Giysi_Beden = "";
        Ayakkabi_No = "";
        Ozel_Durum = "";
        Adres = "";
        Ilce = "";
        IL = "";
        Is_Telefon = "";;
        Ev_Telefon = "";
        Cep_Telefon = "";
        Mail_Adresi = "";
        Web = "";
        uyarilar = "";
    }
}
