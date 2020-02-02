package menu.employeeMenu.controller;

import model.dto.DonationDTO;
import model.http.donations.DonationRequest;
import model.http.donations.DonationResponse;
import org.springframework.http.ResponseEntity;

import static menu.employeeMenu.donationMenu.showDonationMenu.showDonationMenu;
import static supplier.DonationSupplier.addDonation;

public class DonationController {

    public static ResponseEntity<DonationResponse> obtainDonationResponse(DonationDTO donationDTO) {
        if (donationDTO.getIdEmployee() != 0
                && (donationDTO.getResponse().equals("Y")
                || donationDTO.getResponse().equals("y"))) {
            DonationRequest donationRequest = showDonationMenu(donationDTO);
            ResponseEntity<DonationResponse> responseEntity = addDonation(donationRequest);
            return responseEntity;
        }
        return null;
    }
}
