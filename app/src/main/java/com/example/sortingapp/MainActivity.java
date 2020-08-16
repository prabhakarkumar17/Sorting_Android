package com.example.sortingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements InputFragment.DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        InputFragment inputFragment = new InputFragment();
        OutputFragment outputFragment = new OutputFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.input_fragment_container, inputFragment);
        fragmentTransaction.add(R.id.output_fragment_container, outputFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void listen(int[] value) {
        OutputFragment outputFragment = new OutputFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putIntArray(Keystore.KEY_ONE, value);
        outputFragment.setArguments(bundle);
        fragmentTransaction.commit();
    }
}