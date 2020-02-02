package menu.employeeMenu.campaignMenu.campaignOptionMenu;

import model.Campaign;
import model.dto.EmployeeCampaign;
import model.http.campaigns.CampaignStatusResponse;
import org.springframework.http.ResponseEntity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Scanner;

import static menu.ReturnMenu.returnMenu;
import static supplier.CampaignSupplier.getCampaignStatus;

public class CampaignMenu  {

    public static void showCampaignMenuOption (Campaign campaign){
        Scanner sc = new Scanner(System.in);
        System.out.println(campaign.getName()
                +" "+descriptionTypeCampaign(campaign.getCampaignType())
                +" "+campaign.getDescription());

        ResponseEntity<CampaignStatusResponse> responseEntity = getCampaignStatus(campaign.getId());
        if(responseEntity.getStatusCode().value() == 200) {
            getEmployeesCampaignList(responseEntity.getBody().getEmployeeList());
        } else System.out.println("error");
    }

    private static String descriptionTypeCampaign (Integer campaignType){
        if (campaignType == 1) return "ITINERANCIA";
        if (campaignType == 2) return "VIA PUBLICA";
        if (campaignType == 3) return "EVENTOS";
        return "";
    }

    private static void getEmployeesCampaignList (List<EmployeeCampaign> list) {
        String tabulation = "%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-30s%-20s\n";
        System.out.printf(tabulation,"Nombre","Apellido","Q don","Q monto","PC","MP","%TC","Hs","HsNon","inicio","final");

        Integer sumTotalDonations = 0;
        Float sumTotalAmountDonations = 0f;
        Float sumTotalProductiveHours = 0f;
        Float sumTotalNonProductiveHours = 0f;
        Float totalAverageCreditType = 0f;
        for(EmployeeCampaign employee : list) {
            System.out.printf(tabulation,employee.getName(),employee.getLastName(),employee.getTotalDonations()
                                ,roundToFloat(employee.getTotalAmountDonations())
                                ,roundToFloat(employee.getTotalAverageCatchment())
                                ,roundToFloat(employee.getTotalAverageAmount())
                                ,roundToFloat(employee.getTotalAverageCreditType())
                                ,employee.getTotalProductiveHours(), employee.getTotalNonProductiveHours()
                                ,employee.getInitialDate(),employee.getFinalDate());


            sumTotalDonations += employee.getTotalDonations();
            sumTotalAmountDonations += employee.getTotalAmountDonations();
            sumTotalProductiveHours += employee.getTotalProductiveHours();
            sumTotalNonProductiveHours += employee.getTotalNonProductiveHours();
            totalAverageCreditType += (employee.getTotalAverageCreditType()/100) * employee.getTotalDonations();

        }

        Float totalAverageCatchment = sumTotalDonations / sumTotalProductiveHours;
        Float totalAverageAmount = sumTotalAmountDonations / sumTotalDonations;
        Float TC = (totalAverageCreditType / sumTotalDonations) * 100 ;
        System.out.println(" ");
        System.out.printf(tabulation,"","TOTALES",sumTotalDonations,sumTotalAmountDonations
                ,roundToFloat(totalAverageCatchment),roundToFloat(totalAverageAmount),roundToFloat(TC)
                ,roundToFloat(sumTotalProductiveHours),roundToFloat(sumTotalNonProductiveHours),"-","-");
    }

    private static Float roundToFloat (Float number) {
        DecimalFormatSymbols colonFormat = new DecimalFormatSymbols();
        colonFormat.setDecimalSeparator('.');
        DecimalFormat f = new DecimalFormat("#.00", colonFormat);
        return Float.valueOf(f.format(number));
    }
}
