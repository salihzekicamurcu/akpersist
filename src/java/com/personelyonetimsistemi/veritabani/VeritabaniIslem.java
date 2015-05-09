/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personelyonetimsistemi.veritabani;

import java.sql.*;

/**
 *
 * @author salih
 */
public abstract class VeritabaniIslem extends VeritabaniErisimi {

    public VeritabaniIslem() {

    }
    public PreparedStatement Sorgu;
    public ResultSet sonuclar;
    public String SQLSorgu;
    public void finalize()
    {
        this.BaglantiKapat();
    }
}
