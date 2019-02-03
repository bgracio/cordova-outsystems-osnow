package com.outsystems.plugins.osnow;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class OutSystemsNow extends CordovaPlugin {

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    
    webView.getView().setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP){
          Log.d("OSNow", "Click!");
          return true;
        }

        return false;
      }
    });
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if(action.equals("loadUrl")) {
      loadUrl(args.getString(0), args.getString(1));
    }

    return true;
  }

  private void loadUrl(final String hostname, final String appname) {
    cordova.getActivity().runOnUiThread(new Runnable() {
      public void run() {
        webView.loadUrl("https://" + hostname + "/" + appname);
      }
    });
  }
}
