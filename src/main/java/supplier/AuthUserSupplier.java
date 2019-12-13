package supplier;

import model.Employee;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AuthUserSupplier {

    public static ResponseEntity<Employee> authUser(String [] data) throws JSONException {

        JSONObject request = new JSONObject();
        request.put("nickname", data[0]);
        request.put("password", data[1]);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

        final String URL = "http://localhost:9090/employee/login";
        RestTemplate rest = new RestTemplate();
        final ResponseEntity<Employee> employeeResponseEntity = rest.postForEntity(URL, entity, Employee.class);
        System.out.println(employeeResponseEntity.getStatusCode());
        return employeeResponseEntity;
    }
}
