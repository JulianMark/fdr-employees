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
public class EmployeeCampaign {

    private Integer id;
    private String name;
    private String lastName;
    private Float totalDonations;
    private Float totalAmountDonations;
    private Float totalProductiveHours;
    private Float totalNonProductiveHours;
    private Float totalAverageCatchment;
    private Float totalAverageAmount;
    private String initialDate;
    private String finalDate;
}
