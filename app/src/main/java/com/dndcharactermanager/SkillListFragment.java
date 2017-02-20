package com.dndcharactermanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;


public class SkillListFragment extends Fragment {

    DnDCharacter dnDCharacter;

    CheckBox athleticsCheckBox;
    CheckBox acrobaticsCheckBox;
    CheckBox survivalCheckBox;
    CheckBox medicineCheckBox;

    public SkillListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_skill_list, container, false);
        dnDCharacter = DnDCharacter.getDnDCharacter();

        dnDCharacter = DnDCharacter.getDnDCharacter();
        athleticsCheckBox = (CheckBox) view.findViewById(R.id.cb_athletics);
        acrobaticsCheckBox = (CheckBox) view.findViewById(R.id.cb_acrobatics);
        survivalCheckBox = (CheckBox) view.findViewById(R.id.cb_survival);
        medicineCheckBox = (CheckBox) view.findViewById(R.id.cb_medicine);

        athleticsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSkillProficiency(dnDCharacter,DnDCharacter.SkillType.ATHLETICS);
            }
        });
        acrobaticsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSkillProficiency(dnDCharacter,DnDCharacter.SkillType.ACROBATICS);
            }
        });
        survivalCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSkillProficiency(dnDCharacter,DnDCharacter.SkillType.SURVIVAL);
            }
        });
        medicineCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSkillProficiency(dnDCharacter,DnDCharacter.SkillType.MEDICINE);
            }
        });
        return view;
    }

    private void addSkillProficiency(DnDCharacter dnDCharacter, DnDCharacter.SkillType skill){
        if (skill.isCanBeProficient()){
            skill.setProficient(true);
        }
    }
}
