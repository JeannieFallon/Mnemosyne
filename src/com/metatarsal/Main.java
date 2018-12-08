package com.metatarsal;
import com.metatarsal.controllers.CaesarController;
import com.metatarsal.models.Text;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        CaesarController caesarController = new CaesarController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to be enciphered:\n");

        String input = scanner.nextLine();
        Text text = new Text(input);
        text = caesarController.goCaesarCipher(text);

        System.out.println("Plain text: " + text.getPlainTxt());
        System.out.println("Cipher text: " + text.getCipherTxt());
        System.out.println("Length of text: " + text.getTxtLength());
    }
}
