package bunpod.sdu.wheresdu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment; //เอาความสามารถคนอื่นมา ด้วยการ Extends
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import bunpod.sdu.wheresdu.GetAllUser;
import bunpod.sdu.wheresdu.MyAlert;
import bunpod.sdu.wheresdu.R;

/**
 * Created by ASUS PC on 6/7/2560.
 */

public class MainFragment extends Fragment{

    private EditText userEditText, passwordEdittext;

    public static MainFragment mainInstance() {
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        mainFragment.setArguments(bundle);

        return mainFragment;
    }



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
        registerColtroller();

        //Login Controller
        loginController();



    }

    private void loginController() {
        userEditText = (EditText) getView().findViewById(R.id.edtUser);
        passwordEdittext = (EditText) getView().findViewById(R.id.edtPassword);
        Button button = (Button) getView().findViewById(R.id.btnLogin);

        // Check Space
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUser = userEditText.getText().toString().trim();
                String strPassword = passwordEdittext.getText().toString().trim();

                if (strUser.equals("") || strPassword.equals("")) {

                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getResources().getString(R.string.title_have),
                            getResources().getString(R.string.message_have));

                } else {

                    checkUserAndPass(strPassword, strPassword);
                }
            }
        });

    }//Login Controller

    private void checkUserAndPass(String strUser, String strPassword) {

        String tag = "7JulyV1";

        try {

            GetAllUser getAllUser = new GetAllUser(getActivity());
            getAllUser.execute();

            String strJSON = getAllUser.get();
            Log.d(tag, "JSON ==>" + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);

            for (int i=0; i<jsonArray.length(); i+=1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);


            } //for

        } catch (Exception e) {
            e.printStackTrace();
        }

    } // Check User

    private void registerColtroller() {
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
