package menu.employeeMenu.campaignMenu;

import model.Campaign;
import model.Employee;
import model.dao.CampaignList;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Scanner;

import static menu.employeeMenu.login.teamLeader.TeamLeaderMenu.showTeamLeaderMenu;
import static supplier.CampaignSupplier.getCampaigns;

public class CampaignListMenu {

    private static Scanner sc;
    private static int response = 0;

    public static Campaign showCampaignListMenu(Employee employee) {
        ResponseEntity<CampaignList> responseEntityOSCs = getCampaigns (employee.getId());
        List<Campaign> campaignList = responseEntityOSCs.getBody().getCampaignList();

        int index = 1;
        for (Campaign campaign : campaignList) {
            System.out.println(index +". "+ campaign.getName()+" "+campaign.getDescription());
            index++;
        }
        System.out.println(" ");
        System.out.println("0. Volver al menu anterior");

        sc =  new Scanner(System.in);
        response = sc.nextInt();

        if( response != 0) {
            Campaign campaign = new Campaign(
                    campaignList.get(response -1).getId(),
                    campaignList.get(response -1).getName(),
                    campaignList.get(response -1).getCampaignType(),
                    campaignList.get(response -1).getDescription());
            return new Campaign(campaign.getId(),campaign.getName(),campaign.getCampaignType(),campaign.getDescription());
        } else showTeamLeaderMenu(employee);

        return new Campaign();
    }

}
