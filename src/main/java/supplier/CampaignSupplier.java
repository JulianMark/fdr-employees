package supplier;

import model.dao.CampaignList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class CampaignSupplier {

    public static ResponseEntity<CampaignList> getCampaigns (Integer idEmployee) {

        final String url = "http://localhost:9092/employee/indicators/campaign/" + idEmployee;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CampaignList> responseEntity = restTemplate.getForEntity(url, CampaignList.class);
        return responseEntity;
    }

    /*public static ResponseEntity<CampaignResponse> getEmployeeCampaign (Integer idCampaign) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(campaignRequest.getId()));
        params.put("name", String.valueOf(campaignRequest.getName()));
        params.put("lastName", String.valueOf(campaignRequest.getLastName()));
        params.put("totalDonations", String.valueOf(campaignRequest.getTotalDonations()));
        params.put("totalAmountDonations", String.valueOf(campaignRequest.getTotalAmountDonations()));
        params.put("totalProductiveHours", String.valueOf(campaignRequest.getTotalProductiveHours()));
        params.put("totalNonProductiveHours", String.valueOf(campaignRequest.getTotalNonProductiveHours()));
        params.put("initialDate", String.valueOf(campaignRequest.getInitialDate()));
        params.put("finalDate", String.valueOf(campaignRequest.getFinalDate()));


        String url = "http://localhost:9094/employee/manager/obtainEmployeeAssignmentCampaign";
        HttpEntity entity = new HttpEntity(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CampaignResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, CampaignResponse.class);

        return responseEntity;
    }*/
}
