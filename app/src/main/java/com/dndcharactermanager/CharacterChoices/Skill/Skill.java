package com.dndcharactermanager.CharacterChoices.Skill;

/**
 * Created by Dylan on 2/27/2017.
 */

public enum Skill {ACROBATICS,
    ANIMALHANDLING{
    @Override
    public String toString() {
        return "ANIMAL HANDLING";
    }
},
    ARCANA,ATHLETICS,DECEPTION,HISTORY,INSIGHT,INTIMIDATION,INVESTIGATION,
    MEDICINE,NATURE,PERCEPTION,PERFORMANCE,PERSUASION,RELIGION,
    SLEIGHTOFHAND{    @Override
                    public String toString() {
                        return "SLEIGHT OF HAND";
                    }},
    STEALTH,SURVIVAL;

    private Skill(){
        this.canBeProficient = false;
        this.isProficient = false;
    }

    private boolean canBeProficient;
    private boolean isProficient;

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
        if(canBeProficient) {
            isProficient = proficient;
        }
    }
}
