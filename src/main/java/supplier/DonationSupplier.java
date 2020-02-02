package supplier;

import model.http.donations.DonationRequest;
import model.http.donations.DonationResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class DonationSupplier {

    public static ResponseEntity<DonationResponse> addDonation (DonationRequest donationRequest) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<String, String>();
        params.put("amount", String.valueOf(donationRequest.getAmount()));
        params.put("payType", String.valueOf(donationRequest.getPayType()));
        params.put("idEmployee", String.valueOf(donationRequest.getIdEmployee()));
        params.put("idCampaign", String.valueOf(donationRequest.getIdCampaign()));
        params.put("dni", String.valueOf(donationRequest.getDni()));
        params.put("name", String.valueOf(donationRequest.getName()));
        params.put("lastName", String.valueOf(donationRequest.getLastName()));
        params.put("age", String.valueOf(donationRequest.getAge()));
        params.put("gender", String.valueOf(donationRequest.getGender()));

        String url = "http://localhost:9093/employee/donation/add";
        HttpEntity entity = new HttpEntity(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DonationResponse> responseEntity = restTemplate
                .exchange(url, HttpMethod.POST, entity, DonationResponse.class);

        return responseEntity;
    }
}
