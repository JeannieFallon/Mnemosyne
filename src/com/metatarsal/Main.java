package com.metatarsal;
import com.metatarsal.controllers.CaesarController;
import com.metatarsal.models.Text;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        caesar();
    }

    public static void caesar() {
        CaesarController caesarController = new CaesarController();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String inputTxt;
        int shiftVal;

        // get plaintext from user
        System.out.println("Enter the text to be enciphered:");
        inputTxt = scan.nextLine();

        // get shift val from user
        System.out.println("Enter the shift value:");
        while (!scan.hasNextInt()) {
            System.out.println("Please enter an integer for the shift value:");
            scan.next();
        }
        shiftVal = scan.nextInt();

        scan.close();

        Text text = new Text(inputTxt, shiftVal);
        text = caesarController.goCaesarCipher(text);

        sb.append("Plain text: ");
        sb.append(text.getPlainTxt());
        sb.append("\nCipher text: ");
        sb.append(text.getCipherTxt());
        sb.append("\nShift value: ");
        sb.append(text.getShiftVal());

        System.out.println(sb);
    }
}
