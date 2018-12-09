package com.metatarsal;
import com.metatarsal.controllers.CaesarController;
import com.metatarsal.models.Text;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        CaesarController caesarController = new CaesarController();
        Scanner scanner = new Scanner(System.in);

        //TODO validate input
        System.out.println("Enter the text to be enciphered:\n");
        String inputTxt = scanner.nextLine();

        System.out.println("Enter the shift value: ");
        int shiftVal = scanner.nextInt();

        Text text = new Text(inputTxt, shiftVal);
        text = caesarController.goCaesarCipher(text);

        //TODO string builder?
        System.out.println("Plain text: " + text.getPlainTxt() +
                            "\nCipher text: " + text.getCipherTxt() +
                            "\nShift value: " + text.getShiftVal());
    }
}
