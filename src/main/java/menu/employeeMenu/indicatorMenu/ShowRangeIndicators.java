package menu.employeeMenu.indicatorMenu;

import model.http.indicators.RangeRequest;

import java.util.Scanner;

public class ShowRangeIndicators {

    private static Scanner sc;
    private static int response = 0;


    public static RangeRequest showRangeIndicator(Integer idEmployee){

        sc =  new Scanner(System.in);
        System.out.println("Ingrese la fecha deseada en el formato yyyy/mm/dd");
        String initialDate = sc.nextLine();
        System.out.println("Ingrese la fecha deseada en el formato yyyy/mm/dd");
        String finalDate = sc.nextLine();

        return new RangeRequest(idEmployee, initialDate, finalDate);
    }
}
