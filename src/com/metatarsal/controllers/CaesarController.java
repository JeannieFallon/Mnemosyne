package com.metatarsal.controllers;
import com.metatarsal.models.Text;

public class CaesarController {

/*
* Run Caesar cipher on input text string using input integer as shift value.
* 09 Dec 18 - Working draft
* */
    public Text goCaesarCipher(Text text) {
        String cipherTxt = "";
        int txtLen = text.getTxtLength();
        int shiftVal = text.getShiftVal();
        char[] plainArr = text.getPlainTxt().toCharArray();
        char plainChar;

        for (int i = 0; i < txtLen; i++) {
            plainChar = plainArr[i];
            cipherTxt += shiftChar(plainChar, shiftVal);
        }

        text.setCipherTxt(cipherTxt);

        return text;
    }

    public String shiftChar(char charToShift, int shiftVal) {
        String cipherChar;
        int asciiVal = (int)charToShift;
        int alphaDiffVal = 0;
        boolean isShift = false;

        // only shift upper or lower case letters in text
        if (asciiVal >= 97 && asciiVal <= 122) {
            isShift = true;
            alphaDiffVal = 97;
        } else if (asciiVal >= 65 && asciiVal <= 90) {
            isShift = true;
            alphaDiffVal = 65;
        }

        if (isShift) {
            asciiVal = getCipherAscii(asciiVal, alphaDiffVal, shiftVal);
        }

        //TODO make more efficient by returning int & converting up one level
        // get rid of duplicate String initialization
        cipherChar = Character.toString((char)asciiVal);

        return cipherChar;
    }

    public int getCipherAscii(int asciiVal, int alphaDiffVal, int shiftVal) {
        // get index of letter, assuming standard alphabet a - z with indices 0 - 25
        int alphaIdx = asciiVal - alphaDiffVal;
        // wrap rotation around standard alphabet
        alphaIdx = getRotation(alphaIdx, shiftVal);
        // return to original ASCII range
        return alphaIdx + alphaDiffVal ;
    }

    public int getRotation(int alphaIdx, int shiftVal) {
        return (alphaIdx + shiftVal) % 26;
    }
}