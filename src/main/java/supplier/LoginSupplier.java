package supplier;

import model.Employee;
import model.http.LoginRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class LoginSupplier {

    public static ResponseEntity<Employee> loginUser (LoginRequest loginRequest){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<String, String>();
        params.put("nickname", loginRequest.getNickname());
        params.put("password", loginRequest.getPassword());

        String url = "http://localhost:9090/employee/login";
        HttpEntity entity = new HttpEntity(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Employee.class);

        return responseEntity;
    }
}
