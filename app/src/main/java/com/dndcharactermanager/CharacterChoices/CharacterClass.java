package com.dndcharactermanager.CharacterChoices;

import com.dndcharactermanager.DnDCharacter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dylan on 2/7/2017.
 */

public class CharacterClass {


    public CharacterClass(CharacterClassType characterClassType){
        this.characterClassType = characterClassType;

        switch(characterClassType){
            case FIGHTER:{
                casterWeight = CasterWeight.NONE;
                totalSkillProficiencies = 2;
                hitDice = 10;

                skillOptions = new HashMap<>();
                skillOptions.put(DnDCharacter.SkillType.ACROBATICS, true);
                skillOptions.put(DnDCharacter.SkillType.ATHLETICS, true);



                armorProficiency = new HashMap<>();
                for(Armor.ArmorName a : Armor.ArmorName.values()){
                    armorProficiency.put(a, true);
                }

                saveProficiency = new HashMap<>();
                saveProficiency.put(DnDCharacter.Attributes.STRENGTH, true);
                saveProficiency.put(DnDCharacter.Attributes.CONSTITUTION, true);

                break;
            }
            case BARBARIAN:{
                break;
            }
            case WIZARD:{
                break;
            }
            case PALADIN:{
                break;
            }

        }
    }

    public enum CharacterClassType {
        FIGHTER, BARBARIAN, WIZARD, PALADIN;
    }
    private enum CasterWeight {FULL, HALF, THIRD, NONE}


    DnDCharacter dnDCharacter = DnDCharacter.getDnDCharacter();
    CharacterClassType characterClassType;

    private CasterWeight casterWeight;
    private Map<DnDCharacter.SkillType, Boolean> skillOptions;
    private Map<Armor.ArmorName, Boolean> armorProficiency;
    private Map<DnDCharacter.Attributes, Boolean> saveProficiency;
    private int totalSkillProficiencies;
    private int classLevel;
    private int hitDice;

    public CharacterClassType getCharacterClassType() {
        return characterClassType;
    }

    public CasterWeight getCasterWeight() {
        return casterWeight;
    }

    public Map<DnDCharacter.SkillType, Boolean> getSkillOptions() {
        return skillOptions;
    }

    public Map<Armor.ArmorName, Boolean> getArmorProficiency() {
        return armorProficiency;
    }

    public Map<DnDCharacter.Attributes, Boolean> getSaveProficiency() {
        return saveProficiency;
    }

    public int getTotalSkillProficiencies() {
        return totalSkillProficiencies;
    }

    public int getClassLevel() {
        return classLevel;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setClassLevel(int classLevel) {
        this.classLevel = classLevel;
    }
}
