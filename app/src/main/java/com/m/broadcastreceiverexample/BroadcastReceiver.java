package com.m.broadcastreceiverexample;


import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
        private MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
//     if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction()))
//     {
//         Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT).show();
//     }
//     if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
//     {
//         Toast.makeText(context, "connection changed", Toast.LENGTH_SHORT).show();
//     }

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
        {
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);

            if (noConnectivity)
            {
                Toast.makeText(context, "No Connection", Toast.LENGTH_SHORT).show();
//                mediaPlayer = MediaPlayer.create(context,R.raw.snake);
//                mediaPlayer.start();
            }
            else {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            }
        }
        if (Intent.ACTION_POWER_CONNECTED.equals(intent.getAction()))
        {
            Toast.makeText(context, "power connected", Toast.LENGTH_SHORT).show();
            mediaPlayer = MediaPlayer.create(context,R.raw.snake);
            mediaPlayer.start();
        }

        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction()))
        {
            Toast.makeText(context, "Airplane mode change", Toast.LENGTH_SHORT).show();
            mediaPlayer = MediaPlayer.create(context,R.raw.snake);
            mediaPlayer.start();
        }
   }
}
