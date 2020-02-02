package supplier;

import model.dao.CampaignList;
import model.http.campaigns.CampaignStatusResponse;
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

    public static ResponseEntity<CampaignStatusResponse> getCampaignStatus (Integer idCampaign) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<>();
        params.put("idCampaign", String.valueOf(idCampaign));

        String url = "http://localhost:9094/employee/manager/obtainStatusCampaign";
        HttpEntity entity = new HttpEntity(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CampaignStatusResponse> responseEntity = restTemplate
                .exchange(url, HttpMethod.POST, entity, CampaignStatusResponse.class);

        return responseEntity;
    }
}
