package menu.employeeMenu.login.teamLeader;

import model.Employee;

import java.util.Scanner;

import static menu.ReturnMenu.returnMenu;
import static menu.employeeMenu.login.facer.FacerMenu.showFacerMenu;
import static menu.employeeMenu.campaignMenu.CampaignMenu.showCampaignMenu;

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
            System.out.println("3. Dashboard de tu equipo");

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
                    //Traer las campañas de este mes
                    showCampaignMenu();
                    //necesario seleccionar la campaña
                    response = returnMenu();
                    break;
                case 3:
                    flag = false;
                    response = returnMenu();
                    break;
                default:
                    System.out.println("Debe ingresar una opcion correcta");
            }
        }while (response != 0);


    }
}
