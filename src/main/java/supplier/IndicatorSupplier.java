package supplier;

import model.Indicator;

public class IndicatorSupplier {

    public static Indicator getIndicator (Integer idEmployee) {

        return new Indicator(2f,700f,1f,3f,1f);
    }
}
