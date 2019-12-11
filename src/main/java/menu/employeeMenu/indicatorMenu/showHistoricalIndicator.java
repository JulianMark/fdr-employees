package menu.employeeMenu.indicatorMenu;

import model.Indicator;

public class showHistoricalIndicator {

    public static void showHistoricalInd (Indicator indicator) {

        System.out.println("Indicadores historicos");
        System.out.println("Total donaciones: " + indicator.getTotalDonations());
        System.out.println("Promedio de captacion: " + indicator.obtainTotalAverageCatchment());
        System.out.println("Monto promedio: " + indicator.obtainTotalAverageAmount());
        System.out.println("Total porcentaje TC: %" + indicator.obtainTotalAverageCreditType());
        System.out.println("Total horas productivas: " + indicator.getTotalProductiveHours());
        System.out.println("Total horas sin captacion: " + indicator.getTotalNonProductiveHours());
        System.out.println("Total recaudado: " + indicator.getTotalAmountDonations());


    }
}
