package com.erickogi14gmail.odijos1.Receipt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erickogi14gmail.odijos1.R;

/**
 * Created by Eric on 9/15/2017.
 */

public class FragmentReceiptList extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_receipt_list,container,false);
        return view;
    }
}
