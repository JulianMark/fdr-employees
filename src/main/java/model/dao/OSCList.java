package model.dao;

import java.util.List;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.OSC;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OSCList {

    private List <OSC> oscList;
    private String errorMessage;
}
