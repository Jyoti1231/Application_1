package com.example.wifiapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;

import android.net.wifi.p2p.WifiP2pManager;
import android.widget.Toast;

public class WiFiBR extends BroadcastReceiver {

    private WifiP2pManager manager;
    private WifiP2pManager.Channel channel;
    private MainActivity activity;

    public WiFiBR(WifiP2pManager manager, WifiP2pManager.Channel channel, MainActivity activity) {
        super();
        this.manager = manager;
        this.channel = channel;
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action))   {
            //Check to see if Wifi is enabled and notify appropriate activity
        }
        else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action))  {
            //Call WifiP2pManager.requestPeers() to get a list of current peers
            if(manager!=null)
                manager.requestPeers(channel, activity.peerListListener);

        }
        else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action))  {
            //Respond to new connection or disconnectione
            if (manager!=null) {
                NetworkInfo networkInfo = intent.getParcelableExtra(WifiP2pManager.EXTRA_NETWORK_INFO);
                if (networkInfo.isConnected()) {
                    manager.requestConnectionInfo(channel, activity.connectionInfoListener);
                }
                else {
                    activity.connectionStatus.setText("Not Connected");
                }
            }
        }
    }

}
