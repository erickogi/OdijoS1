package com.erickogi14gmail.odijos1.Main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.erickogi14gmail.odijos1.R;

/**
 * Created by Eric on 9/12/2017.
 */

public class FragmentNewCourse extends Fragment {
    private View view;
    private Spinner mSpinnerLevel;
    private Spinner mSpinnerCourse;

    private String[] levels={"Select Level","Level 1","Level 2","Level 3","Level 4"};
    private String[] course={"Select Course","Course 1","Course 2","Course 3","Course 4"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_new_course,container,false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        mSpinnerCourse=(Spinner)view.findViewById(R.id.spinnerCourse);
        mSpinnerLevel=(Spinner)view.findViewById(R.id.spinnerLevel);

        ArrayAdapter<String> simpleAdapterCourse = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, course);
        mSpinnerCourse.setAdapter(simpleAdapterCourse);

        ArrayAdapter<String> simpleAdapterLevel = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, levels);
        mSpinnerLevel.setAdapter(simpleAdapterLevel);

        return view;
    }
}
