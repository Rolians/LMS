package com.example.adity.loginscreen;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by adity on 24/11/2016.
 */

public class Recycler_View_Adapter extends RecyclerView.Adapter<View_Holder> {

    public static List<Data> list = Collections.emptyList();
        Context context;

public Recycler_View_Adapter(List<Data> list, Context context) {
    Recycler_View_Adapter.list = list;
        this.context = context;

        }

@Override
public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        View_Holder holder = new View_Holder(v);

        return holder;

        }

@Override
public void onBindViewHolder(View_Holder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
       holder.title.setText(list.get(position).title);
        holder.description.setText(list.get(position).description);
    holder.b_id.setText(list.get(position).b_id);
    Picasso.with(context).load("https://covers.openlibrary.org/b/isbn/" + list.get(position).isbn + "-L.jpg?default=false").error(R.drawable.noimage).fit().placeholder(R.drawable.progress_animation).into(holder.imageView);

                animate(holder);
MainPage.progress.dismiss();


        }

@Override
public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
        }

@Override
public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        }

// Insert a new item to the RecyclerView on a predefined position
public void insert(int position, Data data) {
        list.add(position, data);
        notifyItemInserted(position);
        }

// Remove a RecyclerView item containing a specified Data object
public void remove(Data data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
        }

    public void clear() {
        int size = list.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                list.remove(0);
            }

            this.notifyItemRangeRemoved(0, size);
        }
    }
        public void animate(RecyclerView.ViewHolder viewHolder) {
                //final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.accelerate);
                //viewHolder.itemView.setAnimation(animAnticipateOvershoot);


        }

}
