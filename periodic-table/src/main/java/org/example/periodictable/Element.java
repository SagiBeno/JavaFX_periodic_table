package org.example.periodictable;

public class Element {
    int atomicNumber;
    String symbol;
    String name;
    String atomicMass;
    String cpkHexColor;
    String electronicConfiguration;
    String electronegativity;
    String atomicRadius;
    String ionRadius;
    String vanDelWaalsRadius;
    String ionizationEnergy;
    String electronAffinity;
    String oxidationStates;
    String standardState;
    String bondingType;
    String meltingPoint;
    String boilingPoint;
    String density;
    String groupBlock;
    String yearDiscovered;

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getAtomicMass() {
        return atomicMass;
    }

    public String getCpkHexColor() {
        return cpkHexColor;
    }

    public String getElectronicConfiguration() {
        return electronicConfiguration;
    }

    public String getElectronegativity() {
        return electronegativity;
    }

    public String getAtomicRadius() {
        return atomicRadius;
    }

    public String getIonRadius() {
        return ionRadius;
    }

    public String getVanDelWaalsRadius() {
        return vanDelWaalsRadius;
    }

    public String getIonizationEnergy() {
        return ionizationEnergy;
    }

    public String getElectronAffinity() {
        return electronAffinity;
    }

    public String getOxidationStates() {
        return oxidationStates;
    }

    public String getStandardState() {
        return standardState;
    }

    public String getBondingType() {
        return bondingType;
    }

    public String getMeltingPoint() {
        return meltingPoint;
    }

    public String getBoilingPoint() {
        return boilingPoint;
    }

    public String getDensity() {
        return density;
    }

    public String getGroupBlock() {
        return groupBlock;
    }

    public String getYearDiscovered() {
        return yearDiscovered;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAtomicMass(String atomicMass) {
        this.atomicMass = atomicMass;
    }

    public void setCpkHexColor(String cpkHexColor) {
        this.cpkHexColor = cpkHexColor;
    }

    public void setElectronicConfiguration(String electronicConfiguration) {
        this.electronicConfiguration = electronicConfiguration;
    }

    public void setElectronegativity(String electronegativity) {
        this.electronegativity = electronegativity;
    }

    public void setAtomicRadius(String atomicRadius) {
        this.atomicRadius = atomicRadius;
    }

    public void setIonRadius(String ionRadius) {
        this.ionRadius = ionRadius;
    }

    public void setVanDelWaalsRadius(String vanDelWaalsRadius) {
        this.vanDelWaalsRadius = vanDelWaalsRadius;
    }

    public void setIonizationEnergy(String ionizationEnergy) {
        this.ionizationEnergy = ionizationEnergy;
    }

    public void setElectronAffinity(String electronAffinity) {
        this.electronAffinity = electronAffinity;
    }

    public void setOxidationStates(String oxidationStates) {
        this.oxidationStates = oxidationStates;
    }

    public void setStandardState(String standardState) {
        this.standardState = standardState;
    }

    public void setBondingType(String bondingType) {
        this.bondingType = bondingType;
    }

    public void setMeltingPoint(String meltingPoint) {
        this.meltingPoint = meltingPoint;
    }

    public void setBoilingPoint(String boilingPoint) {
        this.boilingPoint = boilingPoint;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public void setGroupBlock(String groupBlock) {
        this.groupBlock = groupBlock;
    }

    public void setYearDiscovered(String yearDiscovered) {
        this.yearDiscovered = yearDiscovered;
    }

    public Element (int atomicNumber, String symbol, String name, String atomicMass, String cpkHexColor, String electronicConfiguration, String electronegativity, String atomicRadius, String ionRadius, String vanDelWaalsRadius, String ionizationEnergy, String electronAffinity, String oxidationStates, String standardState, String bondingType, String meltingPoint, String boilingPoint, String density, String groupBlock, String yearDiscovered) {
        this.setAtomicNumber(atomicNumber);
        this.setSymbol(symbol);
        this.setName(name);
        this.setAtomicMass(atomicMass);
        this.setCpkHexColor(cpkHexColor);
        this.setElectronicConfiguration(electronicConfiguration);
        this.setElectronegativity(electronegativity);
        this.setAtomicRadius(atomicRadius);
        this.setIonRadius(ionRadius);
        this.setVanDelWaalsRadius(vanDelWaalsRadius);
        this.setIonizationEnergy(ionizationEnergy);
        this.setElectronAffinity(electronAffinity);
        this.setOxidationStates(oxidationStates);
        this.setStandardState(standardState);
        this.setBondingType(bondingType);
        this.setMeltingPoint(meltingPoint);
        this.setBoilingPoint(boilingPoint);
        this.setDensity(density);
        this.setGroupBlock(groupBlock);
        this.setYearDiscovered(yearDiscovered);
    }
}
