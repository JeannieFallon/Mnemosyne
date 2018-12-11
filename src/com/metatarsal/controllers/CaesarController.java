package com.metatarsal.controllers;
import com.metatarsal.constants.CipherConstants;
import com.metatarsal.models.Text;

public class CaesarController {

/*
* Run Caesar cipher on input text string using input integer as shift value.
* 11 Dec 18 - Added constants
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

        // only shift upper or lower case letters in text
        if (asciiVal >= CipherConstants.ENG_LOWER_FLOOR && asciiVal <= CipherConstants.ENG_LOWER_CEILING) {
            asciiVal = getCipherAscii(CipherConstants.ENG_LOWER_FLOOR, asciiVal, shiftVal);
        } else if (asciiVal >= CipherConstants.ENG_UPPER_FLOOR && asciiVal <= CipherConstants.ENG_UPPER_CEILING) {
            asciiVal = getCipherAscii(CipherConstants.ENG_UPPER_FLOOR, asciiVal, shiftVal);
        }

        return (char)asciiVal;
    }

    public int getCipherAscii(int asciiDiffVal, int asciiVal, int shiftVal) {
        // map ASCII value onto index of letter in alphabet
        int alphaIdx = asciiVal - asciiDiffVal;
        // wrap rotation around alphabet indices
        alphaIdx = getRotation(alphaIdx, shiftVal);
        // return to original ASCII range
        return alphaIdx + asciiDiffVal;
    }

    public int getRotation(int alphaIdx, int shiftVal) {
        return (alphaIdx + shiftVal) % CipherConstants.ENG_ALPHA_LEN;
    }
}