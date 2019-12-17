package menu;

import model.http.LoginRequest;

import java.util.Scanner;

public class Login {

    private static Scanner sc;

    public static LoginRequest showLoginMenu(){

        sc = new Scanner(System.in);
        System.out.println("Bienvenido");
        System.out.println("Ingrese su nickname:");
        String nickname = sc.nextLine();
        System.out.println("Ingrese password:");
        String password = sc.nextLine();

        return new LoginRequest(nickname,password);
    }


}
