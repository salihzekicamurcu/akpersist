/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.personelBean;

import com.personelyonetimsistem.model.MaasProgram;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.personelyonetimsistemi.veritabani.VeritabaniIslem;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author salih
 */
@ManagedBean
@SessionScoped
public class PersonelMuhasebe extends VeritabaniIslem {

    public int getDonem() {
        return donem;
    }

    public void setDonem(int donem) {
        this.donem = donem;
    }
    private int donem;

    public String getUyariMesaj() {
        return uyariMesaj;
    }

    public void setUyariMesaj(String uyariMesaj) {
        this.uyariMesaj = uyariMesaj;
    }
    public String uyariMesaj;

    /**
     * Creates a new instance of PersonelMuhasebe
     */
    public PersonelMuhasebe() {
    }

    public void maasListesiGetir(ValueChangeEvent e) {
        this.donem = Integer.parseInt(e.getNewValue().toString());
        this.uyariMesaj = "Donem:" + this.donem;

        this.personelMaasProgramListesi = new ArrayList<MaasProgram>();

        try {
            SQLSorgu = "select * from maasprogram where donem =? order by  perid";

            Sorgu = this.baglanti.prepareStatement(SQLSorgu);
            Sorgu.setInt(1, donem);
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
    }

    public List<MaasProgram> getPersonelMaasProgramListesi() {
        return personelMaasProgramListesi;
    }

    public void setPersonelMaasProgramListesi(List<MaasProgram> personelMaasProgramListesi) {
        this.personelMaasProgramListesi = personelMaasProgramListesi;
    }

    public List<MaasProgram> personelMaasProgramListesi;
}
