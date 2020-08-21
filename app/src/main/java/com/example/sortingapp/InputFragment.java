package com.example.sortingapp;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InputFragment extends Fragment implements View.OnClickListener {

    public InputFragment() {

    }
    private DataListener parentActivity;

    public interface DataListener {
        void listen(int[] values);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.parentActivity = (DataListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.input_fragment, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    int[] transferData = new int[100];
    @Override
    public void onStart() {
        super.onStart();

        Button button = getView().findViewById(R.id.bt_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = getView().findViewById(R.id.et_input);
                String value = editText.getText().toString();

                String[] inputDigit = value.split(",");
                int size = inputDigit.length;
                int[] no = new int[size];

                for(int i=0; i<size; i++) {
                    no[i] = Integer.parseInt(inputDigit[i]);
                }
                parentActivity.listen(no);
                transferData = no;
            }
        });
    }

    @Override
    public void onClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();

//        switch(view.getId()){
//            case R.id.bubbleSort:
//                if(checked)
//                    //parentActivity.listen(transferData);
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
