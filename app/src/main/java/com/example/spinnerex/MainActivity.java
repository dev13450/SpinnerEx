package com.example.spinnerex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.EditText;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editText);
        int price;
        //hello

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this,R.array.departure, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinnerA = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapterA =  ArrayAdapter.createFromResource(this,R.array.arrival, android.R.layout.simple_spinner_item);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerA.setAdapter(adapterA);
        spinnerA.setOnItemSelectedListener(this);

        String Text = spinner.getSelectedItem().toString();

        price = parseInt(editText.toString()) * 50;
        textView.setText(price);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
