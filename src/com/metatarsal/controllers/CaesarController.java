package com.metatarsal.controllers;
import com.metatarsal.models.Text;

public class CaesarController {

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
        int plainAscii = (int)charToShift;
        int cipherAscii = getCipherAscii(plainAscii, shiftVal);
        //TODO fix conversion
        String newChar = Character.toString((char)cipherAscii);

        return newChar;
    }

    public int getCipherAscii(int asciiVal, int shiftVal) {

        // only rotate upper and lower case letters in text
        if (asciiVal >= 97 && asciiVal <= 122) {
            asciiVal = getRotation((asciiVal - 97), shiftVal);
        } else if (asciiVal >= 65 && asciiVal <= 90) {
            asciiVal = getRotation((asciiVal - 65), shiftVal);
        }

        return asciiVal;
    }

    public int getRotation(int alphaIdx, int key) {
        //TODO fix rotation
        return (alphaIdx + key) % 26;
    }
}
