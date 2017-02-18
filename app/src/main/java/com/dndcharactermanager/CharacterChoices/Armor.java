package com.dndcharactermanager.CharacterChoices;

/**
 * Created by Dylan on 2/10/2017.
 */

public class Armor {

    //TODO: IMPLEMENT ARMOR PROFICIECY/TYPES

    public enum ArmorName {LEATHER, CHAINSHIRT, PLATE}
    private ArmorName armorName;
    private enum ArmorType {LIGHT, MEDIUM, HEAVY}
    private ArmorType armorType;
    private int ACBonus;
    private int DexBonus;

    //Private empty constructor.  Force use of argument constructor.
    private Armor(){}

    public Armor(ArmorName lookup){

        switch (lookup) {
            case LEATHER: {
                armorName = lookup;
                ACBonus = 11;
                armorType = ArmorType.LIGHT;
                DexBonus = 99;
                break;
            }
            case CHAINSHIRT: {
                armorName = lookup;
                ACBonus = 13;
                armorType = ArmorType.MEDIUM;
                DexBonus = 2;
                break;
            }
            case PLATE: {
                armorName = lookup;
                ACBonus = 18;
                armorType = ArmorType.HEAVY;
                DexBonus = 0;
                break;
            }
        }
    }

    public ArmorName getArmorName() {
        return armorName;
    }

    public int getACBonus() {
        return ACBonus;
    }

    public int getDexBonus() {
        return DexBonus;
    }

    public ArmorType getArmorType() {
        return armorType;
    }
}
