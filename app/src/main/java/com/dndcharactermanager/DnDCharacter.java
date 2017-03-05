package com.dndcharactermanager;

import com.dndcharactermanager.CharacterChoices.CharacterClass;
import com.dndcharactermanager.CharacterChoices.Race;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dylan on 2/5/2017.
 */

public class DnDCharacter {

    //Character Detail Values
    private static Race race;
    private static Set<CharacterClass> characterClass;
    private static int numberOfSkillsProficient;
    private static int attributePointBuy = 27;
    private static int characterLevel;

    public int getAttributePointBuy() {
        return attributePointBuy;
    }

    public void setAttributePointBuy(int attributePointBuy) {
        this.attributePointBuy = attributePointBuy;
    }


    //Singleton DnDCharacter
    private static DnDCharacter dnDCharacter;
    public static DnDCharacter getDnDCharacter(){
        if (dnDCharacter == null){
            dnDCharacter = new DnDCharacter();
        }
            return dnDCharacter;
    }

    private DnDCharacter(){
        //If the constructor is called, it's a new character and values should be set to defaults
        characterClass = new HashSet<>();
    }

    public static void updateCharacter(){
        int sum = 0;
        for (CharacterClass c: characterClass) {
            sum += c.getClassLevel();
        }
        characterLevel = sum;

    }

    public static int getModifier(int attribute){
        return (attribute - attribute%2 - 10)/2;
    }
}
