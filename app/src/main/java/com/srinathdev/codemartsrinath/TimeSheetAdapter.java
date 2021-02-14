package com.srinathdev.codemartsrinath;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class TimeSheetAdapter extends FirebaseRecyclerAdapter<TimeSheet, TimeSheetAdapter.personsViewholder> {

    public TimeSheetAdapter(
            @NonNull FirebaseRecyclerOptions<TimeSheet> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull TimeSheetAdapter.personsViewholder holder,
                     int position, @NonNull TimeSheet model)
    {



        holder.date.setText(model.getDate());
        holder.task.setText(model.getTask());
        holder.des.setText(model.getDes());
        holder.hours.setText(model.getHours());


    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public TimeSheetAdapter.personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.time_sheet_item, parent, false);
        return new TimeSheetAdapter.personsViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class personsViewholder
            extends RecyclerView.ViewHolder {
        TextView date,task,des,hours;
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);
            date= itemView.findViewById(R.id.date);
            task = itemView.findViewById(R.id.firstname);
            des = itemView.findViewById(R.id.lastname);
            hours = itemView.findViewById(R.id.age);


        }
    }
}
