package menu.employeeMenu;

import model.Employee;

import java.util.Scanner;

public class FacerMenu {

    private static Scanner sc;
    private static boolean flag = true;
    private static int response = 0;
    public static void showFacerMenu (Employee employee){
        final String employeeFullName = employee.getName()+" "+employee.getLastName() ;
        do{
            if (flag){
                System.out.println("Bienvenido a tu Dashboard "+ employeeFullName);
                System.out.println("Selecciona una opcion por su numero: ");
            }

        }while (response != 0);
    }
}
