package com.dndcharactermanager;

import com.dndcharactermanager.CharacterChoices.Armor;
import com.dndcharactermanager.CharacterChoices.CharacterClass;
import com.dndcharactermanager.CharacterChoices.Race;
import com.dndcharactermanager.CharacterChoices.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dylan on 2/5/2017.
 */

public class DnDCharacter {

    //Singleton DnDCharacter
    private static DnDCharacter dnDCharacter;
    private int attributePointBuy = 27;
    //Character Detail Values
    private int characterLevel;
    private Race.CharacterRace race;
    private Weapon weapon;
    private Armor armor;
    private List<CharacterClass.CharacterClassType> characterClass;

    public List<CharacterClass.CharacterClassType> getCharacterClass() {
        return characterClass;
    }

    //Character Detail Enums: Class, Attributes, Skills, etc
    public enum Attributes {STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA}
    public enum Skills {ATHLETICS, ACROBATICS, PERCEPTION, NATURE}

    //Character fields to fill
    private Map<Attributes,Integer> AttributeMap;
    private Map<Skills,Boolean> SkillProficiencyMap;
    private Map<Attributes,Boolean> SavesMap;

    public static DnDCharacter getDnDCharacter(){
        if (dnDCharacter == null){
            dnDCharacter = new DnDCharacter();
        }
            return dnDCharacter;
    }

    private DnDCharacter(){
        //If the constructor is called, it's a new character and values should be set to defaults
        characterLevel = 1;   //TODO: get characterLevel by adding up characterClass levels
        characterClass = new ArrayList<>();
//        SavesMap = characterClass.get(1).getSaveProficiency();
        weapon = new Weapon(Weapon.WeaponName.LONGSWORD);  //Weapon default is Longsword.
        armor = new Armor(Armor.ArmorName.LEATHER);  //Armor default is Leather.
        AttributeMap = new HashMap<>(6);
        fillAttributes();  //All Attributes default to 8
        SkillProficiencyMap = new HashMap<>(30);
        fillSkills();  //All Skills default to "not proficient";
    }

    public int getAttributePointBuy() {
        return attributePointBuy;
    }

    public void setAttributePointBuy(int attributePointBuy) {
        this.attributePointBuy = attributePointBuy;
    }

    public static int getModifier(int attribute){
        return (attribute - attribute%2 - 10)/2;
    }


    private void fillSkills(){
        for(Skills s : Skills.values()){
            SkillProficiencyMap.put(s, false);
        }
    }

    private void fillSaves(){
        for(Attributes a : Attributes.values()){
            SavesMap.put(a, false);
        }
    }

    private void fillAttributes(){
        for(Attributes a : Attributes.values()){
            AttributeMap.put(a, 8);
        }
    }

    public Race.CharacterRace getRace() {
        return race;
    }

    public void setRace(Race.CharacterRace race) {
        this.race = race;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Map<Attributes, Integer> getAttributeMap() {
        return AttributeMap;
    }

    public void setAttributeMap(Map<Attributes, Integer> attributeMap) {
        AttributeMap = attributeMap;
    }

    public Map<Skills, Boolean> getSkillProficiencyMap() {
        return SkillProficiencyMap;
    }

    public void setSkillProficiencyMap(Map<Skills, Boolean> skillProficiencyMap) {
        SkillProficiencyMap = skillProficiencyMap;
    }

    public Map<Attributes, Boolean> getSavesMap() {
        return SavesMap;
    }

    public void setSavesMap(Map<Attributes, Boolean> savesMap) {
        SavesMap = savesMap;
    }
}
