package menu.employeeMenu.login.facer;

import menu.employeeMenu.indicatorMenu.ShowIndicatorsMenu;
import model.Employee;
import model.dto.DonationDTO;
import model.http.donations.DonationRequest;
import model.http.donations.DonationResponse;
import org.springframework.http.ResponseEntity;

import java.util.Scanner;

import static menu.ReturnMenu.returnMenu;
import static menu.employeeMenu.donationMenu.showDonationMenu.showDonationMenu;
import static menu.employeeMenu.donationMenu.showStatusEmployee.showStatusEmployee;
import static menu.employeeMenu.login.teamLeader.TeamLeaderMenu.showTeamLeaderMenu;
import static supplier.DonationSupplier.addDonation;

public class FacerMenu {

    private static Scanner sc;
    private static boolean flag = true;
    private static int response = 0;

    public static void showFacerMenu (Employee employee) {
        final String employeeFullName = employee.getName()+" "+employee.getLastName() ;
        do{
            if (flag){
                System.out.println("Bienvenido a tu Dashboard "+ employeeFullName);
                System.out.println("Selecciona una opcion por su numero: ");
            }
            System.out.println("1. Indicadores");
            System.out.println("2. Realizar donacion");
            System.out.println("0. Salir");

            sc =  new Scanner(System.in);
            response = sc.nextInt();

            switch (response) {
                case 1:
                    flag = false;
                    ShowIndicatorsMenu.showIndicatorMenu(employee);
                    break;
                case 2:
                    flag = false;
                    DonationDTO donationDTO = showStatusEmployee(employee.getId());
                    if (donationDTO.getIdEmployee() != 0
                            && (donationDTO.getResponse().equals("Y")
                                || donationDTO.getResponse().equals("y"))){
                        DonationRequest donationRequest = showDonationMenu(donationDTO);
                        ResponseEntity<DonationResponse> responseEntity = addDonation(donationRequest);
                        if (responseEntity.getStatusCode().value() == 200){
                            if (responseEntity.getBody().getResult() == 0) System.out.println("Donación ingresada correctamente");
                            response = returnMenu();
                        }
                    }else response = returnMenu();
                    break;
                case 0:
                    if(employee.getIdType() == 2) {
                       showTeamLeaderMenu(employee);
                    } else System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Debe ingresar una opcion correcta");
            }
        }while (response != 0);
    }
}
