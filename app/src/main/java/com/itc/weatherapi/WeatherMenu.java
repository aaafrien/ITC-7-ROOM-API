package com.itc.weatherapi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.itc.weatherapi.database.Dao;
import com.itc.weatherapi.database.Database;
import com.itc.weatherapi.database.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherMenu extends Fragment {

    int page=10;
    RecyclerView recyclerView;
    LinearLayoutManager layout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeatherMenu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeatherMenu.
     */
    // TODO: Rename and change types and number of parameters
    public static WeatherMenu newInstance(String param1, String param2) {
        WeatherMenu fragment = new WeatherMenu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Database databaseROOM = Database.getInstance(getActivity());
        Dao dao = databaseROOM.dao();
        RecyclerView.Adapter adapter;

        View view = inflater.inflate(R.layout.fragment_weather_menu, container, false);
        List<Entity> entities = dao.getAllData();

        ArrayList<Entity> data = new ArrayList<>();

        for (int i = 0; i < page; i++) {
            data.add(entities.get(i));
        }

        recyclerView = view.findViewById(R.id.rc_menu);
        layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);
        adapter = new Adapter(getActivity(), data);
        recyclerView.setAdapter(adapter);

        return view;
    }
}