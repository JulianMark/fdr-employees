package menu.employeeMenu.campaignMenu;

import model.Campaign;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampaignListMenu {

    public static Campaign showCampaignListMenu(Integer idEmployee) {//Deberia recibir el id de empleado idEmployee

        Scanner sc = new Scanner(System.in);
        Integer result;
        List<Campaign> campaignList = new ArrayList<>();
        campaignList.add(new Campaign(12,"CORDOBA",2,"AFULIC"));
        campaignList.add(new Campaign(23,"RIO CUARTO",1,"SOLES"));
        
        int index = 1;

        System.out.println("Seleccione la campaña deseada por su número");
        for (Campaign campaign: campaignList) {
            System.out.println(index + " - "+ campaign.getName() +" "+campaign.getDescription() );
            index++;
        }
        result = sc.nextInt();

      return new Campaign(campaignList.get(result -1).getId(),
              campaignList.get(result - 1).getName(),
              campaignList.get(result - 1).getCampaignType(),
              campaignList.get(result - 1).getDescription());
    }

}
