package com.example.experiment3;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentListner{

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    String selectedCandidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.activity_main_portrait)!= null){
            if(savedInstanceState==null){
                addCandidatesFragment();
            }else{
                addCandidateDescriptionFragment(savedInstanceState.getString("selectedCandidate",null));
            }
        }else if (findViewById(R.id.activity_main_landscape)!=null){
            addCandidatesFragment();
            if(savedInstanceState==null){
                addCandidateDescriptionFragment(R.id.fragmentContainer2,"Monika");
            }else{

                addCandidateDescriptionFragment(R.id.fragmentContainer2,savedInstanceState.getString("selectedCandidate",null));
            }
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("OrintationChange","MainActivity onSaveInstanceState");
        outState.putString("selectedCandidate", selectedCandidate);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("OrintationChange","MainActivity onSaveInstanceState");
        selectedCandidate = savedInstanceState.getString("selectedCandidate","Monika");
    }

    private void addCandidatesFragment(){
        fragmentTransaction=fragmentManager.beginTransaction();

        FragmentList candidateListFragment=new FragmentList();
        candidateListFragment.setFragmentActionListener(this);

        fragmentTransaction.add(R.id.fragmentContainer,candidateListFragment);
        fragmentTransaction.commit();
    }

    private void addCandidateDescriptionFragment(String candidateName){
        fragmentTransaction=fragmentManager.beginTransaction();

        OneFragment candidateDescriptionFragment=new OneFragment();

        Bundle bundle=new Bundle();
        bundle.putString(FragmentListner.KEY_SELECTED_CANDIDATE,candidateName);
        candidateDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragmentContainer,candidateDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void addCandidateDescriptionFragment(int fragmentContainerId, String candidateName){
        fragmentTransaction=fragmentManager.beginTransaction();

        OneFragment candidateDescriptionFragment=new OneFragment();


        Bundle bundle=new Bundle();
        bundle.putString(FragmentListner.KEY_SELECTED_CANDIDATE,candidateName);
        candidateDescriptionFragment.setArguments(bundle);

        fragmentTransaction.replace(fragmentContainerId,candidateDescriptionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onCandidateSelected(String candidate) {
        selectedCandidate = candidate;
        if(findViewById(R.id.activity_main_landscape)==null){
            addCandidateDescriptionFragment(candidate);
        }else {
            addCandidateDescriptionFragment(R.id.fragmentContainer2,candidate);
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation ==Configuration.ORIENTATION_LANDSCAPE){
            Log.i("OrintationChange", "landscape");

        }else if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            Log.i("OrintationChange", "portrait");
        }
    }
}
