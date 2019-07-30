package sg.edu.rp.c346.demodynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1,spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);

        //initialise the arraylist
        alNumbers = new ArrayList<>();

        //method 1: add item(s) directly into the ArrayList and the item(s) will be reflected in the ListView
//        alNumbers.add("2");
//        alNumbers.add("4");
//        alNumbers.add("6");

        //method 2: load the items from the string array into the ArrayList
        //get the string-array adn stores as an Array
        //String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

        //convert array to list and add to the ArrayList
        //alNumbers.addAll(Arrays.asList(strNumbers));

//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int pos = spn1.getSelectedItemPosition();
//                alNumbers.clear();
//
//
//                if(pos == 0){
//                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
//                    alNumbers.addAll(Arrays.asList(strNumbers));
//                }
//                else{
//                    String[] strOdd = getResources().getStringArray(R.array.odd_numbers);
//                    alNumbers.addAll(Arrays.asList(strOdd));
//                }
//            }
//        });


        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        int pos = spn1.getSelectedItemPosition();
                        alNumbers.clear();
                        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        aaNumbers.notifyDataSetChanged();
                        spn2.setSelection(2);
                        break;
                    case 1:
                        pos = spn1.getSelectedItemPosition();
                        alNumbers.clear();
                        String[] strOdd = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(strOdd));
                        aaNumbers.notifyDataSetChanged();
                        spn2.setSelection(1);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,alNumbers);

        //bind the ArrayAdapter to the spinner
        spn2.setAdapter(aaNumbers);
    }
}
