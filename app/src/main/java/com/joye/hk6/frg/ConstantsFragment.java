package com.joye.hk6.frg;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.joye.hk6.mvp.BasePresenterFragment;
import com.joye.hk6.vu.ConstantsFragmentVu;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConstantsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConstantsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConstantsFragment extends BasePresenterFragment<ConstantsFragmentVu> {

    private OnFragmentInteractionListener mListener;

    public ConstantsFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConstantsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConstantsFragment newInstance( ) {
        ConstantsFragment fragment = new ConstantsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    protected Class<ConstantsFragmentVu> getVuClass() {
        return ConstantsFragmentVu.class;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
