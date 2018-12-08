package com.metatarsal;
import com.metatarsal.models.Text;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to be enciphered:\n");

        String input = scanner.nextLine();
        Text text = new Text(input);

        System.out.println("Plain text: " + text.getPlainTxt());
        System.out.println("Length of text: " + text.getTxtLength());
    }
}
