package org.stroganoff.entities;

import java.awt.Color;

public class VisualParameters {

    private final Transparency transparency;
    private final Color color;
    private final int facesNumber;

    public VisualParameters(Color color, Transparency transparency, int facesNumber) {
        this.color = color;
        this.transparency = transparency;
        this.facesNumber = facesNumber;
    }

    public Color getColor() {
        return color;
    }

    public Transparency getTransparency() {
        return transparency;
    }

    public int getFacesNumber() {
        return facesNumber;
    }

}
