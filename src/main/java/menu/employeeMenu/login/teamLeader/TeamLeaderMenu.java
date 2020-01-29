package menu.employeeMenu.login.teamLeader;

import model.Campaign;
import model.Employee;

import java.util.Scanner;

import static menu.ReturnMenu.returnMenu;
import static menu.employeeMenu.campaignMenu.campaignOptionMenu.CampaignMenu.showCampaignMenuOption;
import static menu.employeeMenu.login.facer.FacerMenu.showFacerMenu;
import static menu.employeeMenu.campaignMenu.CampaignListMenu.showCampaignListMenu;
public class TeamLeaderMenu {

    private static Scanner sc;
    private static boolean flag = true;
    private static int response = 0;

    public static void showTeamLeaderMenu (Employee employee) {
        final String employeeFullName = employee.getName()+" "+employee.getLastName() ;
        do{
            if (flag){
                System.out.println("Bienvenido "+ employeeFullName);
                System.out.println("Selecciona una opcion por su numero: ");
            }
            System.out.println("1. Mi Dashboard");
            System.out.println("2. Campañas");

            sc =  new Scanner(System.in);
            response = sc.nextInt();

            switch (response) {
                case 1:
                    flag = false;
                    showFacerMenu(employee);
                    response = returnMenu();
                    break;
                case 2:
                    flag = false;
                    Campaign campaign = showCampaignListMenu(employee.getId());
                    showCampaignMenuOption(campaign);
                    break;
                default:
                    System.out.println("Debe ingresar una opcion correcta");
            }
        }while (response != 0);

    }
}
