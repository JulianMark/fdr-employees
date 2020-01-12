package menu.employeeMenu.indicatorMenu;

import model.Indicator;
import model.http.MonthlyRequest;
import org.springframework.http.ResponseEntity;

import java.util.Scanner;

import static menu.ReturnMenu.returnMenu;
import static menu.employeeMenu.indicatorMenu.ShowIndicator.showIndicator;
import static supplier.IndicatorSupplier.getMonthlyIndicator;

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
