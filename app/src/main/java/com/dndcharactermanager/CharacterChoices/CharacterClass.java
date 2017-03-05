package com.dndcharactermanager.CharacterChoices;

import com.dndcharactermanager.CharacterChoices.Skill.Skill;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dylan on 2/7/2017.
 */

public class CharacterClass {

    public enum CharacterClassType {
        BARBARIAN,BARD,CLERIC,DRUID,FIGHTER,MONK,
        PALADIN,RANGER,ROGUE,SORCERER,WARLOCK,WIZARD
    }

    CharacterClassType characterClassType;
    private Set<Skill> skills;
    private Set<Attribute> attributes;
    private int totalSkillProficiencies = 2;
    private int classLevel;
    private int hitDice;

    public CharacterClass(CharacterClassType characterClassType){
        this.characterClassType = characterClassType;
        this.skills = new HashSet<>();
        switch(characterClassType){
            case BARBARIAN:{
                break;
            }
            case BARD:{
                break;
            }
            case CLERIC:{
                break;
            }
            case DRUID:{
                break;
            }
            case FIGHTER:{
                skills.add(Skill.ACROBATICS);
                skills.add(Skill.ANIMALHANDLING);
                skills.add(Skill.ATHLETICS);
                skills.add(Skill.HISTORY);
                skills.add(Skill.INSIGHT);
                skills.add(Skill.INTIMIDATION);
                skills.add(Skill.PERCEPTION);
                skills.add(Skill.SURVIVAL);
                Attribute.STRENGTH.setProficient(true);
                Attribute.CONSTITUTION.setProficient(true);
                break;
            }
            case MONK:{
                break;
            }
            case PALADIN:{
                break;
            }
            case RANGER:{
                break;
            }
            case ROGUE:{
                break;
            }
            case SORCERER:{
                break;
            }
            case WARLOCK:{
                break;
            }
            case WIZARD:{
                break;
            }
        }
    }

    public CharacterClassType getCharacterClassType() {
        return characterClassType;
    }

    public void setCharacterClassType(CharacterClassType characterClassType) {
        this.characterClassType = characterClassType;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }

    public int getTotalSkillProficiencies() {
        return totalSkillProficiencies;
    }

    public void setTotalSkillProficiencies(int totalSkillProficiencies) {
        this.totalSkillProficiencies = totalSkillProficiencies;
    }

    public int getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(int classLevel) {
        this.classLevel = classLevel;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }
}
