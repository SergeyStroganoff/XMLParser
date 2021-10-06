package org.stroganoff.entities;

public class VisualParameters {

    private final Transparency transparency;
    private final org.stroganoff.entities.Color color;
    private final int facesNumber;

    public VisualParameters(org.stroganoff.entities.Color color, Transparency transparency, int facesNumber) {
        this.color = color;
        this.transparency = transparency;
        this.facesNumber = facesNumber;
    }

    public org.stroganoff.entities.Color getColor() {
        return color;
    }

    public Transparency getTransparency() {
        return transparency;
    }

    public int getFacesNumber() {
        return facesNumber;
    }

    @Override
    public String toString() {
        return "VisualParameters{" +
                "transparency=" + transparency +
                ", color=" + color +
                ", facesNumber=" + facesNumber +
                '}';
    }
}
