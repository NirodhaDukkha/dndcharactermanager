package com.dndcharactermanager.CharacterChoices;

import com.dndcharactermanager.CharacterClassFragment;
import com.dndcharactermanager.DnDCharacter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dylan on 2/7/2017.
 */

public class CharacterClass {

    public enum CharacterClassType {FIGHTER, BARBARIAN, WIZARD, PALADIN;

    public enum CasterWeight {FULL,HALF,THIRD,NONE}
    private CasterWeight casterWeight;
    private Map<DnDCharacter.Skills, Boolean> skillOptions;
    private Map<Armor.ArmorName, Boolean> armorProficiency;
    private Map<DnDCharacter.Attributes, Boolean> saveProficiency;
    private int totalSkillProficiencies;
    private int classLevel;
    private int hitDice;

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    public int getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(int classLevel) {
        this.classLevel = classLevel;
    }

    public int getTotalSkillProficiencies() {
        return totalSkillProficiencies;
    }

    public void setTotalSkillProficiencies(int totalSkillProficiencies) {
        this.totalSkillProficiencies = totalSkillProficiencies;
    }

    public Map<DnDCharacter.Attributes, Boolean> getSaveProficiency() {
        return saveProficiency;
    }

    public void setSaveProficiency(Map<DnDCharacter.Attributes, Boolean> saveProficiency) {
        this.saveProficiency = saveProficiency;
    }

    public Map<Armor.ArmorName, Boolean> getArmorProficiency() {
        return armorProficiency;
    }

    public void setArmorProficiency(Map<Armor.ArmorName, Boolean> armorProficiency) {
        this.armorProficiency = armorProficiency;
    }

    public Map<DnDCharacter.Skills, Boolean> getSkillOptions() {
        return skillOptions;
    }

    public void setSkillOptions(Map<DnDCharacter.Skills, Boolean> skillOptions) {
        this.skillOptions = skillOptions;
    }

    public CasterWeight getCasterWeight() {
        return casterWeight;
    }

    public void setCasterWeight(CasterWeight casterWeight) {
        this.casterWeight = casterWeight;
    }

    }

}
