package model.http.campaigns;

import model.dto.EmployeeCampaign;

import java.util.List;
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
public class CampaignStatusResponse {

    private List<EmployeeCampaign> employeeList;
    private String errorMessage;

}
