package com.example.android.inclassassignment11_vilmariet;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class PieCreator extends AppCompatActivity {
    public EditText bookTitle;
    public EditText pieType;
    public EditText numberFruits;
    public CheckBox latticeArt;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference titleRef = database.getReference("Pie Name");
    private DatabaseReference pieDetails = database.getReference("Pie Details");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_creator);

        bookTitle = findViewById(R.id.edit_text_book_title);
        pieType = findViewById(R.id.pie_type);
        numberFruits = findViewById(R.id.edit_text_number_fruits);
        latticeArt = findViewById(R.id.checkbox_lattice);

        TextView dateText = findViewById(R.id.date);
        setDate(dateText);
    }


    public void setDate(TextView view) {

        //"%tc" = Date and time formatted with “%ta %tb %td %tT %tZ %tY” e.g. “Fri Feb 17 07:45:42 PST 2017“

        String dateMessage = String.format("%tc", new Date());
        view.setText(dateMessage);
    }


    public void findRecipe(View view) {
        String pieTypeSubmission = pieType.getText().toString();
        int numberFruitsSubmission = Integer.parseInt(numberFruits.getText().toString());
        boolean hasLattice = latticeArt.isChecked();

        pieDetails.push().setValue(new Pie(pieTypeSubmission, numberFruitsSubmission, hasLattice));


        Toast toast = Toast.makeText(this, "Looking for Recipe...", Toast.LENGTH_SHORT);

        View toastyView = toast.getView();
        toast.getView().setPadding(25, 20, 25, 20);
        toastyView.setBackgroundColor(Color.parseColor("#535559"));
        toast.setGravity(Gravity.CENTER, 0, 550);
        toast.show();


    }

    public void submit(View view) {
        String titleSubmission = bookTitle.getText().toString();
        titleRef.setValue(titleSubmission);
    }
}
