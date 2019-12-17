package menu.employeeMenu.indicatorMenu;

import model.Indicator;

public class ShowIndicator {

    public static void showIndicator(Indicator indicator, String title) {

        System.out.println(title);
        System.out.println("Total donaciones: " + indicator.getTotalDonations());
        System.out.println("Total horas productivas: " + indicator.getTotalProductiveHours());
        System.out.println("Total horas sin captacion: " + indicator.getTotalNonProductiveHours());
        System.out.println("Total recaudado: " + indicator.getTotalAmountDonations());
        System.out.println("Total porcentaje TC: %" + indicator.getTotalAverageCreditType());
        System.out.println("Monto promedio: " + indicator.getTotalAverageAmount());
        System.out.println("Promedio de captacion: " + indicator.getTotalAverageCatchment());
    }
}
