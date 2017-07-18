package com.example.beatsaudio.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        //Creamos un objeto de tipo Webview donde se contiene OSMAP y se hace referencia al xml
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);
        //Se fuerza la vista a movil.
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Activamos javascript
        myWebView.loadUrl("https://www.openstreetmap.org/#map=15/4.3336/-74.3657");
        // Url que carga la app (webview)
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setGeolocationEnabled(true);
        // Forzamos el webview para que abra los enlaces internos dentro de la la APP del gps


        myWebView.getSettings().setAppCacheEnabled(true);
        myWebView.getSettings().setDatabaseEnabled(true);   //Forma de guardar archivos para una ejecucion mas rapida
        myWebView.getSettings().setDomStorageEnabled(true);
        // Forzamos el webview para que abra los enlaces externos en el navegador
        // FIN AGREGADO
        myWebView.setWebChromeClient(new WebChromeClient() {
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });
        //Se manda la ubicacion del celular ya que no esta por default, al webview

        // Boton Flotante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                startActivity(intent);
            }
        });
    }
    //REdirige a la sgte ventana(Caracteristicas)

}
