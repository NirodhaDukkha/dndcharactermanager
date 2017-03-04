package com.dndcharactermanager.CharacterChoices;

import com.dndcharactermanager.DnDCharacter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dylan on 2/7/2017.
 */

public enum Race {ORC{
    @Override
    public void updateAttributeBonus() {
        super.updateAttributeBonus();
        getAttributeBonus().put(Attribute.STRENGTH,2);
        getAttributeBonus().put(Attribute.STRENGTH,1);
    }
}, HUMAN, ELF, GNOME;

    private Map<Attribute,Integer> attributeBonus = new HashMap<>();

    private Race() {
    }

    public Map<Attribute, Integer> getAttributeBonus() {
        return attributeBonus;
    }

    public void setAttributeBonus(Map<Attribute, Integer> attributeBonus) {
        this.attributeBonus = attributeBonus;
    }

    public void updateAttributeBonus(){}
}
