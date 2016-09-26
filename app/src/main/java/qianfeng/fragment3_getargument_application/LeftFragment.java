package qianfeng.fragment3_getargument_application;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class LeftFragment extends Fragment {

    private List<String> list;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        list.add("day1.txt");
        list.add("day2.txt");
        list.add("day3.txt");
        list.add("day4.txt");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.left_fg_layout, container, false);
        ListView lv = (ListView) view.findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String title = list.get(position);
                Log.d("google-my:", "onItemClick: title:--->" + title);

                FragmentManager manager = getFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                RightFragment fragment = new RightFragment();

                // 使fragment实例携带参数
                Bundle args = new Bundle();
                args.putString("title",title);
                fragment.setArguments(args);
                fragmentTransaction.replace(R.id.ll, fragment);
                fragmentTransaction.commit();

            }
        });

        return view;
    }
}
