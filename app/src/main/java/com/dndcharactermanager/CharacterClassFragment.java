package com.dndcharactermanager;


import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.dndcharactermanager.CharacterChoices.CharacterClass;
import com.dndcharactermanager.CharacterChoices.Race;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterClassFragment extends Fragment {


    DnDCharacter dnDCharacter;

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
        ft.replace(R.id.skill_placeholder,new SkillListFragment());
        ft.addToBackStack(null);
        ft.commit();

        //TODO:  ERRONEOUS TODO FOR TESTING GIT

        Spinner classSpinner = (Spinner) view.findViewById(R.id.class_spinner);
        Spinner raceSpinner = (Spinner) view.findViewById(R.id.race_spinner);
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CharacterClass.CharacterClassType item = (CharacterClass.CharacterClassType) adapterView.getItemAtPosition(i);
                dnDCharacter.getCharacterClass().add(item); //TODO: THIS SHOULD FOLLOW SOME KIND OF SUBMIT BUTTON
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        raceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Race.CharacterRace item = (Race.CharacterRace) adapterView.getItemAtPosition(i);
                dnDCharacter.setRace(item); //TODO: THIS SHOULD FOLLOW SOME KIND OF SUBMIT BUTTON
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        List<CharacterClass.CharacterClassType> characterClassTypes = new ArrayList<>();
        List<Race.CharacterRace> characterRaceTypes = new ArrayList<>();
        for(CharacterClass.CharacterClassType c : CharacterClass.CharacterClassType.values()){
            characterClassTypes.add(c);
        }

        for(Race.CharacterRace r : Race.CharacterRace.values()){
            characterRaceTypes.add(r);
        }

        ArrayAdapter<CharacterClass.CharacterClassType> classAdapter =  new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,characterClassTypes);
        ArrayAdapter<Race.CharacterRace> raceAdapter =  new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,characterRaceTypes);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);
        raceSpinner.setAdapter(raceAdapter);

        return view;
    }

}
