package org.stroganoff.utils;

import org.stroganoff.entities.Gem;
import org.stroganoff.entities.Preciousness;
import org.stroganoff.entities.VisualParameters;

public class GemBuilder implements IGemBuilder {
    @Override

    public Gem buildGem() {
        Gem gemInstance = null;
        String name = "";
        Preciousness preciousness = null;
        String miningLocation = null;
        VisualParameters visualParameters = null;
        double stoneWeight = 0;
        gemInstance = new Gem(name, preciousness, miningLocation, visualParameters, stoneWeight);
        return gemInstance;
    }
}
