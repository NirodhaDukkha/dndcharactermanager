package com.dndcharactermanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.dndcharactermanager.CharacterChoices.CharacterClass;
import com.dndcharactermanager.CharacterChoices.Race;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterClassFragment extends Fragment {


    DnDCharacter dnDCharacter;
    Button updateButton;

    public CharacterClassFragment() {
        // Required empty public constructor
    }

    public static CharacterClassFragment newInstance() {
        CharacterClassFragment fragment = new CharacterClassFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        dnDCharacter = DnDCharacter.getDnDCharacter();
        View view = inflater.inflate(R.layout.fragment_charclass, container, false);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.skill_placeholder,new SkillListFragment()).commit();

        //CLASS SPINNER AND ADAPTER
        final Spinner classSpinner = (Spinner) view.findViewById(R.id.class_spinner);
        List<CharacterClass.CharacterClassType> characterClassTypes = new ArrayList<>();
        for(CharacterClass.CharacterClassType c : CharacterClass.CharacterClassType.values()) {
            characterClassTypes.add(c);
        }
        ArrayAdapter<CharacterClass.CharacterClassType> classAdapter =  new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,characterClassTypes);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);

        //LEVEL SPINNER AND ADAPTER
        final Spinner levelSpinner = (Spinner) view.findViewById(R.id.level_spinner);
        List<Integer> levelList = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            levelList.add(i);
        }
        ArrayAdapter<Integer> levelAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,levelList);
        levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(levelAdapter);


        //RACE SPINNER AND ADAPTER
        final Spinner raceSpinner = (Spinner) view.findViewById(R.id.race_spinner);
        List<Race> raceTypeTypes = new ArrayList<>();
        for(Race r : Race.values()){
            raceTypeTypes.add(r);
        }

        ArrayAdapter<Race> raceAdapter =  new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, raceTypeTypes);
        raceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceSpinner.setAdapter(raceAdapter);

        //UPDATE CHARACTER WITH CLASS,LEVEL,RACE
        updateButton = (Button) view.findViewById(R.id.bt_update);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharacterClass charClass = new CharacterClass((CharacterClass.CharacterClassType) classSpinner.getSelectedItem());
                Race race = ((Race) raceSpinner.getSelectedItem());
                charClass.setClassLevel((Integer) levelSpinner.getSelectedItem());
//                dnDCharacter.getCharacterClass().add(charClass);
                dnDCharacter.updateCharacter();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
