package com.sjw.linglongmanhua.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.sjw.linglongmanhua.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {


    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_find, container, false);
        ListView listView= (ListView) inflate.findViewById(R.id.listview_test_find);
        List<String> list=new ArrayList<>();
        for (int i = 0; i <100; i++) {
           list.add("aaa"+i);
        }
        ArrayAdapter arrayAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1,list);
        listView.setAdapter(arrayAdapter);
        return inflate;
    }

}
