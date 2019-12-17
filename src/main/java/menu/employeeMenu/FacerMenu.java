package menu.employeeMenu;

import menu.employeeMenu.indicatorMenu.ShowIndicatorsMenu;
import model.Employee;

import java.util.Scanner;

public class FacerMenu {

    private static Scanner sc;
    private static boolean flag = true;
    private static int response = 0;

    public static void showFacerMenu (Employee employee) {
        final String employeeFullName = employee.getName()+" "+employee.getLastName() ;
        do{
            if (flag){
                System.out.println("Bienvenido a tu Dashboard "+ employeeFullName);
                System.out.println("Selecciona una opcion por su numero: ");
            }
            System.out.println("1. Indicadores");

            sc =  new Scanner(System.in);
            response = sc.nextInt();

            switch (response) {
                case 1:
                    flag = false;
                    ShowIndicatorsMenu.showIndicatorMenu(employee.getId());
                    break;
                default:
                    System.out.println("Debe ingresar una opcion correcta");

            }
        }while (response != 0);


    }
}
