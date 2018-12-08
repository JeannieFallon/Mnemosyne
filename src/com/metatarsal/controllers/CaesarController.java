package com.metatarsal.controllers;

import com.metatarsal.models.Text;

public class CaesarController {

    public Text goCaesarCipher(Text text) {

        String cipherTxt = "This is the test cipher text";
        text.setCipherTxt(cipherTxt);

        return text;
    }
}
