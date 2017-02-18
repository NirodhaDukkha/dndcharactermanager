package com.dndcharactermanager;


import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.dndcharactermanager.CharacterChoices.CharacterClass;

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
        Spinner spinner = (Spinner) view.findViewById(R.id.class_spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) adapterView.getItemAtPosition(i);
                dnDCharacter.characterClass.add(CharacterClass.CharacterClassType.valueOf(item)); //TODO: THIS SHOULD FOLLOW SOME KIND OF SUBMIT BUTTON
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        List<String> characterClassTypes = new ArrayList<>();
        for(CharacterClass.CharacterClassType c : CharacterClass.CharacterClassType.values()){
            characterClassTypes.add(c.toString());
        }

        ArrayAdapter<String> adapter =  new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,characterClassTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return view;
    }

}
