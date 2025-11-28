package org.example.periodictable;

import javafx.beans.property.SimpleStringProperty;

public class PropertyRow {
    SimpleStringProperty key;
    SimpleStringProperty value;

    public String getKey() {
        return key.get();
    }

    public String getValue() {
        return value.get();
    }

    public void setKey(String key) {
        this.key = new SimpleStringProperty(key);
    }

    public void setValue(String value) {
        this.value = new SimpleStringProperty(value);
    }

    public PropertyRow(String key, String value) {
        this.setKey(key);
        this.setValue(value);
    }
}
