package supplier;

import model.Indicator;
import model.http.IndicatorOSCRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class IndicatorSupplier {

    public static ResponseEntity<Indicator> getHistoricalIndicator(Integer idEmployee) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<String, String>();
        params.put("idEmployee", String.valueOf(idEmployee));

        String url = "http://localhost:9091/employee/indicators/historical";
        HttpEntity entity = new HttpEntity(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Indicator> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Indicator.class);

        return responseEntity;
    }

    public static ResponseEntity<Indicator> getOSCIndicator(IndicatorOSCRequest request) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<String, String>();
        params.put("idEmployee", String.valueOf(request.getIdEmployee()));
        params.put("idOSC", String.valueOf(request.getIdOSC()));

        String url = "http://localhost:9091/employee/indicators/historical/osc";
        HttpEntity entity = new HttpEntity(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Indicator> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Indicator.class);

        return responseEntity;

    }
}
