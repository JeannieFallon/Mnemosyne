package com.metatarsal.controllers;
import com.metatarsal.models.Text;

public class CaesarController {

/*
* Run Caesar cipher on input text string using input integer as shift value.
* 09 Dec 18 - Working draft
* */
    public Text goCaesarCipher(Text text) {
        StringBuilder sb = new StringBuilder(); //use StringBuffer instead?
        int txtLen = text.getTxtLength();
        int shiftVal = text.getShiftVal();
        char[] charArr = text.getPlainTxt().toCharArray();

        for (int i = 0; i < txtLen; i++) {
            sb.append(shiftChar(charArr[i], shiftVal));
        }

        text.setCipherTxt(sb.toString());

        return text;
    }

    public char shiftChar(char charToShift, int shiftVal) {
        int asciiVal = (int)charToShift;
        int asciiDiffVal = 0;
        boolean isShift = false;

        // only shift upper or lower case letters in text
        if (asciiVal >= 97 && asciiVal <= 122) {
            isShift = true;
            asciiDiffVal = 97;
        } else if (asciiVal >= 65 && asciiVal <= 90) {
            isShift = true;
            asciiDiffVal = 65;
        }

        if (isShift) {
            asciiVal = getCipherAscii(asciiVal, asciiDiffVal, shiftVal);
        }

        return (char)asciiVal;
    }

    public int getCipherAscii(int asciiVal, int asciiDiffVal, int shiftVal) {
        // get index of letter, assuming standard alphabet a - z with indices 0 - 25
        int alphaIdx = asciiVal - asciiDiffVal;
        // wrap rotation around standard alphabet indices
        alphaIdx = getRotation(alphaIdx, shiftVal);
        // return to original ASCII range
        return alphaIdx + asciiDiffVal;
    }

    public int getRotation(int alphaIdx, int shiftVal) {
        return (alphaIdx + shiftVal) % 26;
    }
}