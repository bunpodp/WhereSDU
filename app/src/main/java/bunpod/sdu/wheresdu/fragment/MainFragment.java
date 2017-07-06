package bunpod.sdu.wheresdu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment; //เอาความสามารถคนอื่นมา ด้วยการ Extends
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bunpod.sdu.wheresdu.R;

/**
 * Created by ASUS PC on 6/7/2560.
 */

public class MainFragment extends Fragment{

    // onCreateView
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment_layout,
                container, false);

        return view;
    } // ใช้สร้าง view เพื่อเอาไปไว้ที่หน้า activity


    // on ActivityCreate
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Register Coltroller
        TextView textView = (TextView) getView().findViewById(R.id.txtNewRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentcontent, RegisterFragment
                                .registerInstance()).commit();
            }
        });

    }
} // Main Class คลาสหลัก
