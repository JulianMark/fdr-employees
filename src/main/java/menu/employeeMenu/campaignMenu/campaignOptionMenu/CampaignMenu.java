package menu.employeeMenu.campaignMenu.campaignOptionMenu;

import model.Campaign;

import java.util.Scanner;

import static menu.ReturnMenu.returnMenu;
import static menu.employeeMenu.campaignMenu.campaignOptionMenu.DashBoard.ShowDashboardMenu.showDashBoardMenuEmployeeList;

public class CampaignMenu  {

    public static void showCampaignMenuOption (Campaign campaign){

        Integer result;
        Scanner sc = new Scanner(System.in);
        System.out.println(campaign.getName()
                +" "+descriptionTypeCampaign(campaign.getCampaignType())
                +" "+campaign.getDescription());
        System.out.println("1.- Indicadores");
        System.out.println("2.- Dashboard");

        result = sc.nextInt();

        if (result == 1) {
            System.out.println("indicadores de campaña");
            result = returnMenu();
        }
        if (result == 2){
            Integer idEmployee = showDashBoardMenuEmployeeList(campaign.getId());
            //ShowIndicador del empleado elegido
            System.out.println("indicadores de los facer");
            result = returnMenu();
        }

    }

    private static String descriptionTypeCampaign (Integer campaignType){
        if (campaignType == 1) return "ITINERANCIA";
        if (campaignType == 2) return "VIA PUBLICA";
        if (campaignType == 3) return "EVENTOS";
        return "";
    }
}
