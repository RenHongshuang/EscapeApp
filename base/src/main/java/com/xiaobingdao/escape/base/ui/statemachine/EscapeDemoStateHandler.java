package com.xiaobingdao.escape.base.ui.statemachine;

import android.os.Looper;


/**
 * Created by hs.ren on 2019/11/8.
 */

public class EscapeDemoStateHandler extends StateHandler {
    public EscapeDemoStateHandler(Looper looper, String tag) {
        super(looper, tag);
    }

    public HandlerState getCurrentState() {
        return mCurrentState;
    }

    public HandlerState getDestState() {
        return mDestState;
    }
}
