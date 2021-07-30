package com.example.experiment3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class OneFragment extends Fragment {
    private static final String COMMON_TAG = "CombinedLifeCycle";
    private static final String FRAGMENT_NAME = OneFragment.class.getSimpleName();

    private static final String TAG = COMMON_TAG;

    View rootView;
    TextView textViewCandidateDescription;


    String candidateName;
    String candidateDescription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_one_fragment,container,false);
        initUI();
        return rootView;
    }

    private void initUI(){
        textViewCandidateDescription = (TextView)rootView.findViewById(R.id.textViewCandidateDescription);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("OrintationChange","CountryDescriptionFragment onSaveInstanceState");
        outState.putString("selectedCandidate",candidateName);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!=null){
            candidateName = savedInstanceState.getString("selectedCandidate",candidateName);
            candidateDescription = getString(getStringId(candidateName));
            textViewCandidateDescription.setText(candidateDescription);

        }else {
            Bundle bundle = getArguments();
            candidateName = bundle.getString(FragmentListner.KEY_SELECTED_CANDIDATE,"Monika");
            candidateDescription = getString(getStringId(candidateName));
            textViewCandidateDescription.setText(candidateDescription);

        }


    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(candidateName);

        textViewCandidateDescription.setText(candidateDescription);
    }

    private int getStringId(String candidateName){
        if(candidateName.equals("Ambika")){
            return R.string.Mamatha;
        }else if(candidateName.equals("Chaitanya")){
            return R.string.Monika;
        }else if(candidateName.equals("anjali")){
            return R.string.Neha;
        }else if(candidateName.equals("Akshitha")) {
            return R.string.Anusha;
        }else {
            return R.string.Monika;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
