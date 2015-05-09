package com.personelyonetimsistemi.personelBean;

import com.personelyonetimsistem.model.Personel;
import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonelAramaIslemleri extends VeritabaniIslem {

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

    public String getAramaUyari() {
        return aramaUyari;
    }

    public void setAramaUyari(String aramaUyari) {
        this.aramaUyari = aramaUyari;
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
    public String aramaUyari;

    private String Adres;
    private String Ilce;
    private String IL;
    private String Is_Telefon;
    private String Ev_Telefon;
    private String Cep_Telefon;
    private String Mail_Adresi;
    private String Web;

    public String getPerID() {
        return perID;
    }

    public void setPerID(String perID) {
        this.perID = perID;
    }

    public List<Personel> getPersonelListesi() {
        return personelListesi;
    }

    public void setPersonelListesi(List<Personel> personelListesi) {
        this.personelListesi = personelListesi;
    }

    public List<Personel> personelListesi;

    public PersonelAramaIslemleri() {

    }

    public String getUyariMesaj() {
        return uyariMesaj;
    }

    public void setUyariMesaj(String uyariMesaj) {
        this.uyariMesaj = uyariMesaj;
    }
    public String uyariMesaj;

    public void arama() {
        this.personelListesi = new ArrayList<Personel>();

        try {

            if (this.Ad.length() == 0 && this.Soyad.length() == 0 && this.perID.length() == 0
                    && this.TC_KIMLIK_NO.length() == 0 && this.KartNo.length() == 0
                    && this.Cep_Telefon.length() == 0 && this.IS_DURUMU.length() == 0 && this.KURUM_ID.length() == 0) {
                aramaUyari = "En Az Bir Arama Alanına Değer Girmelisiniz";
                return;
            }

            if (!"".equals(this.perID)) {
                try {
                    int aranan = Integer.parseInt(this.perID);
                    SQLSorgu = "select * from personel where perid=?";
                    Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                    this.Sorgu.setInt(1, aranan);
                } catch (Exception e) {
                    aramaUyari = "Personel Numarası Sayısal Bir Değer Olmalı";
                    return;
                }
            } else if (this.Ad.length() != 0) {
                SQLSorgu = "select * from personel where lower(ad) like lower(?) or  lower(soyad) like lower(?)";
                Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                this.Sorgu.setString(1, "%" + this.Ad + "%");
                this.Sorgu.setString(2, "%" + this.Ad + "%");
                this.aramaUyari = "Ad soyad arama";

            } else if (this.TC_KIMLIK_NO.length() != 0) {
                try {
                    this.aramaUyari += "tc kimlik arama";
                    SQLSorgu = "select * from personel where tc_kimlik_no like ?";
                    Sorgu = this.baglanti.prepareStatement(SQLSorgu);
                    this.Sorgu.setString(1, "%" + this.TC_KIMLIK_NO + "%");
                } catch (Exception ex) {
                    this. aramaUyari="Hata tc:"+ex.getMessage();
                }
            }

            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {
                sonuclar = Sorgu.getResultSet();
                try {
                    while (this.sonuclar.next()) {

                        int db_perid = this.sonuclar.getInt(1);
                        String db_kartno = this.sonuclar.getString(8);
                        String db_ad = this.sonuclar.getString(2);
                        String db_soyad = this.sonuclar.getString(3);
                        String db_tc_kimlik_no = this.sonuclar.getString(4);
                        String db_sigorta_no = this.sonuclar.getString(5);
                        String db_is_durumu = this.sonuclar.getString(6);

                        String db_fotograf = this.sonuclar.getString(7);

                        String db_ogremimturu = this.sonuclar.getString(17);
                        String db_mezunolduguokul = this.sonuclar.getString(18);
                        String db_kangurubu = this.sonuclar.getString(19);
                        String db_cinsiyet = this.sonuclar.getString(20);
                        String db_medenidurum = this.sonuclar.getString(21);
                        String db_giysibeden = this.sonuclar.getString(22);
                        String db_ayakkabino = this.sonuclar.getString(23);
                        String db_ozeldurum = this.sonuclar.getString(24);

                        String db_adres = this.sonuclar.getString(9);
                        String db_ilce = this.sonuclar.getString(10);
                        String db_il = this.sonuclar.getString(11);
                        String db_evtelefon = this.sonuclar.getString(12);
                        String db_ceptelefon = this.sonuclar.getString(13);
                        String db_mailadresi = this.sonuclar.getString(14);
                        String db_webadresi = this.sonuclar.getString(15);
                        String db_istelefon = this.sonuclar.getString(16);
                        String db_kurumid = this.sonuclar.getString(25);
                        this.personelListesi.add(new Personel(
                                db_perid,
                                db_kartno,
                                db_ad,
                                db_soyad,
                                db_tc_kimlik_no,
                                db_sigorta_no,
                                db_is_durumu,
                                db_kurumid,
                                db_fotograf,
                                db_ogremimturu,
                                db_mezunolduguokul,
                                db_kangurubu,
                                db_cinsiyet,
                                db_medenidurum,
                                db_giysibeden,
                                db_ayakkabino,
                                db_ozeldurum,
                                db_adres,
                                db_ilce,
                                db_il,
                                db_istelefon,
                                db_evtelefon,
                                db_ceptelefon,
                                db_mailadresi,
                                db_webadresi));
                    }
                } catch (Exception ex) {
                    aramaUyari += "Personel Arama Islemleri Hata1:" + ex.getMessage();
                }
            } else {
                aramaUyari = "0 hatasi";
            }

        } catch (Exception ex) {
            aramaUyari = "Hata Sql:" + ex.getMessage();
        } finally {
            if (this.personelListesi.size() > 0) {
                aramaUyari = "Bulunan Kayit Sayisi:" + this.personelListesi.size();
            } else {
                aramaUyari += "Aradığınız Kayıt Bulunamadı.";
            }
        }
        alanlariSifirla();
    }

    public void tumunuGetir() {
        this.personelListesi = new ArrayList<Personel>();
        try {

            SQLSorgu = "select * from personel";
            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            boolean sonuc = Sorgu.execute();
            if (sonuc == true) {
                sonuclar = Sorgu.getResultSet();
                try {
                    while (this.sonuclar.next()) {

                        int db_perid = this.sonuclar.getInt(1);
                        String db_kartno = this.sonuclar.getString(8);
                        String db_ad = this.sonuclar.getString(2);
                        String db_soyad = this.sonuclar.getString(3);
                        String db_tc_kimlik_no = this.sonuclar.getString(4);
                        String db_sigorta_no = this.sonuclar.getString(5);
                        String db_is_durumu = this.sonuclar.getString(6);

                        String db_fotograf = this.sonuclar.getString(7);

                        String db_ogremimturu = this.sonuclar.getString(17);
                        String db_mezunolduguokul = this.sonuclar.getString(18);
                        String db_kangurubu = this.sonuclar.getString(19);
                        String db_cinsiyet = this.sonuclar.getString(20);
                        String db_medenidurum = this.sonuclar.getString(21);
                        String db_giysibeden = this.sonuclar.getString(22);
                        String db_ayakkabino = this.sonuclar.getString(23);
                        String db_ozeldurum = this.sonuclar.getString(24);

                        String db_adres = this.sonuclar.getString(9);
                        String db_ilce = this.sonuclar.getString(10);
                        String db_il = this.sonuclar.getString(11);
                        String db_evtelefon = this.sonuclar.getString(12);
                        String db_ceptelefon = this.sonuclar.getString(13);
                        String db_mailadresi = this.sonuclar.getString(14);
                        String db_webadresi = this.sonuclar.getString(15);
                        String db_istelefon = this.sonuclar.getString(16);
                        String db_kurumid = this.sonuclar.getString(25);
                        this.personelListesi.add(new Personel(
                                db_perid,
                                db_kartno,
                                db_ad,
                                db_soyad,
                                db_tc_kimlik_no,
                                db_sigorta_no,
                                db_is_durumu,
                                db_kurumid,
                                db_fotograf,
                                db_ogremimturu,
                                db_mezunolduguokul,
                                db_kangurubu,
                                db_cinsiyet,
                                db_medenidurum,
                                db_giysibeden,
                                db_ayakkabino,
                                db_ozeldurum,
                                db_adres,
                                db_ilce,
                                db_il,
                                db_istelefon,
                                db_evtelefon,
                                db_ceptelefon,
                                db_mailadresi,
                                db_webadresi));
                    }
                } catch (Exception ex) {
                    aramaUyari += "Personel Arama Islemleri Hata1:" + ex.getMessage();
                }
            } else {
                aramaUyari = "0 hatasi";
            }
            aramaUyari = "Kayit Sayisi:" + this.personelListesi.size();
        } catch (SQLException ex) {
            aramaUyari = "Hata Sql:" + ex.getMessage();
        } finally {
            if (this.personelListesi.size() > 0) {
                aramaUyari = "Bulunan Kayit Sayisi:" + this.personelListesi.size();
            } else {
                aramaUyari = "Aradığınız Kayıt Bulunamadı.";
                alanlariSifirla();
            }

        }

    }

    public void alanlariSifirla() {
        perID = "";
        KartNo = "";
        Ad = "";
        Soyad = "";
        TC_KIMLIK_NO = "";
        SIGORTA_NO = "";
        IS_DURUMU = "";
        KURUM_ID = "";
        Fotograf = "";
        Ogrenim_Turu = "";
        Mezun_Oldugu_Okul = "";
        Kan_Grubu = "";
        Cinsiyet = "";
        Medeni_Durum = "";
        Giysi_Beden = "";
        Ayakkabi_No = "";
        Ozel_Durum = "";
        Cep_Telefon = "";
    }
}
