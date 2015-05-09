/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.veritabani;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author salih
 */
public class VeritabaniErisimi {

    private String url = "jdbc:postgresql://localhost/personel_yonetim";
    private String user = "postgres";
    private String password = "123456";
    public Connection baglanti;

    public VeritabaniErisimi() {
        try {
            if(BaglantiKur())
            {
                //veritabani baglantisi 
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VeritabaniErisimi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean BaglantiKur() throws ClassNotFoundException {
        boolean durum = false;
        try {
            Class.forName("org.postgresql.Driver");
            baglanti = DriverManager.getConnection(url, user, password);
            if (baglanti.isClosed() == false) {
                durum = true;
            }
        } catch (SQLException ex) {

        } finally {
        }
        return durum;
    }

    public boolean BaglantiKapat() {
        boolean durum = false;
        try {

            if (baglanti.isClosed() == false) {
                baglanti.close();
                durum = true;
            }
        } catch (SQLException ex) {

        } finally {
        }
        return durum;
    }
}
