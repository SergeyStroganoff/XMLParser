package org.stroganoff.entities;

import java.awt.Color;

public class VisualParameters {

    private final String transparency;
    private Color color;
    private int facesNumber;

    public VisualParameters(Color color, String transparency, int facesNumber) {
        this.color = color;
        this.transparency = transparency;
        this.facesNumber = facesNumber;
    }

    public Color getColor() {
        return color;
    }

    public String getTransparency() {
        return transparency;
    }

    public int getFacesNumber() {
        return facesNumber;
    }

}
