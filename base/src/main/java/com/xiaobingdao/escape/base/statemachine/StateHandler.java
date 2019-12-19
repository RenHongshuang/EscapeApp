package com.xiaobingdao.escape.base.statemachine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;


import java.util.LinkedList;
import java.util.Locale;

/**
 * Handle messages sent to the state machine by calling
 * the current state's processMessage. It also handles
 * the enter/exit calls and placing any deferred messages
 * back onto the queue when transitioning to a new state.
 */
public class StateHandler extends Handler {

    private final String TAG;

    public StateHandler(Looper looper, String tag) {
        super(looper);
        TAG = tag;
    }

    protected HandlerState mCurrentState;
    protected HandlerState mDestState;
    protected final LinkedList<Message> mDeferredMessages = new LinkedList<Message>();

    /**
     * Set the initial state. This must be invoked before
     * and messages are sent to the state machine.
     */
    public void setInitialState(HandlerState initialState) {
        mDestState = initialState;
        Log.i(TAG, "[" + mDestState + "] ===== START_SERVICE =====");
    }

    /**
     * transition to destination state. Upon returning
     * from processMessage the current state's exit will
     * be executed and upon the next message arriving
     * destState.enter will be invoked.
     */
    public void transTo(HandlerState destState) {
        mDestState = destState;
        Log.d(TAG, String.format("[%s] transTo %s",
                mCurrentState, mDestState));
    }

    /**
     * Defer this message until next state transition
     * to avoid consuming it on this state.
     * Upon transition all deferred messages will be
     * placed on the message queue and reprocessed in
     * the original order. (i.e. The next state the oldest
     * messages will be processed first)
     */
    public void deferMessage(Message message) {
        Message newMsg = obtainMessage();
        newMsg.copyFrom(message);
        mDeferredMessages.addLast(newMsg);
    }

    /**
     * Retrieves, but does not remove, the first element of this list,
     * or returns {@code null} if this list is empty.
     *
     * @return the first element of this list, or {@code null}
     * if this list is empty
     * @since 1.6
     */
    public Message peekFirstDeferred() {
        return mDeferredMessages.peekFirst();
    }


    public Message pollDeferred() {
        Message message = mDeferredMessages.poll();
        if (message != null) {
            Log.v(TAG, String.format(Locale.getDefault(), "[%s] poll deferred %s arg1=%d q_len=%d",
                    mCurrentState, message.what, message.arg1, mDeferredMessages.size()));
        }
        return message;
    }


    public void clearDeferred() {
        int size = mDeferredMessages.size();
        if (size == 0) {
            return;
        }

        Log.w(TAG, String.format(Locale.getDefault(), "[%s] clear %d deferred", mCurrentState, size));

        mDeferredMessages.clear();
    }

    /**
     * This will dispatch the message to the
     * current state's processMessage.
     */
    @Override
    public void handleMessage(Message message) {
        if (mDestState != null) {
            mCurrentState = mDestState;
            mDestState = null;
            Log.d(TAG, "[" + mCurrentState + "] =====> ENTER");
            mCurrentState.enter(message);
        }

        if (mCurrentState != null) {
            Log.v(TAG, "[" + mCurrentState + "] ===== PROCESS");
            mCurrentState.processMessage(message);
        }

        if (mDestState != null) {
            Log.d(TAG, "[" + mCurrentState + "] <===== EXIT");
            mCurrentState.exit(message);

            while (mDeferredMessages.size() != 0) {
                Message deferredMessage = mDeferredMessages.removeLast();
                sendMessageAtFrontOfQueue(deferredMessage);
            }
        }
    }
}