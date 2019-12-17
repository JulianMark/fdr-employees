package menu.employeeMenu.indicatorMenu;

import model.Indicator;
import model.OSC;
import model.dao.OSCList;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Scanner;

import static menu.ReturnMenu.returnMenu;
import static menu.employeeMenu.indicatorMenu.ShowIndicator.showIndicator;
import static menu.employeeMenu.indicatorMenu.ShowIndicatorsOSCList.showIndicatorsOSCs;
import static supplier.IndicatorSupplier.getHistoricalIndicator;
import static supplier.OSCSupplier.getOSCs;

public class ShowIndicatorsMenu {

    private static Scanner sc;
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
                    ResponseEntity<Indicator> responseEntityIndicator = getHistoricalIndicator(idEmployee);
                    if (responseEntityIndicator.getStatusCode().value() == 200){
                        Indicator indicator = responseEntityIndicator.getBody();
                        showIndicator(indicator, "Resgistro indicadores historicos");
                        response = returnMenu();
                    }
                    break;
                case 2:
                    ResponseEntity<OSCList> responseEntityOSCs = getOSCs(idEmployee);
                    List<OSC> oscList = responseEntityOSCs.getBody().getOscList();
                    showIndicatorsOSCs(idEmployee,oscList);
                    break;
                case 0:
                    System.out.println("Adios");
                default:
                    System.out.println("Debe ingresar una opcion correcta");

            }
        } while (response != 0);
    }
}
