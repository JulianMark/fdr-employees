package supplier;

import model.dao.OSCs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OSCSupplier {

    public static ResponseEntity<OSCs> getOSCs (Integer idEmployee){

        final String url = "http://localhost:9090/employee/indicators/" + idEmployee;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OSCs> responseEntity = restTemplate.getForEntity(url, OSCs.class);
        return responseEntity;
    }
}
