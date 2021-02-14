package com.srinathdev.codemartsrinath;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class personAdapter extends FirebaseRecyclerAdapter<User, personAdapter.personsViewholder> {


    public personAdapter(
            @NonNull FirebaseRecyclerOptions<User> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull personsViewholder holder,
                     int position, @NonNull User model)
    {



        holder.Id.setText(model.getId());
        holder.Name.setText(model.getName());
        holder.mail.setText(model.getEmail());
        holder.position.setText(model.getDep());


    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_emp, parent, false);
        return new personAdapter.personsViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class personsViewholder
            extends RecyclerView.ViewHolder {
        TextView Id,Name,mail,position;
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);
            Name= itemView.findViewById(R.id.txtName);
            Id = itemView.findViewById(R.id.textNo);
            mail = itemView.findViewById(R.id.txt_mail);
            position = itemView.findViewById(R.id.txtdep);




        }
    }
}
