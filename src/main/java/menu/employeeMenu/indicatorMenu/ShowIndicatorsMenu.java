package menu.employeeMenu.indicatorMenu;

import model.Campaign;
import model.Employee;
import model.Indicator;
import model.http.indicators.IndicatorCampaignRequest;
import model.http.indicators.IndicatorOSCRequest;
import model.http.indicators.MonthlyRequest;
import model.http.indicators.RangeRequest;
import org.springframework.http.ResponseEntity;

import java.util.Scanner;

import static menu.ReturnMenu.returnMenu;
import static menu.employeeMenu.campaignMenu.CampaignListMenu.showCampaignListMenu;
import static menu.employeeMenu.indicatorMenu.ShowIndicator.showIndicator;
import static menu.employeeMenu.indicatorMenu.ShowIndicatorMenuOSCList.showIndicatorMenuOSCList;
import static menu.employeeMenu.indicatorMenu.ShowMonthlyIndicators.showMonthlyIndicator;
import static menu.employeeMenu.indicatorMenu.ShowRangeIndicators.showRangeIndicator;
import static supplier.IndicatorSupplier.*;

public class ShowIndicatorsMenu {

    private static Scanner sc;
    private static int response = 0;

    public static void showIndicatorMenu(Employee employee) {

        do {
            System.out.println("Selecciona la opción deseada");
            System.out.println("1. Indicadores históricos");
            System.out.println("2. Indicadores históricos por OSC");
            System.out.println("3. Indicadores actuales");
            System.out.println("4. Indicadores mensuales");
            System.out.println("5. Indicadores mensuales por OSC");
            System.out.println("6. Indicadores por rango de fechas");
            System.out.println("7. Indicadores por campaña");
            System.out.println("0. Volver al menu anterior");

            sc =  new Scanner(System.in);
            response = sc.nextInt();

            switch (response) {
                case 1:
                    ResponseEntity<Indicator> responseEntityHistoricalIndicator = getHistoricalIndicator(employee.getId());
                    if (responseEntityHistoricalIndicator.getStatusCode().value() == 200){
                        Indicator indicator = responseEntityHistoricalIndicator.getBody();
                        showIndicator(indicator, "Resgistro indicadores historicos");
                        response = returnMenu();
                    }
                    break;
                case 2:
                    IndicatorOSCRequest indicatorOSCRequest = showIndicatorMenuOSCList(employee.getId());
                    if (indicatorOSCRequest.getIdOSC() == null) response = returnMenu();
                    ResponseEntity<Indicator> responseEntity = getOSCIndicator(indicatorOSCRequest);
                    if(responseEntity.getStatusCode().value() == 200){
                        Indicator indicator = responseEntity.getBody();
                        showIndicator(indicator,"Resgistro indicadores historicos de "+indicatorOSCRequest.getOSCDescription());
                        response = returnMenu();
                    }
                    break;
                case 3:
                    ResponseEntity<Indicator> responseEntityActualIndicator = getActualIndicator(employee.getId());
                    if(responseEntityActualIndicator.getStatusCode().value() == 200) {
                        Indicator indicator = responseEntityActualIndicator.getBody();
                        showIndicator(indicator,"Resgistro de indicadores actuales");
                        response  = returnMenu();
                    }
                    break;
                case 4:
                    MonthlyRequest monthlyRequest = showMonthlyIndicator(employee.getId());
                    ResponseEntity<Indicator> responseEntityMonthlyIndicator = getMonthlyIndicator(monthlyRequest);
                    if(responseEntityMonthlyIndicator.getStatusCode().value() == 200) {
                        Indicator indicator = responseEntityMonthlyIndicator.getBody();
                        showIndicator(indicator, "Registro indicadores mensuales de "+employee);
                        response = returnMenu();
                    }
                    break;
                case 5:
                    MonthlyRequest monthlyOSCRequest = showMonthlyIndicator(employee.getId());
                    IndicatorOSCRequest indicatorMonthlyOSCRequest = showIndicatorMenuOSCList(employee.getId());
                    monthlyOSCRequest.setIdOSC(indicatorMonthlyOSCRequest.getIdOSC());
                    ResponseEntity<Indicator> responseEntityMonthlyOSCIndicator = getMonthlyOSCIndicator(monthlyOSCRequest);
                    if(responseEntityMonthlyOSCIndicator.getStatusCode().value() == 200) {
                        Indicator indicator = responseEntityMonthlyOSCIndicator.getBody();
                        showIndicator(indicator, "Registro indicadores mensuales");
                        response = returnMenu();
                    }
                    break;
                case 6:
                    RangeRequest rangeRequest = showRangeIndicator(employee.getId());
                    ResponseEntity<Indicator> responseEntityRangeIndicator = getRangeIndicator(rangeRequest);
                    if(responseEntityRangeIndicator.getStatusCode().value() == 200){
                        Indicator indicator = responseEntityRangeIndicator.getBody();
                        showIndicator(indicator,"Registro indicadores por rango");
                        response = returnMenu();
                    }
                    break;
                case 7:
                    Campaign campaign = showCampaignListMenu(employee);
                    IndicatorCampaignRequest indicatorCampaignRequest = new IndicatorCampaignRequest(employee.getId(),campaign.getId());
                    ResponseEntity<Indicator> indicatorResponseEntity = getCampaignIndicator(indicatorCampaignRequest);
                    if(indicatorResponseEntity.getStatusCode().value() == 200){
                        Indicator indicator = indicatorResponseEntity.getBody();
                        showIndicator(indicator,"Resgistro indicadores de la campaña"+campaign.getName());
                        response = returnMenu();
                    }
                    break;
                case 0:
                    System.out.println(" ");
                    break;
                default:
                    System.out.println("Debe ingresar una opcion correcta");
            }
        } while (response != 0);
    }
}
