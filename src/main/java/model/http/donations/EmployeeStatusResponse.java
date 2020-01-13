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
public class EmployeeStatusResponse {

    private Integer idCampaign;
    private String nameCampaign;
    private Integer idOSC;
    private String descriptionOSC;
    private String errorMessage;
}
