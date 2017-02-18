package com.dndcharactermanager.CharacterChoices;

import com.dndcharactermanager.DnDCharacter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dylan on 2/7/2017.
 */

public class Race {

    public enum CharacterRace {ORC, HUMAN, ELF, GNOME}
    private CharacterRace characterRace;

    private Map<DnDCharacter.Attributes, Integer> AttributeBonus;
    private Map<DnDCharacter.Skills, Boolean> SkillBonus;

    //Private empty constructor.  Force use of argument constructor.
    private Race(){}

    public Race(CharacterRace race){

        AttributeBonus = new HashMap<>();
        SkillBonus = new HashMap<>();

        switch(race){
            case ORC:{
                characterRace = CharacterRace.ORC;
                AttributeBonus.put(DnDCharacter.Attributes.STRENGTH,2);
                AttributeBonus.put(DnDCharacter.Attributes.CONSTITUTION,1);
                break;
            }
            case HUMAN:{
                characterRace = CharacterRace.HUMAN;
                AttributeBonus.put(DnDCharacter.Attributes.STRENGTH,1);
                AttributeBonus.put(DnDCharacter.Attributes.DEXTERITY,1);
                AttributeBonus.put(DnDCharacter.Attributes.CONSTITUTION,1);
                AttributeBonus.put(DnDCharacter.Attributes.INTELLIGENCE,1);
                AttributeBonus.put(DnDCharacter.Attributes.WISDOM,1);
                AttributeBonus.put(DnDCharacter.Attributes.CHARISMA,1);
                break;
            }
            case ELF:{
                characterRace = CharacterRace.ELF;
                AttributeBonus.put(DnDCharacter.Attributes.DEXTERITY,2);
                AttributeBonus.put(DnDCharacter.Attributes.WISDOM,1);
                break;
            }
            case GNOME:{
                characterRace = CharacterRace.GNOME;
                AttributeBonus.put(DnDCharacter.Attributes.INTELLIGENCE,2);
                AttributeBonus.put(DnDCharacter.Attributes.CONSTITUTION,1);
                break;
            }
        }

    }

    public Map<DnDCharacter.Attributes, Integer> getAttributeBonus() {
        return AttributeBonus;
    }

    public Map<DnDCharacter.Skills, Boolean> getSkillBonus() {
        return SkillBonus;
    }

    public CharacterRace getCharacterRace() {
        return characterRace;
    }



}
