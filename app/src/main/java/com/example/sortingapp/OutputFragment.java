package com.example.sortingapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class OutputFragment extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.output_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle bundle = getArguments();
        int[] array = new int[100];

        if(bundle != null) {
            try {
                array = bundle.getIntArray(Keystore.KEY_ONE);
            } catch (NullPointerException e) {
            }


            long avgTime = 0;
            int limit = 100;
            int n = array.length;
            int arr[] = new int[n];
            arr = array;

            for (int t = 0; t < limit; t++) {
                int i, j, temp;

                long startTime = System.nanoTime();
                for (i = 0; i < n - 1; i++) {
                    for (j = i + 1; j < n; j++) {
                        if (arr[i] > arr[j]) {
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }
                }
                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                avgTime += timeElapsed;
            }
            TextView textView = getView().findViewById(R.id.tv);

            textView.setText(String.valueOf(array[0]));
        } else {
            TextView textView = getView().findViewById(R.id.tv);

            textView.setText("Processing...");
        }


//        for(int k=0;k<n;k++){
//            System.out.print(arr[k]+" ");
//        }
//        System.out.println();
//        System.out.println("Average time taken by BUBBLE SORT to sort elements after executing 10 times = "+avgTime/10+"\n\n");
//        return avgTime/10;
    }
}
