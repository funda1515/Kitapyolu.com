
package kütüphane;


public class KitapProperties {
    private int KitapNo;
    private String KitapAd;
    private String KitapYazari;
    private int KitapBaskiYil;
    private int KitapSayfaSayisi;
    private String KitapDil;
    private String KitapYayinEvi;

   
    public KitapProperties(String KitapAd,String KitapYazari,int KitapBaskiYil,int KitapSayfaSayisi,String KitapDili,String KitapYayinEvi,int KitapNo){
    this.KitapAd=KitapAd;
    this.KitapBaskiYil=KitapBaskiYil;
    this.KitapDil=KitapDili;
    this.KitapNo=KitapNo;
    this.KitapSayfaSayisi=KitapSayfaSayisi;
    this.KitapYayinEvi=KitapYayinEvi;
    this.KitapYazari=KitapYazari;
}

    /**
     * @return the KitapNo
     */
    public int getKitapNo() {
        return KitapNo;
    }

    /**
     * @param KitapNo the KitapNo to set
     */
    public void setKitapNo(int KitapNo) {
        this.KitapNo = KitapNo;
    }

    /**
     * @return the KitapAd
     */
    public String getKitapAd() {
        return KitapAd;
    }

    /**
     * @param KitapAd the KitapAd to set
     */
    public void setKitapAd(String KitapAd) {
        this.KitapAd = KitapAd;
    }

    /**
     * @return the KitapYazari
     */
    public String getKitapYazari() {
        return KitapYazari;
    }

    /**
     * @param KitapYazari the KitapYazari to set
     */
    public void setKitapYazari(String KitapYazari) {
        this.KitapYazari = KitapYazari;
    }

    /**
     * @return the KitapBaskiYil
     */
    public int getKitapBaskiYil() {
        return KitapBaskiYil;
    }

    /**
     * @param KitapBaskiYil the KitapBaskiYil to set
     */
    public void setKitapBaskiYil(int KitapBaskiYil) {
        this.KitapBaskiYil = KitapBaskiYil;
    }

    /**
     * @return the KitapSayfaSayisi
     */
    public int getKitapSayfaSayisi() {
        return KitapSayfaSayisi;
    }

    /**
     * @param KitapSayfaSayisi the KitapSayfaSayisi to set
     */
    public void setKitapSayfaSayisi(int KitapSayfaSayisi) {
        this.KitapSayfaSayisi = KitapSayfaSayisi;
    }

    /**
     * @return the KitapDil
     */
    public String getKitapDil() {
        return KitapDil;
    }

    /**
     * @param KitapDil the KitapDil to set
     */
    public void setKitapDil(String KitapDil) {
        this.KitapDil = KitapDil;
    }

    /**
     * @return the KitapYayınEvi
     */
    public String getKitapYayinEvi() {
        return KitapYayinEvi;
    }

    /**
     * @param KitapYayınEvi the KitapYayınEvi to set
     */
    public void setKitapYayinEvi(String KitapYayınEvi) {
        this.KitapYayinEvi = KitapYayinEvi;
    }

}
    