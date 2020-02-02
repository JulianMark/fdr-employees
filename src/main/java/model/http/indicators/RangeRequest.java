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
public class RangeRequest {

    private Integer idEmployee;
    private String initialDate;
    private String finalDate;
}
