package com.intelliwires.tabviewlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private EditText editname, editemail, editphone, editaddress;
    Button save, clear, button;
    SQLiteDatabase sqlitedb;
    String name, dob, email, phone, address;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;

//    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        editname = (EditText) view.findViewById(R.id.editname);
        editemail = (EditText) view.findViewById(R.id.editemail);
        editphone = (EditText) view.findViewById(R.id.editphone);
        editaddress = (EditText) view.findViewById(R.id.editaddress);
        save = (Button) view.findViewById(R.id.save);
        clear = (Button) view.findViewById(R.id.clear);

        button = (Button) view.findViewById(R.id.datebutton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Clicked button",Toast.LENGTH_LONG).show();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateuname() && validateemail() && validatephone() && validatephone() && validateaddress()) {

                    sqlitedb.execSQL("Insert Into Registration(empname,dob,email,phone,address)VALUES('" + name + "','" + dob + "','" + email + "','" + phone + "','" + address + "')");
                    Toast.makeText(getActivity(),"Successfully inserted",Toast.LENGTH_LONG).show();
                }

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Data removed",Toast.LENGTH_LONG).show();
            }
        });
              return view;
    }

    public boolean validateuname() {
        name = editname.getText().toString().trim();
        int count = name.length();
        if (name.isEmpty()) {
            editname.setError("Field cannot be empty");
            return false;
        } else if (count < 10) {
            editname.setError("Username is short");
            return false;
        } else {
            editname.setError(null);
            return true;
        }
    }
    public boolean validateemail() {
        email = editemail.getText().toString().trim();

        if (email.isEmpty()) {
            editemail.setError("Field cannot be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editemail.setError("Username is short");
            return false;
        } else {
            editemail.setError(null);
            return true;
        }
    }
    public boolean validatephone() {
        phone = editphone.getText().toString().trim();

        if (phone.isEmpty()) {
            editphone.setError("Field cannot be empty");
            return false;
        } else if (!Patterns.PHONE.matcher(phone).matches()) {
            editphone.setError("Enter valid email address");
            return false;
        } else {
            editphone.setError(null);
            return true;
        }
    }
    public boolean validateaddress() {
        address = editaddress.getText().toString().trim();

        if (address.isEmpty()) {
            editaddress.setError("Field cannot be empty");
            return false;
        } else if (address.length() < 10) {
            editaddress.setError("Username is short");
            return false;
        } else {
            editaddress.setError(null);
            return true;
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.save) {

            if (validateuname() && validateemail() && validatephone() && validatephone() && validateaddress()) {

                sqlitedb.execSQL("Insert Into Registration(empname,dob,email,phone,address)VALUES('" + name + "','" + dob + "','" + email + "','" + phone + "','" + address + "')");
               //  Toast.makeText(this, "Successfully inserted", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void onClickSavebutton(View v) {
        System.out.println("Click onClickSavebutton");
        //Toast.makeText(this, "message" , Toast.LENGTH_LONG).show();
    }
//    public void onClickDate(View v) {
//        System.out.println("Click here");
//        Toast.makeText(getActivity(), "message" , Toast.LENGTH_LONG).show();
//       // DialogFragment datePicker = new DatePickerFragment();
//       // datePicker.show(getActivity().getSupportFragmentManager(), "date picker");
//    }

//    @Override
//    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR, year);
//        c.set(Calendar.MONTH, month);
//        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
//
//        TextView textView = (TextView) view.findViewById(R.id.textView);
//        textView.setText(currentDateString);
//    }
}
