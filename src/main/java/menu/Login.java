package menu;

import java.util.Scanner;

public class Login {

    private static Scanner sc;

    public static String [] showLoginMenu(){

        String [] data = new String[2];
        sc = new Scanner(System.in);
        System.out.println("Bienvenido");
        System.out.println("Ingrese su nickname:");
        data [0] = sc.nextLine();
        System.out.println("Ingrese password:");
        data [1] = sc.nextLine();
        return data;
    }


}
