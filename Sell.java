package com.example.electroserv;

public class Sell {
    String sellerid;
    String sellername;
    String workareaname;
    String addressname;
    String panname;
    String gstname;
    String adharname;
    String areaname;
    String drops;
    public Sell(){

    }

    public Sell(String sellerid, String sellername, String workareana
                       me, String addressname, String panname, String gstname, String adharname,String drops) {
        this.sellerid = sellerid;
        this.sellername = sellername;
        this.workareaname = workareaname;
        this.addressname = addressname;
        this.panname = panname;
        this.gstname = gstname;
        this.adharname = adharname;
        this.drops=drops;
    }

    public String getSellerid() {
        return sellerid;
    }

    public String getSellername() {
        return sellername;
    }

    public String getWorkareaname() {
        return workareaname;
    }

    public String getAddressname() {
        return addressname;
    }

    public String getPanname() {
        return panname;
    }

    public String getGstname() {
        return gstname;
    }

    public String getAdharname() {
        return adharname;
    }


}
