package menu.employeeMenu.indicatorMenu;

import model.Indicator;
import model.OSC;

import java.util.List;
import java.util.Scanner;

import static menu.employeeMenu.indicatorMenu.ShowIndicator.showIndicator;
import static supplier.IndicatorSupplier.getOSCIndicator;

public class ShowIndicatorsOSCList {

    private static Scanner sc;
    private static int response = 0;

    public static void showIndicatorsOSCs (Integer idEmployee, List<OSC> oscs){
        int index = 1;
        for (OSC osc : oscs) {
            System.out.println(index +". "+ osc.getDescription());
            index++;
        }
        System.out.println("0. Volver al menu anterior");

        sc =  new Scanner(System.in);
        response = sc.nextInt();

        if (response != 0) {
            OSC osc = new OSC(
                    oscs.get(response -1).getId(),
                    oscs.get(response -1).getDescription());
            Indicator indicator = getOSCIndicator(idEmployee, osc.getId());
            showIndicator(indicator,"Resgistro indicadores historicos de "+osc.getDescription());
        }
    }
}
