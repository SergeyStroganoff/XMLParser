package org.stroganoff.utils;

import org.stroganoff.entities.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GemBuilder implements IEntityBuilder {
    @Override

    public Gem buildGem(Element element) {
        Gem gemInstance;
        VisualParameters visualParameters;
        String name = getElementTextContent(element, "name");
        Preciousness preciousness = Preciousness.valueOf(getElementTextContent(element, "preciousness"));
        String miningLocation = getElementTextContent(element, "miningLocation");
        Element visualParametersElements = (Element) element.getElementsByTagName("visualParameters").item(0);
        visualParameters = buildVisualParametersInstance(visualParametersElements);
        double stoneWeight = Double.parseDouble(getElementTextContent(element, "stoneWeight"));
        gemInstance = new Gem(name, preciousness, miningLocation, visualParameters, stoneWeight);
        return gemInstance;
    }

    public VisualParameters buildVisualParametersInstance(Element element) {
        Transparency transparency = Transparency.valueOf(getElementTextContent(element, "transparency"));
        Color color = Color.valueOf(getElementTextContent(element, "color"));
        int facesNumber = Integer.parseInt(getElementTextContent(element, "facesNumber"));
        return new VisualParameters(color, transparency, facesNumber);
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
