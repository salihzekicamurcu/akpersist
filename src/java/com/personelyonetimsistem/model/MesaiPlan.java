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
public class MesaiPlan {

    public String getIsBaslangicSaat() {
        return isBaslangicSaat;
    }

    public void setIsBaslangicSaat(String isBaslangicSaat) {
        this.isBaslangicSaat = isBaslangicSaat;
    }

    public String getIsBitisSaat() {
        return isBitisSaat;
    }

    public void setIsBitisSaat(String isBitisSaat) {
        this.isBitisSaat = isBitisSaat;
    }

    public String getGecikmeTolerans() {
        return gecikmeTolerans;
    }

    public void setGecikmeTolerans(String gecikmeTolerans) {
        this.gecikmeTolerans = gecikmeTolerans;
    }

    public float getMesaiSaatUcret() {
        return mesaiSaatUcret;
    }

    public void setMesaiSaatUcret(float mesaiSaatUcret) {
        this.mesaiSaatUcret = mesaiSaatUcret;
    }

    public float getEkMesaiUcret() {
        return ekMesaiUcret;
    }

    public void setEkMesaiUcret(float ekMesaiUcret) {
        this.ekMesaiUcret = ekMesaiUcret;
    }

    public int getMesaiCalismaSaat() {
        return mesaiCalismaSaat;
    }

    public void setMesaiCalismaSaat(int mesaiCalismaSaat) {
        this.mesaiCalismaSaat = mesaiCalismaSaat;
    }

    public int getMesaiPlanId() {
        return mesaiPlanId;
    }

    public void setMesaiPlanId(int mesaiPlanId) {
        this.mesaiPlanId = mesaiPlanId;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    private String aciklama;
    private int mesaiPlanId;
    private String isBaslangicSaat;
    private String isBitisSaat;
    private String gecikmeTolerans;
    private float mesaiSaatUcret;
    private float ekMesaiUcret;
    private int mesaiCalismaSaat;

    public MesaiPlan(int mesaiPlanId, String isBaslangicSaat, String isBitisSaat, String gecikmeTolerans, float mesaiSaatUcret, float ekMesaiUcret, int mesaiCalismaSaat,String aciklama) {
        this.mesaiPlanId = mesaiPlanId;
        this.isBaslangicSaat = isBaslangicSaat;
        this.isBitisSaat = isBitisSaat;
        this.gecikmeTolerans = gecikmeTolerans;
        this.mesaiSaatUcret = mesaiSaatUcret;
        this.ekMesaiUcret = ekMesaiUcret;
        this.mesaiCalismaSaat = mesaiCalismaSaat;
        this.aciklama=aciklama;
    }

}
