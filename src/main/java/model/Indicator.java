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


    public float obtainTotalAverageCatchment(){
        return totalDonations / totalProductiveHours;
    }

    public float obtainTotalAverageAmount(){
        return totalAmountDonations / totalDonations;
    }

    public float obtainTotalAverageCreditType(){
        return (creditType / totalDonations) * 100 ;
    }

}
