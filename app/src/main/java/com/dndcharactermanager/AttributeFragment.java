package com.dndcharactermanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dndcharactermanager.CharacterChoices.Attribute;
import com.dndcharactermanager.CharacterChoices.CharacterClass;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class AttributeFragment extends Fragment {

    DnDCharacter dnDCharacter;
    TextView pointBuyTV;
    Map<Attribute, Button> attributeBTaddMap;
    Map<Attribute, Button> attributeBTsubMap;
    Map<Attribute, TextView> attributeTVvalueMap;
    Map<Attribute, TextView> attributeTVmodMap;

    public AttributeFragment() {
        // Required empty public constructor
    }

    public static AttributeFragment newInstance() {
        AttributeFragment fragment = new AttributeFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_attribute, container, false);

        dnDCharacter = DnDCharacter.getDnDCharacter();
        attributeBTaddMap = new HashMap<>();
        attributeBTsubMap = new HashMap<>();
        attributeTVvalueMap = new HashMap<>();
        attributeTVmodMap = new HashMap<>();
        pointBuyTV = (TextView) view.findViewById(R.id.tv_points_remaining);

        wireAttributeWidgets(view);

        for(final Attribute a : Attribute.values()){

            attributeBTaddMap.get(a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addButtonPress(a);
            }
        });

            attributeBTsubMap.get(a).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    subButtonPress(a);
                }
            });
        }

        final Spinner levelSpinner = (Spinner) view.findViewById(R.id.att_level_spinner);
        ArrayList<Integer> levelList = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            levelList.add(i);
        }
        ArrayAdapter<Integer> levelAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,levelList);
        levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(levelAdapter);

        final Spinner classSpinner = (Spinner) view.findViewById(R.id.att_class_spinner);
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        List<CharacterClass.CharacterClassType> characterClassTypes = new ArrayList<>();
        for(CharacterClass.CharacterClassType c : CharacterClass.CharacterClassType.values()){
            characterClassTypes.add(c);
        }
        ArrayAdapter<CharacterClass.CharacterClassType> classAdapter =  new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,characterClassTypes);
        classSpinner.setAdapter(classAdapter);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        Gson gson = new Gson();
//        String jsonString = gson.toJson(dnDCharacter);
//        Log.i("BUTTS","export to json: " + jsonString);

        return view;
    }

    private void addButtonPress(Attribute a) {
        int pointsLeft = dnDCharacter.getAttributePointBuy();
        int attributeValue = a.getAttributeValue();

        if (pointsLeft <= 0){
            Toast.makeText(getContext(), "Not enough points!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (attributeValue < 13){
            pointsLeft -= 1;
            attributeValue +=1;
        }else if(attributeValue == 15){
            Toast.makeText(getContext(), "Attribute maximum reached!", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            if (pointsLeft>1){
                pointsLeft -= 2;
                attributeValue += 1;
            }else{
                Toast.makeText(getContext(), "Not enough points!", Toast.LENGTH_SHORT).show();
                return;
            }

        }

        dnDCharacter.setAttributePointBuy(pointsLeft);
        a.setAttributeValue(attributeValue);

        pointBuyTV.setText((Integer.toString(pointsLeft)));

        attributeTVvalueMap.get(a).setText(Integer.toString(attributeValue));
        attributeTVmodMap.get(a).setText(Integer.toString(DnDCharacter.getModifier(attributeValue)));
    }

    private void subButtonPress(Attribute a) {
        int pointsLeft = dnDCharacter.getAttributePointBuy();
        int attributeValue = a.getAttributeValue();

        if (attributeValue == 8){
            Toast.makeText(getContext(), "Attribute minimum reached!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (attributeValue <= 13){
            pointsLeft += 1;
            attributeValue -=1;
        }
        else{
            pointsLeft += 2;
            attributeValue -= 1;
            }

        dnDCharacter.setAttributePointBuy(pointsLeft);
        a.setAttributeValue(attributeValue);

        pointBuyTV.setText((Integer.toString(pointsLeft)));

        attributeTVvalueMap.get(a).setText(Integer.toString(attributeValue));
        attributeTVmodMap.get(a).setText(Integer.toString(DnDCharacter.getModifier(attributeValue)));
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void wireAttributeWidgets(View view){
        attributeBTaddMap.put(Attribute.STRENGTH, (Button) view.findViewById(R.id.bt_strength_add));
        attributeBTaddMap.put(Attribute.DEXTERITY, (Button) view.findViewById(R.id.bt_dexterity_add));
        attributeBTaddMap.put(Attribute.CONSTITUTION, (Button) view.findViewById(R.id.bt_constitution_add));
        attributeBTaddMap.put(Attribute.INTELLIGENCE, (Button) view.findViewById(R.id.bt_intelligence_add));
        attributeBTaddMap.put(Attribute.WISDOM, (Button) view.findViewById(R.id.bt_wisdom_add));
        attributeBTaddMap.put(Attribute.CHARISMA, (Button) view.findViewById(R.id.bt_charisma_add));

        attributeBTsubMap.put(Attribute.STRENGTH, (Button) view.findViewById(R.id.bt_strength_sub));
        attributeBTsubMap.put(Attribute.DEXTERITY, (Button) view.findViewById(R.id.bt_dexterity_sub));
        attributeBTsubMap.put(Attribute.CONSTITUTION, (Button) view.findViewById(R.id.bt_constitution_sub));
        attributeBTsubMap.put(Attribute.INTELLIGENCE, (Button) view.findViewById(R.id.bt_intelligence_sub));
        attributeBTsubMap.put(Attribute.WISDOM, (Button) view.findViewById(R.id.bt_wisdom_sub));
        attributeBTsubMap.put(Attribute.CHARISMA, (Button) view.findViewById(R.id.bt_charisma_sub));

        attributeTVvalueMap.put(Attribute.STRENGTH, (TextView) view.findViewById(R.id.tv_strength_value));
        attributeTVvalueMap.put(Attribute.DEXTERITY, (TextView) view.findViewById(R.id.tv_dexterity_value));
        attributeTVvalueMap.put(Attribute.CONSTITUTION, (TextView) view.findViewById(R.id.tv_constitution_value));
        attributeTVvalueMap.put(Attribute.INTELLIGENCE, (TextView) view.findViewById(R.id.tv_intelligence_value));
        attributeTVvalueMap.put(Attribute.WISDOM, (TextView) view.findViewById(R.id.tv_wisdom_value));
        attributeTVvalueMap.put(Attribute.CHARISMA, (TextView) view.findViewById(R.id.tv_charisma_value));

        attributeTVmodMap.put(Attribute.STRENGTH, (TextView) view.findViewById(R.id.tv_strength_mod));
        attributeTVmodMap.put(Attribute.DEXTERITY, (TextView) view.findViewById(R.id.tv_dexterity_mod));
        attributeTVmodMap.put(Attribute.CONSTITUTION, (TextView) view.findViewById(R.id.tv_constitution_mod));
        attributeTVmodMap.put(Attribute.INTELLIGENCE, (TextView) view.findViewById(R.id.tv_intelligence_mod));
        attributeTVmodMap.put(Attribute.WISDOM, (TextView) view.findViewById(R.id.tv_wisdom_mod));
        attributeTVmodMap.put(Attribute.CHARISMA, (TextView) view.findViewById(R.id.tv_charisma_mod));
    }

}
