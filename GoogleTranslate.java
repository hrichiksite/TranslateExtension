/**
* CODE BY HRICHIK MAZUMDER
* GNU GPLv3 LICENSE
*/

package com.kode.googletranslate;

import android.app.Activity;

import android.text.TextUtils;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.common.*;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;

import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;

import com.google.appinventor.components.runtime.util.AsynchUtil;

import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

@DesignerComponent(
    description = "Non-visible Extension that provides functions for Getting Translation From Google Translate API.<br><a href="https://github.com/hrichiksite/TranslateExtension">Source Code</a>",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "https://i.imgur.com/VPJCUHf.png"
    version = 1)
@SimpleObject (external =true)
@UsesPermissions(permissionNames = "android.permission.INTERNET")
public class GoogleTranslate extends AndroidNonvisibleComponent{
  
    public static final String TRANSLATE_URL =
        "https://translate.googleapis.com/translate_a/single?client=gtx&sl=";
    private String serviceUrl = TRANSLATE_URL;
        }


        @SimpleFunction(description = "Translates The Given Text To The Given Language")
        public void StoreValue(final String CurrentLang, final String TranslateLang, final String Text) {

            serviceUrl = serviceUrl+CurrentLang+&tl+TranslateLang+&dt=t&q=+encode(Text);
            final String finalURL = serviceUrl +
            CurrentLang + "&tl" + TranslateLang + "&dt=t&q=" +
            "&text=" + URLEncoder.encode(Text, "UTF-8");

            URL url = new URL(finalURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection != null) {
              try {
                final String responseContent = getResponseContent(connection);
          
                return responseContent;
              };
          
              } finally {
                connection.disconnect();
              }
        }
        



    
