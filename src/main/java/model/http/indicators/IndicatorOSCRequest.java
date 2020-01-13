package model.http.indicators;

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
public class IndicatorOSCRequest {

    private Integer idEmployee;
    private Integer idOSC;
    private String OSCDescription;

    public IndicatorOSCRequest(Integer idEmployee, Integer idOSC) {
        this.idEmployee = idEmployee;
        this.idOSC = idOSC;
    }
}
