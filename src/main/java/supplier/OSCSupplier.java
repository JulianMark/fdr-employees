package supplier;

import model.OSC;

import java.util.ArrayList;
import java.util.List;

public class OSCSupplier {

    public static List<OSC> getOSCs (Integer idEmployee) {

        List<OSC> oscs = new ArrayList<OSC>();
        oscs.add(new OSC(1,"AFULIC"));
        oscs.add(new OSC(2,"SOLES"));
        return oscs;
    }
}
