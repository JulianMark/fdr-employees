package model.dto;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DonationDTO {

    private Integer idEmployee;
    private Integer idCampaign;
    private String response;

    public DonationDTO(String response) {
        this.response = response;
    }
}
