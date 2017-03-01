package com.dndcharactermanager.CharacterChoices;

import com.dndcharactermanager.DnDCharacter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dylan on 2/7/2017.
 */

public enum Race {ORC, HUMAN, ELF, GNOME;

    //Private empty constructor.  Force use of argument constructor.

    private Map<Attribute,Integer> attributeBonus;

    private Race() {

        attributeBonus = new HashMap<>();

        switch (this) {
            case ORC: {
                attributeBonus.put(Attribute.STRENGTH, 2);
                attributeBonus.put(Attribute.CONSTITUTION, 1);
                break;
            }
            case HUMAN: {
                attributeBonus.put(Attribute.STRENGTH, 1);
                attributeBonus.put(Attribute.DEXTERITY, 1);
                attributeBonus.put(Attribute.CONSTITUTION, 1);
                attributeBonus.put(Attribute.INTELLIGENCE, 1);
                attributeBonus.put(Attribute.WISDOM, 1);
                attributeBonus.put(Attribute.CHARISMA, 1);
                break;
            }
            case ELF: {
                attributeBonus.put(Attribute.DEXTERITY, 2);
                attributeBonus.put(Attribute.WISDOM, 1);
                break;
            }
            case GNOME: {
                attributeBonus.put(Attribute.INTELLIGENCE, 2);
                attributeBonus.put(Attribute.CONSTITUTION, 1);
                break;
            }
        }
    }

    public Map<Attribute, Integer> getAttributeBonus() {
        return attributeBonus;
    }

    public void setAttributeBonus(Map<Attribute, Integer> attributeBonus) {
        this.attributeBonus = attributeBonus;
    }
}
