package menu.employeeMenu.donationMenu;

import model.dto.DonationDTO;
import model.http.donations.DonationRequest;
import model.http.donations.EmployeeStatusResponse;
import org.springframework.http.ResponseEntity;

import java.util.Scanner;

import static supplier.StatusEmployeeSupplier.getStatusEmployee;

public class showStatusEmployee {

    private static Scanner sc = new Scanner(System.in);

    public static DonationDTO showStatusEmployee(Integer idEmployee) {
        ResponseEntity<EmployeeStatusResponse> responseResponseEntity = getStatusEmployee(idEmployee);

        StringBuilder message = new StringBuilder();
        message.append("Realizar una donación para: ");
        message.append(responseResponseEntity.getBody().getNameCampaign()).append(" ");
        message.append(responseResponseEntity.getBody().getDescriptionOSC()).append(" ");
        message.append("Y / N");

        if (responseResponseEntity.getStatusCode().value() == 200) {
            System.out.println(message);
            String response = sc.nextLine();
            return new DonationDTO(idEmployee, responseResponseEntity.getBody().getIdCampaign(), response);

        }
        if (responseResponseEntity.getStatusCode().value() == 204){
            return new DonationDTO(0, 0,"No estas asignado a ninguna campaña.");
        }
        return new DonationDTO();
    }
}
