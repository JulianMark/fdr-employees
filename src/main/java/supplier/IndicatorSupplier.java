package supplier;

import model.Indicator;
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

        String url = "http://localhost:9090/employee/indicators/historical";
        HttpEntity entity = new HttpEntity(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Indicator> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Indicator.class);

        return responseEntity;
    }

    public static Indicator getOSCIndicator(Integer idEmployee, Integer idOSC) {

        return new Indicator(2f,700f,1f,3f,1f,12f,5f,6f,null);

    }
}
