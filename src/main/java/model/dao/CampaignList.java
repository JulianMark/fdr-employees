package model.dao;

import model.Campaign;

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
public class CampaignList {

    private List<Campaign> campaignList;
    private String errorMessage;
}
