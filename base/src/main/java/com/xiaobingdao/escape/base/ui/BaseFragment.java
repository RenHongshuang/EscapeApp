package com.xiaobingdao.escape.base.ui;

import android.app.Dialog;
import android.text.TextUtils;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by hs.ren on 18/1/5.
 */
public abstract class BaseFragment extends Fragment {
    public void showDialog(Dialog dialog) {
        if (isFragmentActivityInvalid()) {
            return;
        }
        dialog.show();
    }

    public void showDialog(DialogFragment dialogFragment, String tag) {
        if (isFragmentActivityInvalid()) {
            return;
        }
        if (TextUtils.isEmpty(tag)) {
            tag = "undefined";
        }
        final FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.add(dialogFragment, tag);
        ft.commitAllowingStateLoss();
    }

    public void showFragment(Fragment fragment, int layoutId, String tag) {
        if (isFragmentActivityInvalid()) {
            return;
        }
        final FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        final FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(layoutId, fragment);
        ft.commitAllowingStateLoss();
    }

    protected boolean isFragmentActivityInvalid() {
        FragmentActivity fragmentActivity = getActivity();
        return fragmentActivity == null || fragmentActivity.isFinishing() || fragmentActivity.isDestroyed();
    }
}
