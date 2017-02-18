package com.dndcharactermanager.CharacterChoices;

import com.dndcharactermanager.DnDCharacter;

/**
 * Created by Dylan on 2/6/2017.
 */

public class Weapon {

    public enum WeaponName {LONGSWORD, SHORTSWORD, LONGBOW, SHORTBOW}
    private WeaponName weaponName;
    private int WeaponDamage;
    private DnDCharacter.Attributes WeaponAttribute;

    //TODO: IMPLEMENT WEAPON PROFICIENCIES/TYPES

    //Private empty constructor.  Force use of argument constructor.
    private Weapon(){}

    public Weapon(WeaponName lookup){

        switch (lookup) {
            case LONGSWORD: {
                weaponName = lookup;
                WeaponDamage = 8;
                WeaponAttribute = DnDCharacter.Attributes.STRENGTH;
                break;
            }
            case SHORTSWORD: {
                weaponName = lookup;
                WeaponDamage = 6;
                WeaponAttribute = DnDCharacter.Attributes.STRENGTH;
                break;
            }
            case LONGBOW: {
                weaponName = lookup;
                WeaponDamage = 8;
                WeaponAttribute = DnDCharacter.Attributes.DEXTERITY;
                break;
            }
            case SHORTBOW: {
                weaponName = lookup;
                WeaponDamage = 6;
                WeaponAttribute = DnDCharacter.Attributes.DEXTERITY;
                break;
            }
        }
    }

    public WeaponName getWeaponName() {
        return weaponName;
    }

    public int getWeaponDamage() {
        return WeaponDamage;
    }

    public DnDCharacter.Attributes getWeaponAttribute() {
        return WeaponAttribute;
    }
}
