package org.example.periodictable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadFromCSV {
    public static ArrayList<Element> filereader(String filename) {
        ArrayList<Element> elements = new ArrayList<>();

        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);

            reader.nextLine();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(",");

                int atomicNumber = Integer.parseInt(parts[0]);
                String symbol = parts[1];
                String name = parts[2];
                String atomicMass = parts[3];
                String cpkHexColor = parts[4];
                String electronicConfiguration = parts[5];
                String electronegativity = parts[6];
                String atomicRadius = parts[7];
                String ionRadius = parts[8];
                String vanDelWaalsRadius = parts[9];
                String ionizationEnergy = parts[10];
                String electronAffinity = parts[11];
                String oxidationStates = parts[12];
                String standardState = parts[13];
                String bondingType = parts[14];
                String meltingPoint = parts[15];
                String boilingPoint = parts[16];
                String density = parts[17];
                String groupBlock = parts[18];
                String yearDiscovered = parts[19];

                Element newElement = new Element(atomicNumber, symbol, name, atomicMass, cpkHexColor, electronicConfiguration, electronegativity, atomicRadius, ionRadius, vanDelWaalsRadius, ionizationEnergy, electronAffinity, oxidationStates, standardState, bondingType, meltingPoint, boilingPoint, density, groupBlock, yearDiscovered);
                elements.add(newElement);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return elements;
    }
}
