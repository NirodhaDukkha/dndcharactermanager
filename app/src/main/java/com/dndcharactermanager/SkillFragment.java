package com.dndcharactermanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillFragment extends Fragment {

    Button updateButton;

    public static SkillFragment newInstance() {
        SkillFragment fragment = new SkillFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_charclass, container, false);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.skill_placeholder,new SkillListFragment()).commit();

        //UPDATE CHARACTER WITH CLASS,LEVEL,RACE
        updateButton = (Button) view.findViewById(R.id.bt_update);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DnDCharacter.updateCharacter();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
