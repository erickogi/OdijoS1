package com.erickogi14gmail.odijos1.Receipt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.erickogi14gmail.odijos1.R;

public class ReceiptActivity extends AppCompatActivity {
    public static Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        fragment = new FragmentNewReceipt();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment, "fragmentNewReceipt").commit();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
