package com.dndcharactermanager.CharacterChoices;

/**
 * Created by Dylan on 2/27/2017.
 */

public enum Attribute {
    STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA;

    private Attribute(){
        this.isProficient = false;
        this.attributeValue = 8;
    }
    private int attributeValue;
    private boolean isProficient;

    public boolean isProficient() {
        return isProficient;
    }

    public void setProficient(boolean proficient) {
        isProficient = proficient;
    }

    public int getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(int attributeValue) {
        this.attributeValue = attributeValue;
    }
}
