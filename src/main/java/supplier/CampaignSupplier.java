package supplier;

import model.dao.CampaignList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CampaignSupplier {

    public static ResponseEntity<CampaignList> getCampaigns (Integer idEmployee) {

        final String url = "http://localhost:9092/employee/indicators/campaign/" + idEmployee;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CampaignList> responseEntity = restTemplate.getForEntity(url, CampaignList.class);
        return responseEntity;
    }
}
