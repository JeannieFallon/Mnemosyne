package com.metatarsal.models;

public class Text {

    private String plainTxt;
    private String cipherTxt;
    private int txtLength;

    public Text() {

    }

    public Text(String plainTxt) {
        this.plainTxt = plainTxt;
    }

    public String getPlainTxt() {
        return plainTxt;
    }

    public void setPlainTxt(String plainTxt) {
        this.plainTxt = plainTxt;
    }

    public String getCipherTxt() {
        return cipherTxt;
    }

    public void setCipherTxt(String cipherTxt) {
        this.cipherTxt = cipherTxt;
    }

    public int getTxtLength() {
        return txtLength;
    }

    public void setTxtLength() {
        this.txtLength = plainTxt.length();
    }
}
