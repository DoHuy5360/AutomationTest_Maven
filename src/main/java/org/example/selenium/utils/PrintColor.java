package org.example.selenium.utils;

public class PrintColor {

    public static void green(String raw){
        System.out.println("\u001B[32m" + raw + "\u001B[0m\n");
    }
    public static void red(String raw) {
        System.out.println("\u001B[38;2;254;101;253m" + raw + "\u001B[0m\n");
    }
    public static void yellow(String raw) {
        System.out.println("\u001B[38;2;253;253;0m" + raw + "\u001B[0m\n");
    }
    public static void turquoise(String raw) {
        System.out.println("\u001B[38;2;22;220;212m" + raw + "\u001B[0m\n");
    }


}
