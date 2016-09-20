package com.florimi.assignment;


import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NoteDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        createAndAddFragment();
    }

    public  static final String NEW_NOTE_EXTRA = "New Note";

    private  void createAndAddFragment(){

        // grab intent and fragment to launch from our main activity list  fragment
        Intent intent = getIntent();
        MainActivity.FragmentToLaunch fragmentToLaunch = (MainActivity.FragmentToLaunch) intent.getSerializableExtra(MainActivity.NOTE_FRAGMENT_TO_LOAD_EXTRA);

        //grabbing our fragment manager and our fragment transaction so that we can add our edit or view fragment dynamically
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //choose the correct fragment to load
        switch (fragmentToLaunch){
            case Edit:
                //create and add note edit fragment to note detail activity if we that's what we want to launch
                NoteEditFragment noteEditFragment = new NoteEditFragment();
                setTitle(R.string.editFragmentTitle);
                fragmentTransaction.add(R.id.note_container, noteEditFragment, "NOTE_EDIT_FRAGMENT");
                break;

            case View:
                //create and add noe view fragment to note detail activity if we that's we want to launch
                NoteViewFragment noteViewFragment = new NoteViewFragment();
                setTitle(R.string.viewFragmentTitle);
                fragmentTransaction.add(R.id.note_container, noteViewFragment, "NOTE_VIEW_FRAGMENT");
                break;
            case CREATE:
                NoteEditFragment noteCreateFragment = new NoteEditFragment();
                setTitle(R.string.createFragmentTitle);

                Bundle bundle = new Bundle();
                bundle.putBoolean(NEW_NOTE_EXTRA,true);
                noteCreateFragment.setArguments(bundle);
                fragmentTransaction.add(R.id.note_container, noteCreateFragment, "NOTE_CREATE_FRAGMENT");
                break;
        }

        //commit out changes to that everything works
        fragmentTransaction.commit();
    }
}
