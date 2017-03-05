package com.dndcharactermanager.CharacterChoices.Skill;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dndcharactermanager.DnDCharacter;
import com.dndcharactermanager.R;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillFragment extends Fragment {

    RecyclerView recyclerView;
    SkillAdapter adapter;

    public static SkillFragment newInstance() {
        SkillFragment fragment = new SkillFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_skill, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_skills);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        adapter = new SkillAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private class SkillHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private CheckBox checkBox;
        private Skill skill;

        public SkillHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_list_item_skill);
            checkBox = (CheckBox) itemView.findViewById(R.id.cb_list_item_skill);
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    skill.setProficient(checkBox.isChecked());
                    Log.d("BUTTS", skill + " proficiency updated to " + skill.isProficient());
                }
            });
        }

        public void updateSkill(Skill skill){
            textView.setText(skill.toString());
            this.skill = skill;
        }

    }

    private class SkillAdapter extends RecyclerView.Adapter<SkillHolder>{

        private List<Skill> skillList;
        private CheckBox checkBox;

        public SkillAdapter(){
            skillList = Arrays.asList(Skill.values());
        }

        @Override
        public SkillHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_skill,parent,false);
            return new SkillHolder(view);

        }

        @Override
        public void onBindViewHolder(SkillHolder holder, int position) {
            Skill skill = skillList.get(position);
            holder.updateSkill(skill);
        }

        @Override
        public int getItemCount() {
            return skillList.size();
        }
    }

}
