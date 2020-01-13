
package menu.employeeMenu.donationMenu;

import model.dto.DonationDTO;
import model.http.donations.DonationRequest;

import java.util.Scanner;

public class showDonationMenu {

    private static Scanner sc = new Scanner(System.in);

    public static DonationRequest showDonationMenu (DonationDTO donationDTO){
        System.out.println("Ingrese nombre del donante: ");
        String name = sc.nextLine();
        System.out.println("Ingrese apellido del donante: ");
        String lastName = sc.nextLine();
        System.out.println("Ingrese dni del donante: ");
        String dni = sc.nextLine();
        System.out.println("Ingrese genero del donante (F: femenino , M: masculino , I : indistinto): ");
        String gender = sc.nextLine();
        System.out.println("Ingrese la edad del donante");
        Integer age = sc.nextInt();
        System.out.println("Ingrese el tipo de pago de la donación (1. crédito 2. débito)");
        Integer payType = sc.nextInt();
        System.out.println("Ingrese el monto de la donación (Ej 300.00)");
        Float amount = sc.nextFloat();
        return new DonationRequest(amount,payType, donationDTO.getIdEmployee(),
                donationDTO.getIdCampaign(), dni, name, lastName, age, gender);
    }
}
