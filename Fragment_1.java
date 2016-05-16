package com.torresriquelme.menulateraltest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "MenuLat";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private TextView tittle;
    private Button btToFrag2;
    private EditText textToFrag2;

    public Fragment_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_1 newInstance(String param1, String param2) {
        Fragment_1 fragment = new Fragment_1();
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
        return inflater.inflate(R.layout.fragment_fragment_1, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "Metodo onActivityCreated de Fragment1");
        if (getActivity() instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) getActivity();
            Log.i(TAG, "Se implementa el mListener en Fragment 1");
        } else {
            Log.i(TAG, "No se implementó el mListener en Fragment 1");
            throw new RuntimeException(getActivity().toString() + " must implement OnFragmentInteractionListener");
        }
        tittle = (TextView) getActivity().findViewById(R.id.tv_fragment1_tittle);
        if(!mParam1.equals("")){
            tittle.setText(mParam1);
        }
        textToFrag2 = (EditText) getActivity().findViewById(R.id.et_fragmet1);
        btToFrag2 = (Button) getActivity().findViewById(R.id.bt_send_to_frag_2);
        btToFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed(textToFrag2.getText().toString(), 1);
                Log.i(TAG, "OnClickListener del Fragment 1");
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String data, int position) {
        Log.i(TAG, "Metodo onButtonPressed Fragment 1 iniciado con data " + data);
        if (mListener != null) {
            Log.i(TAG, "Llamando al método del Intenface en Fragment 1");
            mListener.onFragmentInteraction(data, position);
        }
    }

    @Override
    public void onAttach(Context context) {
        Log.i(TAG, "Metodo onAttach de Fragment1");
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
            Log.i(TAG, "Se implementa el mListener en Fragment 1");
        } else {
            Log.i(TAG, "No se implementó el mListener en Fragment 1");
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
