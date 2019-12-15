package supplier;

import model.Indicator;

public class IndicatorSupplier {

    public static Indicator getHistoricalIndicator(Integer idEmployee) {

        return new Indicator(2f,700f,1f,3f,1f);
    }

    public static Indicator getOSCIndicator(Integer idEmployee, Integer idOSC) {

        return new Indicator(1f,400f,1f,3f,1f);
    }
}
