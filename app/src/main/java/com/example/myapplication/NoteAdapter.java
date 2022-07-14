package com.example.myapplication;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<NoteModel> notes = new ArrayList<>();

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }

    public void addNote(NoteModel noteModel) {
        this.notes.add(0, noteModel);
        notifyItemInserted(0);
    }

    public void setNotes(List<NoteModel> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }


    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription, tvDate;
        ImageView img;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title_item);
            tvDescription = itemView.findViewById(R.id.description_item);
            tvDate = itemView.findViewById(R.id.added_time);
            img = itemView.findViewById(R.id.img_item);

        }

        public void bind(NoteModel noteModel) {
            tvTitle.setText(noteModel.getTitle());
            tvDescription.setText(noteModel.getDescription());
            tvDate.setText(getDate(noteModel.getCreatedAt()));

            img.setImageURI(Uri.parse(noteModel.getImgUrl()));
        }
        private String getDate(long time) {
            DateFormat formatter = new SimpleDateFormat("HH:mm | \ndd MMM", Locale.getDefault());
            return formatter.format(time);
        }
    }
}
