package supplier;

import model.OSCs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class OSCSupplier {

    public static ResponseEntity<OSCs> getOSCs (Integer idEmployee) {

        final String URL = "http://localhost:9090/employee/indicators/" + idEmployee;
            URI uri = null;
        try {
            uri = new URI(URL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        RestTemplate oscRestTemplate = new RestTemplate();
        ResponseEntity<OSCs> oscResponseEntity = oscRestTemplate.getForEntity(uri, OSCs.class);
        System.out.println(oscResponseEntity.getBody().getOscList());
        System.out.println(oscResponseEntity.getStatusCode());
        return oscResponseEntity;
    }
}
