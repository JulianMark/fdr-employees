package supplier;

import model.http.donations.EmployeeStatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class StatusEmployeeSupplier {

    public static ResponseEntity<EmployeeStatusResponse> getStatusEmployee(Integer idEmployee) {

        final String url = "http://localhost:9093/employee/status/" + idEmployee;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EmployeeStatusResponse> responseEntity = restTemplate.getForEntity(url
                , EmployeeStatusResponse.class);
        return responseEntity;
    }
}
