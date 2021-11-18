package com.example.ejercicio9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MySmSReceiver extends BroadcastReceiver {
    private Bundle bundle;
    private SmsMessage[] msgs;
    private String strMessage;
    private String format;

    @Override
    public void onReceive(Context context, Intent intent) {
                
    }

    public SmsMessage getMsgs(int i) {
        return msgs[i];
    }

    public SmsMessage getLastMessage() {
        return msgs[msgs.length-1];
    }
}
