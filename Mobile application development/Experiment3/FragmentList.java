package com.example.experiment3;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


public class FragmentList extends Fragment {

    View rootView;

    ListView listViewCandidates;
    ArrayAdapter<String> candidateNamesAdapter;
    Context context;
    String [] candidates;

    FragmentListner fragmentActionListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_fragment_list,container,false);
        initUI();
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("OrintationChange","CountriesFragment onSaveInstanceState");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!=null){
            fragmentActionListener = (FragmentListner) getActivity();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getString(R.string.app_name)+" Candidates List");
    }

    public void setFragmentActionListener(FragmentListner fragmentActionListener){
        this.fragmentActionListener = fragmentActionListener;
    }

    private void initUI(){
        context  = getContext();
        candidates = getResources().getStringArray(R.array.candidates);
        listViewCandidates = (ListView)rootView.findViewById(R.id.listViewCandidates);

        candidateNamesAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,candidates);
        listViewCandidates.setAdapter(candidateNamesAdapter);

        listViewCandidates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (fragmentActionListener!=null){
                    fragmentActionListener.onCandidateSelected(candidates[i]);
                }
            }
        });
    }
}
