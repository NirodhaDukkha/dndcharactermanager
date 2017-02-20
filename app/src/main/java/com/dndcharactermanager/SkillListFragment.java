package com.dndcharactermanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SkillListFragment extends Fragment {

    Button updateButton;
    DnDCharacter dnDCharacter;

    public SkillListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_skill_list, container, false);

        dnDCharacter = DnDCharacter.getDnDCharacter();

        return view;
    }

}
