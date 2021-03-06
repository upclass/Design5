package com.jash.design5;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment getInstance(int pager) {
        ListFragment fragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pager", pager);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int pager = getArguments().getInt("pager");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.format(Locale.getDefault(), "pager %02d, item %03d", pager, i));
        }
        MyAdapter adapter = new MyAdapter(getContext(), list);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_list);
        recyclerView.setAdapter(adapter);
    }
}
