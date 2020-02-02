package menu.employeeMenu.indicatorMenu;

import model.http.indicators.MonthlyRequest;

import java.util.Scanner;

public class ShowMonthlyIndicators {

    private static Scanner sc;
    private static int response = 0;

    public static MonthlyRequest showMonthlyIndicator(Integer idEmployee){

        sc =  new Scanner(System.in);
        System.out.println("Ingrese el numero de mes entre 1 y 12");
        int monthNumber = sc.nextInt();
        System.out.println("Ingrese el numero de año desde 2016 ");
        int yearNumber = sc.nextInt();

        return new MonthlyRequest(idEmployee, monthNumber, yearNumber);
    }
}
