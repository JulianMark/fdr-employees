package menu.employeeMenu.campaignMenu.campaignOptionMenu;

import model.Campaign;

import java.util.Scanner;

import static menu.employeeMenu.campaignMenu.campaignOptionMenu.DashBoard.ShowDashBoardMenu.showDashBoardMenuEmployeeList;

public class CampaignMenu  {

    public static void showCampaignMenuOption (Campaign campaign){

        Integer result;
        Scanner sc = new Scanner(System.in);
        System.out.println(campaign.getName()
                +" "+campaign.getDescription()
                +" "+descriptionTypeCampaign(campaign.getCampaignType()));
        System.out.println("1.- Indicadores");
        System.out.println("2.- DashBoard");

        result = sc.nextInt();

        if (result == 1) {
            //ShowIndicador de campania seleccionada
        }
        if (result == 2){
            Integer idEmployee = showDashBoardMenuEmployeeList(campaign.getId());
            //ShowIndicador del empleado elegido
        }

    }

    private static String descriptionTypeCampaign (Integer campaignType){
        if (campaignType == 1) return "ITINERANCIA";
        if (campaignType == 2) return "VIA PUBLICA";
        if (campaignType == 3) return "EVENTOS";
        return "";
    }
}
