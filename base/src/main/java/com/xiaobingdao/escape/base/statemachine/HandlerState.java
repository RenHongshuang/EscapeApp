package com.xiaobingdao.escape.base.statemachine;

import android.os.Message;

public class HandlerState {

    private String mStName = "";

    protected HandlerState(String stateName) {
        mStName = stateName;
    }

    protected void enter(Message current) {
    }

    protected void processMessage(Message current) {
    }

    protected void exit(Message current) {
    }
}