package menu.employeeMenu.indicatorMenu;

import model.Indicator;
import model.OSC;

import java.util.List;
import java.util.Scanner;

import static menu.ReturnMenu.returnMenu;
import static menu.employeeMenu.indicatorMenu.ShowIndicator.showIndicator;
import static supplier.IndicatorSupplier.getHistoricalIndicator;
import static supplier.OSCSupplier.getOSCs;
import static menu.employeeMenu.indicatorMenu.ShowIndicatorsOSCs.showIndicatorsOSCs;

public class ShowIndicatorsMenu {

    private static Scanner sc;
    private static boolean flag = true;
    private static int response = 0;

    public static void showIndicatorMenu(Integer idEmployee) {

        do {
            System.out.println("Selecciona la opción deseada");
            System.out.println("1. Indicadores históricos");
            System.out.println("2. Indicadores por OSC");
            System.out.println("3. Indicadores mensuales");
            System.out.println("0. Volver al menu anterior");

            sc =  new Scanner(System.in);
            response = sc.nextInt();

            switch (response) {
                case 1:
                    flag = false;
                    Indicator indicator = getHistoricalIndicator(idEmployee);
                    showIndicator(indicator, "Resgistro indicadores historicos");
                    response = returnMenu();

                    break;
                case 2:
                    flag = false;
                    List<OSC> oscs = getOSCs(idEmployee);
                    showIndicatorsOSCs(idEmployee,oscs);
                    break;
                case 3:
                    flag = false;

                    break;
                case 0:
                    System.out.println("Adios");
                default:
                    System.out.println("Debe ingresar una opcion correcta");

            }

        } while (response != 0);
    }
}
