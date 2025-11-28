package org.example.periodictable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertThrows;

public class TestClass {

    @Before
    public void testBefore() {
        PeriodicTableApplication.isRunningTest = true;
        Launcher.isRunningTest = true;
        PeriodicTableController.isRunningTest = true;
    }

    @Test
    public void testLauncher() {
        Launcher.main(null);
    }

    @Test
    public void applicationTest() throws IOException {
        PeriodicTableApplication app = new PeriodicTableApplication();
        app.start(null);
    }

    @Test
    public void testLoadFromCSV() {
        LoadFromCSV.filereader("periodic-table-data.csv");
    }

    @Test
    public void testLoadFromCSVWithExepction() {
        assertThrows(RuntimeException.class, () -> {
            LoadFromCSV.filereader("periodic-table-data.cs");
        });
    }

    @Test
    public void testController() {
        PeriodicTableController controller = new PeriodicTableController();
        controller.initialize(null, null);
        Assert.assertNotEquals(0, PeriodicTableController.elementsArray);
    }

    @Test
    public void testIsColorDark() {
        PeriodicTableController controller = new PeriodicTableController();
        Assert.assertFalse(controller.isColorDark("#B3E3F5"));
        Assert.assertTrue(controller.isColorDark("#420066"));
    }

    @Test
    public void testHexExamine() {
        PeriodicTableController controller = new PeriodicTableController();
        Assert.assertEquals("#B3E3F5", controller.hexExamine("#B3E3F5"));
        Assert.assertEquals("#B3E3F9", controller.hexExamine("B3E3F9"));
        Assert.assertEquals("#FFFFFF", controller.hexExamine("#FFF"));
        Assert.assertEquals("#CC44GGHH", controller.hexExamine("#C4GH"));
        Assert.assertEquals("#000000", controller.hexExamine("#C4"));
    }

    @Test
    public void testPropertyRow() {
        String key = "key";
        String value = "value";
        PropertyRow propertyRow = new PropertyRow(key, value);
        Assert.assertEquals(key, propertyRow.getKey());
        Assert.assertEquals(value, propertyRow.getValue());
    }

    @Test
    public void testElement() {
        int atomicNumber = 1;
        String symbol = "H";
        String name = "Hydrogen";
        String atomicMass = "1.00794(4)";
        String cpkHexColor = "FFFFFF";
        String electronicConfiguration = "1s1";
        String electronegativity = "2.2";
        String atomicRadius = "37";
        String ionRadius = "";
        String vanDelWaalsRadius = "120";
        String ionizationEnergy = "1312";
        String electronAffinity = "-73";
        String oxidationStates = "\"-1, 1\"";
        String standardState = "gas";
        String bondingType = "diatomic";
        String meltingPoint = "14";
        String boilingPoint = "20";
        String density = "0.0000899";
        String groupBlock = "nonmetal";
        String yearDiscovered = "1766";

        Element newElement = new Element(atomicNumber, symbol, name, atomicMass, cpkHexColor, electronicConfiguration, electronegativity, atomicRadius, ionRadius, vanDelWaalsRadius, ionizationEnergy, electronAffinity, oxidationStates, standardState, bondingType, meltingPoint, boilingPoint, density, groupBlock, yearDiscovered);
        Assert.assertEquals(1, newElement.getAtomicNumber());
        Assert.assertEquals("Hydrogen", newElement.getName());
        Assert.assertEquals("H", newElement.getSymbol());
        Assert.assertEquals("1.00794(4)", newElement.getAtomicMass());
        Assert.assertEquals("1s1", newElement.getElectronicConfiguration());
        Assert.assertEquals("2.2", newElement.getElectronegativity());
        Assert.assertEquals("37", newElement.getAtomicRadius());
        Assert.assertEquals("", newElement.getIonRadius());
        Assert.assertEquals("120", newElement.getVanDelWaalsRadius());
        Assert.assertEquals("1312", newElement.getIonizationEnergy());
        Assert.assertEquals("-73", newElement.getElectronAffinity());
        Assert.assertEquals("\"-1, 1\"", newElement.getOxidationStates());
        Assert.assertEquals("gas", newElement.getStandardState());
        Assert.assertEquals("diatomic", newElement.getBondingType());
        Assert.assertEquals("14", newElement.getMeltingPoint());
        Assert.assertEquals("20", newElement.getBoilingPoint());
        Assert.assertEquals("0.0000899", newElement.getDensity());
        Assert.assertEquals("nonmetal", newElement.getGroupBlock());
        Assert.assertEquals("1766", newElement.getYearDiscovered());
        Assert.assertEquals("FFFFFF", newElement.getCpkHexColor());
    }
}
