package menu;

import model.Employee;
import org.json.JSONException;

import java.util.Scanner;

import static menu.Login.showLoginMenu;
import static menu.employeeMenu.EmployeeMenu.showEmployeeMenu;
import static supplier.AuthUserSupplier.authUser;


public class MainMenu {

    private static Scanner sc;

    public static void showMenu() throws JSONException {
        int response = 0;
        do {
            System.out.println("Seleccione la opcion deseada");
            System.out.println("1. Acceder");
            System.out.println("0. Salir");

            sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    String []data = showLoginMenu();
                    Employee employee = authUser(data);
                    if (employee != null) {
                        showEmployeeMenu(employee);
                        response = 0;
                    } else
                        System.out.println("El usuario ingresado no existe");
                    break;
                case 0:
                    System.out.println("Adios");
                    break;
                default :
                    System.out.println("Ingresa una opcion correcta");
            }
        } while (response !=0);

    }

}
