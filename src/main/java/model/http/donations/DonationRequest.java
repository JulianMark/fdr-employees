package model.http.donations;

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
public class DonationRequest {

    private Float amount;
    private Integer payType;
    private Integer idEmployee;
    private Integer idCampaign;
    private String dni;
    private String name;
    private String lastName;
    private Integer age;
    private String gender;
}
