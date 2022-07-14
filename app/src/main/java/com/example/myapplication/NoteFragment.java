package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.databinding.FragmentNoteBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NoteFragment extends Fragment {

    private NoteAdapter adapter;
    private List<NoteModel> list = new ArrayList<>();
    private FragmentNoteBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNoteBinding.inflate(inflater, container, false);

        adapter = new NoteAdapter();

        /*list.add(new NoteModel("12312","1234123", System.currentTimeMillis()));
        list.add(new NoteModel("12312","1234123", System.currentTimeMillis()));
        list.add(new NoteModel("12312","1234123", System.currentTimeMillis()));
        list.add(new NoteModel("12312","1234123", System.currentTimeMillis()));
        list.add(new NoteModel("12312","1234123", System.currentTimeMillis()));
        list.add(new NoteModel("12312","1234123", System.currentTimeMillis()));
        list.add(new NoteModel("12312","1234123", System.currentTimeMillis()));
        list.add(new NoteModel("12312","1234123", System.currentTimeMillis()));
        list.add(new NoteModel("12312","1234123", System.currentTimeMillis()));
        list.add(new NoteModel("12312","1234123", System.currentTimeMillis()));
        list.add(new NoteModel("12312","1234123", System.currentTimeMillis()));
        list.add(new NoteModel("12312","1234123", System.currentTimeMillis()));
*/
        adapter.setNotes(list);
        initViews();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);

        listenDataFromForm();

        return binding.getRoot();
    }

    private void initViews() {
        binding.fab.setOnClickListener(v->{
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new FormFragment());
            transaction.addToBackStack("FormFragment");
            transaction.commit();
        });
    }
    private void listenDataFromForm(){
        getActivity().getSupportFragmentManager().setFragmentResultListener("form", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String title = result.getString("title");
                String desc = result.getString("description");
                String imgUri = result.getString("img");
                adapter.addNote(new NoteModel(title, desc, imgUri, System.currentTimeMillis()));
            }
        });
    }
}