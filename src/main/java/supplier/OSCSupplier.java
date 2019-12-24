package supplier;

import model.dao.OSCList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OSCSupplier {

    public static ResponseEntity<OSCList> getOSCs (Integer idEmployee){

        final String url = "http://localhost:9092/employee/indicators/osc/" + idEmployee;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OSCList> responseEntity = restTemplate.getForEntity(url, OSCList.class);
        return responseEntity;
    }
}
