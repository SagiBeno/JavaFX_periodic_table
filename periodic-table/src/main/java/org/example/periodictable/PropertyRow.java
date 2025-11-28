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
        this.key.set(key);
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public PropertyRow(String key, String value) {
        this.key = new SimpleStringProperty(key);
        this.value = new SimpleStringProperty(value);
    }
}
