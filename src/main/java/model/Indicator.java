package model;
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
public class Indicator {

    private Float totalDonations;
    private Float totalAmountDonations;
    private Float creditType;
    private Float totalProductiveHours;
    private Float totalNonProductiveHours;
    private Float totalAverageCatchment;
    private Float totalAverageAmount;
    private Float totalAverageCreditType;
    private String errorMessage;
}
