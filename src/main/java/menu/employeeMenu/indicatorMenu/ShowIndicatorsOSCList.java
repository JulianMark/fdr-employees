package menu.employeeMenu.indicatorMenu;

import model.Indicator;
import model.OSC;
import model.http.IndicatorOSCRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Scanner;

import static menu.ReturnMenu.returnMenu;
import static menu.employeeMenu.indicatorMenu.ShowIndicator.showIndicator;
import static supplier.IndicatorSupplier.getOSCIndicator;

public class ShowIndicatorsOSCList {

    private static Scanner sc;
    private static int response = 0;

    public static IndicatorOSCRequest showIndicatorsOSCs (Integer idEmployee, List<OSC> oscList){
        int index = 1;
        for (OSC osc : oscList) {
            System.out.println(index +". "+ osc.getDescription());
            index++;
        }
        System.out.println("0. Volver al menu anterior");

        sc =  new Scanner(System.in);
        response = sc.nextInt();

        if (response != 0) {
            OSC osc = new OSC(
                    oscList.get(response -1).getId(),
                    oscList.get(response -1).getDescription());
            return new IndicatorOSCRequest(idEmployee,osc.getId(),osc.getDescription());
        }
        return new IndicatorOSCRequest();
    }
}
