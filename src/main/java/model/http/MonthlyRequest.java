package model.http;

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
public class MonthlyRequest {

    private Integer idEmployee;
    private Integer monthNumber;
    private Integer yearNumber;
    private Integer idOSC;

    public MonthlyRequest(Integer idEmployee, Integer monthNumber, Integer yearNumber) {
        this.idEmployee = idEmployee;
        this.monthNumber = monthNumber;
        this.yearNumber = yearNumber;
    }

}
