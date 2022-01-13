package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.MediaMetadata;
import android.os.Bundle;

import com.example.gridview.adapter.CustomAdapter;
import com.example.gridview.madel.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        for(int i = 0; i < 30; i++){
            members.add(new Member("Shodiyor "+ i, "Shodiyor "+i));
        }
        return members;
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(context,3));

    }
}