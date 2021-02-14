package com.srinathdev.codemartsrinath;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MaterialAdapter extends FirebaseRecyclerAdapter<Material, MaterialAdapter.personsViewholder> {

    public MaterialAdapter(
            @NonNull FirebaseRecyclerOptions<Material> options)
    {
        super(options);
    }


    @Override
    protected void
    onBindViewHolder(@NonNull MaterialAdapter.personsViewholder holder,
                     int position, @NonNull Material model)
    {


        holder.ProjectName.setText(model.getName());
        holder.clientName.setText(model.getClientname());
        holder.modules.setText(model.getModules());
        holder.due.setText(model.getTime());
        holder.des.setText(model.getDes());


    }


    @NonNull
    @Override
    public MaterialAdapter.personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_material_item, parent, false);
        return new MaterialAdapter.personsViewholder(view);
    }


    class personsViewholder
            extends RecyclerView.ViewHolder {
        TextView ProjectName,clientName,modules,due,des;
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);

            ProjectName = itemView.findViewById(R.id.projectName);
            clientName= itemView.findViewById(R.id.date);
            modules = itemView.findViewById(R.id.firstname);
            due = itemView.findViewById(R.id.lastname);
            des = itemView.findViewById(R.id.age);

        }
    }
}
