package com.emrebaglayici.myapplication.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.emrebaglayici.myapplication.activity.DetailActivity;
import com.emrebaglayici.myapplication.model.Model;
import com.emrebaglayici.myapplication.adapter.MyAdapter;
import com.emrebaglayici.myapplication.R;

import java.util.ArrayList;

public class FragmentItem extends Fragment {

    MyAdapter myAdapter;
    ArrayList<Model> modelArrayList;
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        modelArrayList =new ArrayList<>();
        listView = view.findViewById(R.id.listView);

        Resources resources =getResources();
        String[] address = resources.getStringArray(R.array.Address);
        String[] companyName = resources.getStringArray(R.array.CompanyName);
        String[] subject = resources.getStringArray(R.array.Subject);
        String[] message = resources.getStringArray(R.array.Message);

        for (int i = 0; i <companyName.length ; i++) {
            modelArrayList.add(new Model(companyName[i], subject[i], message[i]));
        }
        myAdapter = new MyAdapter(modelArrayList, getContext());
        listView.setAdapter(myAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle bundle = new Bundle();
                bundle.putString("subject",subject[i]);
                bundle.putString("message", message[i]);
                bundle.putString("address", address[i]);

                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,detailFragment).commit();
            }
        });

    }
}
