import model.Campaign;
import model.Employee;
import org.json.JSONException;

import java.net.URISyntaxException;

import static menu.MainMenu.showMenu;
import static menu.employeeMenu.campaignMenu.campaignOptionMenu.CampaignMenu.showCampaignMenuOption;
import static menu.employeeMenu.login.teamLeader.TeamLeaderMenu.showTeamLeaderMenu;

public class Main  {

    public static void main(String[] args) throws JSONException, URISyntaxException {
       /* Employee employee = new Employee(2,"Daniela", "Sanz",1);
        //showMenu();
        showTeamLeaderMenu(employee);*/
        Campaign campaign = new Campaign(1,"RIO CUARTO",1,"AFULIC");
        showCampaignMenuOption(campaign);
    }
}
