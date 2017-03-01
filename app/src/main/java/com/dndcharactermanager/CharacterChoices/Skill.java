package com.dndcharactermanager.CharacterChoices;

/**
 * Created by Dylan on 2/27/2017.
 */

public enum Skill {ACROBATICS,ANIMALHANDLING,ARCANA,ATHLETICS,DECEPTION,
                    HISTORY,INSIGHT,INTIMIDATION,INVESTIGATION,MEDICINE,
                    NATURE,PERCEPTION,PERFORMANCE,PERSUASION,RELIGION,
                    SLEIGHTOFHAND,STEALTH,SURVIVAL;

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
        isProficient = proficient;
    }
}
