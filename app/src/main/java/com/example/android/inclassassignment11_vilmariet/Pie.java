package com.example.android.inclassassignment11_vilmariet;


public class Pie {
    private String pieType;
    private int numberOfFruits;
    private boolean latticeArtwork;

    public Pie() {

    }

    public String getPieType() {
        return pieType;
    }

    public void setPieType(String pieType) {
        this.pieType = pieType;
    }

    public int getNumberOfFruits() {
        return numberOfFruits;
    }

    public void setNumberOfFruits(int numberOfFruits) {
        this.numberOfFruits = numberOfFruits;
    }

    public boolean isLatticeArtwork() {
        return latticeArtwork;
    }

    public void setLatticeArtwork(boolean latticeArtwork) {
        this.latticeArtwork = latticeArtwork;
    }

    public Pie(String pieType, int numberOfFruits, boolean latticeArtwork) {
        this.pieType = pieType;
        this.numberOfFruits = numberOfFruits;
        this.latticeArtwork = latticeArtwork;
    }
}



