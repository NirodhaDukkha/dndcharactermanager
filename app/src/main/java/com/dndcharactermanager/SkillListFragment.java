package com.dndcharactermanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.dndcharactermanager.CharacterChoices.Skill;

import java.util.HashMap;
import java.util.HashSet;


public class SkillListFragment extends Fragment {

    //        ACROBATICS,ANIMALHANDLING,ARCANA,ATHLETICS,DECEPTION,
//                HISTORY,INSIGHT,INTIMIDATION,INVESTIGATION,MEDICINE,
//                NATURE,PERCEPTION,PERFORMANCE,PERSUASION,RELIGION,
//                SLEIGHTOFHAND,STEALTH,SURVIVAL;

    HashMap<Skill,CheckBox> checkBoxHashMap;
    CheckBox acrobaticsCheckBox;
    CheckBox animalhandlingCheckBox;
    CheckBox arcanaCheckBox;
    CheckBox athleticsCheckBox;
    CheckBox deceptionCheckBox;
    CheckBox historyCheckBox;
    CheckBox insightCheckBox;
    CheckBox intimidationCheckBox;
    CheckBox investigationCheckBox;
    CheckBox medicineCheckBox;
    CheckBox natureCheckBox;
    CheckBox perceptionCheckBox;
    CheckBox performanceCheckBox;
    CheckBox persuasionCheckBox;
    CheckBox religionCheckBox;
    CheckBox sleightofhandCheckBox;
    CheckBox stealthCheckbox;
    CheckBox survivalCheckBox;

    public SkillListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_skill_list, container, false);

        athleticsCheckBox = (CheckBox) view.findViewById(R.id.cb_athletics);
        acrobaticsCheckBox = (CheckBox) view.findViewById(R.id.cb_acrobatics);
        survivalCheckBox = (CheckBox) view.findViewById(R.id.cb_survival);
        medicineCheckBox = (CheckBox) view.findViewById(R.id.cb_medicine);

        athleticsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSkillProficiency(Skill.ATHLETICS);
            }
        });
        acrobaticsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSkillProficiency(Skill.ACROBATICS);
            }
        });
        survivalCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSkillProficiency(Skill.SURVIVAL);
            }
        });
        medicineCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSkillProficiency(Skill.MEDICINE);
            }
        });
        return view;
    }

    private void addSkillProficiency(Skill skill){
        if (skill.isCanBeProficient()){
            skill.setProficient(true);
        }
    }

    private void fillHashMap(){
        checkBoxHashMap = new HashMap<>();
        for(Skill s:Skill.values()){

        }
    }
}
