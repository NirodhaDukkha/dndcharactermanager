package com.dndcharactermanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class AttributeFragment extends Fragment {

    DnDCharacter dnDCharacter;
    TextView pointBuyTV;
    Map<DnDCharacter.Attributes, Button> attributeBTaddMap;
    Map<DnDCharacter.Attributes, Button> attributeBTsubMap;
    Map<DnDCharacter.Attributes, TextView> attributeTVvalueMap;
    Map<DnDCharacter.Attributes, TextView> attributeTVmodMap;

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


        for(final DnDCharacter.Attributes a : DnDCharacter.Attributes.values()){

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

//        Gson gson = new Gson();
//        String jsonString = gson.toJson(dnDCharacter);
//        Log.i("BUTTS","export to json: " + jsonString);

        return view;
    }

    private void addButtonPress(DnDCharacter.Attributes a) {
        int pointsLeft = dnDCharacter.getAttributePointBuy();
        int attributeValue = dnDCharacter.getAttributeMap().get(a);

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
        dnDCharacter.getAttributeMap().put(a, attributeValue);

        pointBuyTV.setText((Integer.toString(pointsLeft)));

        attributeTVvalueMap.get(a).setText(Integer.toString(attributeValue));
        attributeTVmodMap.get(a).setText(Integer.toString(DnDCharacter.getModifier(attributeValue)));
    }

    private void subButtonPress(DnDCharacter.Attributes a) {
        int pointsLeft = dnDCharacter.getAttributePointBuy();
        int attributeValue = dnDCharacter.getAttributeMap().get(a);

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
        dnDCharacter.getAttributeMap().put(a, attributeValue);

        pointBuyTV.setText((Integer.toString(pointsLeft)));

        attributeTVvalueMap.get(a).setText(Integer.toString(attributeValue));
        attributeTVmodMap.get(a).setText(Integer.toString(DnDCharacter.getModifier(attributeValue)));
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void wireAttributeWidgets(View view){
        attributeBTaddMap.put(DnDCharacter.Attributes.STRENGTH, (Button) view.findViewById(R.id.bt_strength_add));
        attributeBTaddMap.put(DnDCharacter.Attributes.DEXTERITY, (Button) view.findViewById(R.id.bt_dexterity_add));
        attributeBTaddMap.put(DnDCharacter.Attributes.CONSTITUTION, (Button) view.findViewById(R.id.bt_constitution_add));
        attributeBTaddMap.put(DnDCharacter.Attributes.INTELLIGENCE, (Button) view.findViewById(R.id.bt_intelligence_add));
        attributeBTaddMap.put(DnDCharacter.Attributes.WISDOM, (Button) view.findViewById(R.id.bt_wisdom_add));
        attributeBTaddMap.put(DnDCharacter.Attributes.CHARISMA, (Button) view.findViewById(R.id.bt_charisma_add));

        attributeBTsubMap.put(DnDCharacter.Attributes.STRENGTH, (Button) view.findViewById(R.id.bt_strength_sub));
        attributeBTsubMap.put(DnDCharacter.Attributes.DEXTERITY, (Button) view.findViewById(R.id.bt_dexterity_sub));
        attributeBTsubMap.put(DnDCharacter.Attributes.CONSTITUTION, (Button) view.findViewById(R.id.bt_constitution_sub));
        attributeBTsubMap.put(DnDCharacter.Attributes.INTELLIGENCE, (Button) view.findViewById(R.id.bt_intelligence_sub));
        attributeBTsubMap.put(DnDCharacter.Attributes.WISDOM, (Button) view.findViewById(R.id.bt_wisdom_sub));
        attributeBTsubMap.put(DnDCharacter.Attributes.CHARISMA, (Button) view.findViewById(R.id.bt_charisma_sub));

        attributeTVvalueMap.put(DnDCharacter.Attributes.STRENGTH, (TextView) view.findViewById(R.id.tv_strength_value));
        attributeTVvalueMap.put(DnDCharacter.Attributes.DEXTERITY, (TextView) view.findViewById(R.id.tv_dexterity_value));
        attributeTVvalueMap.put(DnDCharacter.Attributes.CONSTITUTION, (TextView) view.findViewById(R.id.tv_constitution_value));
        attributeTVvalueMap.put(DnDCharacter.Attributes.INTELLIGENCE, (TextView) view.findViewById(R.id.tv_intelligence_value));
        attributeTVvalueMap.put(DnDCharacter.Attributes.WISDOM, (TextView) view.findViewById(R.id.tv_wisdom_value));
        attributeTVvalueMap.put(DnDCharacter.Attributes.CHARISMA, (TextView) view.findViewById(R.id.tv_charisma_value));

        attributeTVmodMap.put(DnDCharacter.Attributes.STRENGTH, (TextView) view.findViewById(R.id.tv_strength_mod));
        attributeTVmodMap.put(DnDCharacter.Attributes.DEXTERITY, (TextView) view.findViewById(R.id.tv_dexterity_mod));
        attributeTVmodMap.put(DnDCharacter.Attributes.CONSTITUTION, (TextView) view.findViewById(R.id.tv_constitution_mod));
        attributeTVmodMap.put(DnDCharacter.Attributes.INTELLIGENCE, (TextView) view.findViewById(R.id.tv_intelligence_mod));
        attributeTVmodMap.put(DnDCharacter.Attributes.WISDOM, (TextView) view.findViewById(R.id.tv_wisdom_mod));
        attributeTVmodMap.put(DnDCharacter.Attributes.CHARISMA, (TextView) view.findViewById(R.id.tv_charisma_mod));
    }

}
