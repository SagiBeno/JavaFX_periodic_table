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
                String symbol = parts[1].trim();
                String name = parts[2].trim();
                String atomicMass = parts[3].trim();
                String cpkHexColor = parts[4].trim();
                String electronicConfiguration = parts[5].trim();
                String electronegativity = parts[6].trim();
                String atomicRadius = parts[7].trim();
                String ionRadius = parts[8].trim();
                String vanDelWaalsRadius = parts[9].trim();
                String ionizationEnergy = parts[10].trim();
                String electronAffinity = parts[11].trim();
                String oxidationStates = parts[12].trim();
                String standardState = parts[13].trim();
                String bondingType = parts[14].trim();
                String meltingPoint = parts[15].trim();
                String boilingPoint = parts[16].trim();
                String density = parts[17].trim();
                String groupBlock = parts[18].trim();
                String yearDiscovered = parts[19].trim();

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
