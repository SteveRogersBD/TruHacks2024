package com.example.bot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder>{

    ArrayList<Message> list;

    public ChatAdapter(ArrayList<Message> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = list.get(position);
        if(message.getSentBy().equals(Message.SENT_BY_ME)){
            holder.left_lo.setVisibility(View.GONE);
            holder.right_lo.setVisibility(View.VISIBLE);
            holder.right_chat.setText(message.getMessage());
        }
        else{
            holder.right_lo.setVisibility(View.GONE);
            holder.left_lo.setVisibility(View.VISIBLE);
            holder.left_chat.setText(message.getMessage());

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout left_lo,right_lo;
        TextView left_chat,right_chat;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            left_lo=itemView.findViewById(R.id.left_chat_view);
            left_chat=itemView.findViewById(R.id.left_chat_tv);
            right_lo=itemView.findViewById(R.id.right_chat_view);
            right_chat=itemView.findViewById(R.id.right_chat_tv);
        }
    }
}
