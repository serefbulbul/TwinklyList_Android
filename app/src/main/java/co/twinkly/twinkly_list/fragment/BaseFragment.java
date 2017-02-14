package co.twinkly.twinkly_list.fragment;

import android.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Field;

/**
 * Created by serefbulbul on 14/02/2017.
 */

public class BaseFragment extends Fragment {

    protected void showActionBar() {
        disableShowHideAnimation(((AppCompatActivity) getActivity()).getSupportActionBar());

        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }

    protected void hideActionBar() {
        disableShowHideAnimation(((AppCompatActivity) getActivity()).getSupportActionBar());

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    private void disableShowHideAnimation(ActionBar actionBar) {
        try {
            actionBar.getClass().getDeclaredMethod("setShowHideAnimationEnabled", boolean.class).invoke(actionBar, false);
        } catch (Exception exception) {
            try {
                Field mActionBarField = actionBar.getClass().getSuperclass().getDeclaredField("mActionBar");
                mActionBarField.setAccessible(true);
                Object icsActionBar = mActionBarField.get(actionBar);
                Field mShowHideAnimationEnabledField = icsActionBar.getClass().getDeclaredField("mShowHideAnimationEnabled");
                mShowHideAnimationEnabledField.setAccessible(true);
                mShowHideAnimationEnabledField.set(icsActionBar, false);
                Field mCurrentShowAnimField = icsActionBar.getClass().getDeclaredField("mCurrentShowAnim");
                mCurrentShowAnimField.setAccessible(true);
                mCurrentShowAnimField.set(icsActionBar, null);
            } catch (Exception e) {
                //....
            }
        }
    }
}
