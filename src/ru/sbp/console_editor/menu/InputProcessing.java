package ru.sbp.console_editor.menu;

import java.util.Scanner;

public class InputProcessing {
    public static String enterValueMenu() {
        Scanner sc = new Scanner(System.in);
        String symbol = sc.nextLine();
        return symbol;
    }

}
