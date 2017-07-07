package bunpod.sdu.wheresdu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import bunpod.sdu.wheresdu.R;

/**
 * Created by ASUS PC on 6/7/2560.
 */

public class RegisterFragment extends Fragment{
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
    }
}// Main Class
