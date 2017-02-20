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
    public static final int numberOfSkills = 4;
    private static DnDCharacter dnDCharacter;
    private int attributePointBuy = 27;
    //Character Detail Values
    private int characterLevel;
    private Race.CharacterRace race;
    private Weapon weapon;
    private Armor armor;
    private Skills skills;

    private List<CharacterClass> characterClass;
    private ArrayList<Skills> skillList;
    public List<CharacterClass> getCharacterClass() {
        return characterClass;
    }

    //Character Detail Enums: Class, Attributes, SkillType, etc
    public enum Attributes {STRENGTH, DEXTERITY, CONSTITUTION, INTELLIGENCE, WISDOM, CHARISMA}
    public enum SkillType {ATHLETICS, ACROBATICS, PERCEPTION, NATURE}

    //Character fields to fill
    private Map<Attributes,Integer> AttributeMap;
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
        skillList = new ArrayList<>();
        weapon = new Weapon(Weapon.WeaponName.LONGSWORD);  //Weapon default is Longsword.
        armor = new Armor(Armor.ArmorName.LEATHER);  //Armor default is Leather.
        SavesMap = new HashMap<>(6);
        fillSaves();
        AttributeMap = new HashMap<>(6);
        fillAttributes();  //All Attributes default to 8
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

    public Map<Attributes, Boolean> getSavesMap() {
        return SavesMap;
    }

    public void setSavesMap(Map<Attributes, Boolean> savesMap) {
        SavesMap = savesMap;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = characterLevel;
    }

    public void setCharacterClass(List<CharacterClass> characterClass) {
        this.characterClass = characterClass;
    }

    public void updateCharacter(){
        int sum = 0;
        for (CharacterClass c: characterClass) {
            sum += c.getClassLevel();
        }
        characterLevel = sum;
    }

    private class Skills{


        private SkillType skillType;
        private boolean canBeProficient;
        private boolean isProficient;

        public SkillType getSkillType() {
            return skillType;
        }

        public void setSkillType(SkillType skillType) {
            this.skillType = skillType;
        }

        public boolean isCanBeProficient() {
            return canBeProficient;
        }

        public void setCanBeProficient(boolean canBeProficient) {
            this.canBeProficient = canBeProficient;
        }

        public boolean isProficient() {
            return isProficient;
        }

        public void setProficient(boolean proficient) {
            isProficient = proficient;
        }
    }
}
