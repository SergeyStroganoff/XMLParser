package org.stroganoff.entities;

import java.util.ArrayList;

public class VisualParameters {

    private final String transparency;
    private ArrayList<String> colors = new ArrayList<>();
    private int facesNumber;

    public VisualParameters(ArrayList<String> colors, String transparency, int facesNumber) {
        this.colors = colors;
        this.transparency = transparency;
        this.facesNumber = facesNumber;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public String getTransparency() {
        return transparency;
    }

    public int getFacesNumber() {
        return facesNumber;
    }

    public void addColor(String color) {
        colors.add(color);
    }
}
