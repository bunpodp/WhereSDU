package bunpod.sdu.wheresdu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import bunpod.sdu.wheresdu.MyAlert;
import bunpod.sdu.wheresdu.MyConstant;
import bunpod.sdu.wheresdu.PostNewUser;
import bunpod.sdu.wheresdu.R;

/**
 * Created by ASUS PC on 6/7/2560.
 */

public class RegisterFragment extends Fragment {

    //การประกาศตัวแปร Explicit
    private String nameString, userString, passwordString;


    //Method Public
    public static RegisterFragment registerInstance() {
        RegisterFragment registerFragment = new RegisterFragment();
        Bundle bundle = new Bundle();
        registerFragment.setArguments(bundle);
        return registerFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment_layout, container, false);

        return view;
    }// onCreateView

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //การทำ Back Controller
        การทำBackController();

        //NewRegis Controller
        newRegisterController();

    }//onActivity Create

    private void newRegisterController() {
        //Initial View
        final EditText nameEditText = (EditText) getView().findViewById(R.id.edtName);
        final EditText userEditText = (EditText) getView().findViewById(R.id.edtUser);
        final EditText passwordEditText = (EditText) getView().findViewById(R.id.edtPassword);
        Button button = (Button) getView().findViewById(R.id.btnNewRegister);

        //Get Event Click New Register
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //การ Get for edit text
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                //การ Check Space
                if (nameString.length() == 0
                        || userString.length() == 0
                        || passwordString.length() == 0) {
                    // Have Space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getString(R.string.title_have), getString(R.string.message_have));

                } else {
                    // No Space
                    uploadValueToServer();

                }


            }// on Click
        });


    } //newRegister

    private void uploadValueToServer() {

        String tag = "7JulyV1";
        MyConstant myConstant = new MyConstant();
        String urlPHP = myConstant.getUrlAddUser();

        try {

            PostNewUser postNewUser = new PostNewUser(getActivity());
            postNewUser.execute(nameString, userString, passwordString, urlPHP);
            String result = postNewUser.get();
            Log.d(tag, "result ==> " + result);

            if (Boolean.parseBoolean(result)) {

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentcontent, MainFragment.mainInstance())
                        .commit();

            } else {

                MyAlert myAlert = new MyAlert(getActivity());
                myAlert.myDialog("Error", "Cannot Upload Please Try Again");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    } //method การนำข้อมูลเชื่อมต่อเซิร์ฟเวอร์

    private void การทำBackController() {
        ImageView imageView = (ImageView) getView().findViewById(R.id.imvBack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentcontent, MainFragment.mainInstance())
                        .commit();
            }
        });
    }//method การทำปุ่ม Back Controller


}// Main Class
