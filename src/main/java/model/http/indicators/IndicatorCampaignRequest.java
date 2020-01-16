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
public class IndicatorCampaignRequest {

    private Integer idEmployee;
    private Integer idCampaign;


}
