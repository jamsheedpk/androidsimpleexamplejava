package com.intelliwires.tabviewlist;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;

import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

//    private EditText editname, editdob, editemail, editphone, editaddress;
//    Button save, clear, button;
    SQLiteDatabase sqlitedb;
//    String name, dob, email, phone, address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       sqlitedb = openOrCreateDatabase("Formdb", MODE_PRIVATE,null);
       sqlitedb.execSQL("CREATE TABLE IF NOT EXISTS Registration(empid INTEGER PRIMARY KEY AUTOINCREMENT,empname VARCHAR(255),dob DATE,email VARCHAR(255),phone VARCHAR(255),address VARCHAR(255))");


        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);

//        editname = (EditText) findViewById(R.id.editname);
//        editemail = (EditText) findViewById(R.id.editemail);
//        editphone = (EditText) findViewById(R.id.editphone);
//        editaddress = (EditText) findViewById(R.id.editaddress);
//       // button = (Button) findViewById(R.id.button);
//        save = (Button) findViewById(R.id.save);
//        clear = (Button) findViewById(R.id.clear);
//
//        button =(Button) findViewById(R.id.datebutton);


        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Sport"));
        tabLayout.addTab(tabLayout.newTab().setText("Movie"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);



//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                // TODO Auto-generated method stub
//                String value=adapterlistView.getItem(position);
//                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
//
//            }
//        });

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DialogFragment datePicker = new DatePickerFragment();
//                datePicker.show(getSupportFragmentManager(), "date picker");
//            }
//        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Toast.makeText(this, "message" , Toast.LENGTH_LONG).show();

    }

//    public boolean validateuname() {
//        name = editname.getText().toString().trim();
//        int count = name.length();
//        if (name.isEmpty()) {
//            editname.setError("Field cannot be empty");
//            return false;
//        } else if (count < 10) {
//            editname.setError("Username is short");
//            return false;
//        } else {
//            editname.setError(null);
//            return true;
//        }
//    }

//    @Override
//    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR, year);
//        c.set(Calendar.MONTH, month);
//        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
//
//        TextView textView = (TextView) findViewById(R.id.textView);
//        textView.setText(currentDateString);
//
//    }
//
//    public boolean validateemail() {
//        email = editemail.getText().toString().trim();
//
//        if (email.isEmpty()) {
//            editemail.setError("Field cannot be empty");
//            return false;
//        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            editemail.setError("Username is short");
//            return false;
//        } else {
//            editemail.setError(null);
//            return true;
//        }
//    }

//    public boolean validatephone() {
//        phone = editphone.getText().toString().trim();
//
//        if (phone.isEmpty()) {
//            editphone.setError("Field cannot be empty");
//            return false;
//        } else if (!Patterns.PHONE.matcher(phone).matches()) {
//            editphone.setError("Enter valid email address");
//            return false;
//        } else {
//            editphone.setError(null);
//            return true;
//        }
//    }
//
//    public boolean validateaddress() {
//        address = editaddress.getText().toString().trim();
//
//        if (address.isEmpty()) {
//            editaddress.setError("Field cannot be empty");
//            return false;
//        } else if (address.length() < 10) {
//            editaddress.setError("Username is short");
//            return false;
//        } else {
//            editaddress.setError(null);
//            return true;
//        }
//    }

//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.save) {
//
//            if (validateuname() && validateemail() && validatephone() && validatephone() && validateaddress()) {
//
//                sqlitedb.execSQL("Insert Into Registration(empname,dob,email,phone,address)VALUES('" + name + "','" + dob + "','" + email + "','" + phone + "','" + address + "')");
//                Toast.makeText(this, "Successfully inserted", Toast.LENGTH_SHORT).show();
//
//
//            }
//        }
//        else if (v.getId() == R.id.clear) {
//
//        }
//
//        }
//
//    public void onClickDate(View v) {
//        DialogFragment datePicker = new DatePickerFragment();
//        datePicker.show(getSupportFragmentManager(), "date picker");
//    }



//    @Override
//    public void onItemClick(AdapterView<?>adapterView, View view, int position, long id) {
//        String value=adapterlistView.getItem(position);
//        Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
//
//    }

}


