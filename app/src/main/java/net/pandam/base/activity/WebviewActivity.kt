package net.pandam.base.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import net.pandam.base.R



class WebviewActivity : AppCompatActivity() {

    var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        //초기화
        initialize()
    }

    private fun initialize()
    {
        webView = findViewById(R.id.web_view)

        webView!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView!!.settings.javaScriptEnabled = true
        webView!!.loadUrl("http://wiryelife.com")
    }

    override fun onBackPressed() {
        if (webView?.canGoBack()!!) {
            webView!!.goBack()
        } else {
            // Otherwise defer to system default behavior.
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            webView!!.goBack()
            true
        }  else if (item?.itemId == android.R.id.closeButton) {
            webView!!.goBack()
            true
        }else {
            super.onOptionsItemSelected(item)
        }
    }
}
