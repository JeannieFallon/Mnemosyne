package com.metatarsal.models;

public class Text {

    private String plainTxt;
    private String cipherTxt;
    private int txtLength;
    private int shiftVal;

    public Text() {

    }

    public Text(String plainTxt, int shiftVal) {
        this.plainTxt = plainTxt;
        this.txtLength = plainTxt.length();
        this.shiftVal = shiftVal;
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

    public int getShiftVal() {
        return shiftVal;
    }
}
