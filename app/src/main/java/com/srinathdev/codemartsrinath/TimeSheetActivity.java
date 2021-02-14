package com.srinathdev.codemartsrinath;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Random;

public class TimeSheetActivity extends AppCompatActivity {

    Button UpdateButton;
    DatePicker picker;
    LinearLayout rootLayout;
    DatabaseReference users;

    private RecyclerView recyclerView;
    TimeSheetAdapter adapter;
    DatabaseReference mbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_sheet);
        UpdateButton = findViewById(R.id.btn_update);
        rootLayout = findViewById(R.id.roo);

        mbase = FirebaseDatabase.getInstance().getReference().child("EmployeeInformation").child(FirebaseAuth.getInstance().getUid()).child("task");

        recyclerView = findViewById(R.id.recyclertime);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        FirebaseRecyclerOptions<TimeSheet> options
                = new FirebaseRecyclerOptions.Builder<TimeSheet>()
                .setQuery(mbase, TimeSheet.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new TimeSheetAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);

        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showUpdateDialog();

            }
        });
    }

    private void showUpdateDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Update Time Sheet");


        LayoutInflater inflater = LayoutInflater.from(this);
        View register_layout = inflater.inflate(R.layout.timesheet_update,null);

        final MaterialEditText task = register_layout.findViewById(R.id.edttask);
        final MaterialEditText Des = register_layout.findViewById(R.id.edtDes);
        final MaterialEditText Hours = register_layout.findViewById(R.id.edtHours);
        Random o = new Random();

      picker=(DatePicker)register_layout.findViewById(R.id.datePicker);
        dialog.setView(register_layout);

        dialog.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();

                if (TextUtils.isEmpty(task.getText().toString()))
                {

                    Snackbar.make(rootLayout,"Please Task",Snackbar.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(Des.getText().toString()))
                {

                    Snackbar.make(rootLayout,"Please enter Description",Snackbar.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(Hours.getText().toString())) {

                    Snackbar.make(rootLayout, "Please enter Hours", Snackbar.LENGTH_SHORT).show();
                    return;

                }

                                TimeSheet up = new TimeSheet();
                                up.setTask(task.getText().toString());
                                up.setDes(Des.getText().toString());
                                up.setDate(getCurrentDate());
                                up.setHours(Hours.getText().toString());


                DatabaseReference upd = FirebaseDatabase.getInstance().getReference(Common.user_tb1);

                upd.child(FirebaseAuth.getInstance().getUid())
                                        .child("task")
                                        .child(String.valueOf(o.nextInt(1000)))
                                        .setValue(up)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Snackbar.make(  rootLayout,"Update TimeSheet Success",Snackbar.LENGTH_SHORT).show();




                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Snackbar.make(rootLayout,"Failed"+e.getMessage(),Snackbar.LENGTH_SHORT).show();
                                            }
                                        });




            }
        });

        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                dialogInterface.dismiss();

            }
        });

        dialog.show();




    }

    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();;
        builder.append((picker.getMonth() + 1)+"/");//month is 0 based
        builder.append(picker.getDayOfMonth()+"/");
        builder.append(picker.getYear());
        return builder.toString();
    }

    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }


}