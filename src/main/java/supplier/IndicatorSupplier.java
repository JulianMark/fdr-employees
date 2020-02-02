package supplier;

import model.Indicator;
import model.http.indicators.IndicatorCampaignRequest;
import model.http.indicators.IndicatorOSCRequest;
import model.http.indicators.MonthlyRequest;
import model.http.indicators.RangeRequest;
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

    public static ResponseEntity<Indicator> getActualIndicator(Integer idEmployee) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<String, String>();
        params.put("idEmployee", String.valueOf(idEmployee));

        String url = "http://localhost:9091/employee/indicators/actually";
        HttpEntity entity = new HttpEntity(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Indicator> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Indicator.class);

        return responseEntity;
    }

    public static ResponseEntity<Indicator> getMonthlyIndicator(MonthlyRequest monthlyRequest) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<String, String>();
        params.put("idEmployee", String.valueOf(monthlyRequest.getIdEmployee()));
        params.put("monthNumber", String.valueOf(monthlyRequest.getMonthNumber()));
        params.put("yearNumber", String.valueOf(monthlyRequest.getYearNumber()));
        params.put("idOSC", String.valueOf(monthlyRequest.getIdOSC()));

        String url = "http://localhost:9091/employee/indicators/monthly";
        HttpEntity entity = new HttpEntity(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Indicator> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Indicator.class);

        return responseEntity;
    }

    public static ResponseEntity<Indicator> getMonthlyOSCIndicator(MonthlyRequest monthlyRequest) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<String, String>();
        params.put("idEmployee", String.valueOf(monthlyRequest.getIdEmployee()));
        params.put("monthNumber", String.valueOf(monthlyRequest.getMonthNumber()));
        params.put("yearNumber", String.valueOf(monthlyRequest.getYearNumber()));
        params.put("idOSC", String.valueOf(monthlyRequest.getIdOSC()));

        String url = "http://localhost:9091/employee/indicators/monthly/osc";
        HttpEntity entity = new HttpEntity(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Indicator> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Indicator.class);

        return responseEntity;
    }

    public static ResponseEntity<Indicator> getRangeIndicator(RangeRequest rangeRequest) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<String, String>();
        params.put("idEmployee", String.valueOf(rangeRequest.getIdEmployee()));
        params.put("initialDate",rangeRequest.getInitialDate());
        params.put("finalDate", rangeRequest.getFinalDate());

        String url = "http://localhost:9091/employee/indicators/range";
        HttpEntity entity = new HttpEntity(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Indicator> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Indicator.class);

        return responseEntity;
    }

    public static ResponseEntity<Indicator> getCampaignIndicator(IndicatorCampaignRequest campaignRequest) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<String, String>();
        params.put("idEmployee", String.valueOf(campaignRequest.getIdEmployee()));
        params.put("idCampaign",String.valueOf(campaignRequest.getIdCampaign()));

        String url = "http://localhost:9091/employee/indicators/campaign";
        HttpEntity entity = new HttpEntity(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Indicator> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Indicator.class);

        return responseEntity;
    }
}
