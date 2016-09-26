package qianfeng.fragment3_getargument_application;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class RightFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.right_fg_layout, container, false);
        TextView content = (TextView) view.findViewById(R.id.content);
        //获取Fragment实例所携带的参数
        Bundle bundle = getArguments();
        String title = bundle.getString("title");
        String contentStr = getContentText(title);
        content.setText(contentStr);
        return view;
    }

    private String getContentText(String title) {
        StringBuffer result = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getActivity().getAssets().open(title)));
            String str;
            while ((str = br.readLine()) != null) {
                result.append(str);
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getContent(String title) {
        StringBuffer buffer = new StringBuffer();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getActivity().getAssets().open(title)));
            String str = "";
            while ((str = br.readLine()) != null) {
                buffer.append(str);
            }

            return buffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
