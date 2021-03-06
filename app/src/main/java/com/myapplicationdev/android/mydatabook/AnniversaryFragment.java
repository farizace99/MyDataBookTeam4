package com.myapplicationdev.android.mydatabook;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnniversaryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnniversaryFragment extends Fragment {
    Button btnEdit;
    TextView textView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnniversaryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnniversaryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnniversaryFragment newInstance(String param1, String param2) {
        AnniversaryFragment fragment = new AnniversaryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_anniversary, container, false);
        btnEdit = view.findViewById(R.id.btnEditAnni);
        textView = view.findViewById(R.id.tvAnni);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(false);

                builder.setTitle("Edit Anniversary");

                // Create TextView
                final EditText input = new EditText (getActivity());
                input.setText(textView.getText());
                builder.setView(input);

                SharedPreferences prefAnni = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor prefEditAnni = prefAnni.edit();
                prefEditAnni.putString("textAnni",textView.getText().toString());
                prefEditAnni.commit();

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        textView.setText(input.getText());
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });
                builder.show();
            }
        });
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefsAnni = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String strText = prefsAnni.getString("textAnni", "");
        textView.setText(strText);
    }

    @Override
    public void onPause() {
        super.onPause();
        //Get the user input and store in a variable called strName
        String strText = textView.getText().toString();
        SharedPreferences prefAnni = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor prefEditAnni = prefAnni.edit();
        prefEditAnni.putString("textAnni", strText);
        prefEditAnni.commit();
    }
}