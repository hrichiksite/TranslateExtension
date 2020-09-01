/**
* CODE BY HRICHIK MAZUMDER
* GNU GPLv3 LICENSE
*/

package com.kode.googletranslate;

import com.google.appinventor.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

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

        private ComponentContainer container;
        /**
         * @param container container, component will be placed in
         */
        public GoogleTranslate(ComponentContainer container) {
            super(container.$form());
            this.container = container;
        }
      
        @SimpleFunction(description = "Translates The Given Text To The Given Language")
        public void StoreValue(final String CurrentLang, final String TranslateLang, final String Text) {
            serviceUrl = serviceUrl+CurrentLang+&tl+TranslateLang+&dt=t&q=+encode(Text);
            URL obj = new URL(serviceUrl);
            HttpURLConnection con = (HttpURLConnection)
            obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { 
                // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
    
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString()
        } else {
            return Error
        }
    }
