package me.yifeiyuan.headfrist.webview

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity

class WebActivity : AppCompatActivity() {

    private val TAG = "WebActivity"


    companion object{

        @JvmStatic
        fun start(context: Context,url:String) {
            val starter = Intent(context, WebActivity::class.java)
                .putExtra("url", url)
            context.startActivity(starter)
        }
    }

    lateinit var webview: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webview = findViewById(R.id.webview)

        webview.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                Log.d(
                    TAG,
                    "onProgressChanged() called with: view = $view, newProgress = $newProgress"
                )
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                Log.d(TAG, "onReceivedTitle() called with: view = $view, title = $title")
            }

            override fun onJsAlert(
                view: WebView?,
                url: String?,
                message: String?,
                result: JsResult?
            ): Boolean {
                Log.d(
                    TAG,
                    "onJsAlert() called with: view = $view, url = $url, message = $message, result = $result"
                )
                return super.onJsAlert(view, url, message, result)
            }

            override fun onJsConfirm(
                view: WebView?,
                url: String?,
                message: String?,
                result: JsResult?
            ): Boolean {
                Log.d(
                    TAG,
                    "onJsConfirm() called with: view = $view, url = $url, message = $message, result = $result"
                )
                return super.onJsConfirm(view, url, message, result)
            }

            override fun onJsPrompt(
                view: WebView?,
                url: String?,
                message: String?,
                defaultValue: String?,
                result: JsPromptResult?
            ): Boolean {
                Log.d(
                    TAG,
                    "onJsPrompt() called with: view = $view, url = $url, message = $message, defaultValue = $defaultValue, result = $result"
                )
                return super.onJsPrompt(view, url, message, defaultValue, result)
            }

        }

        webview.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                Log.d(
                    TAG,
                    "shouldOverrideUrlLoading() called with: view = $view, request = $request"
                )
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                Log.d(
                    TAG,
                    "onPageStarted() called with: view = $view, url = $url, favicon = $favicon"
                )
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.d(TAG, "onPageFinished() called with: view = $view, url = $url")
            }

        }

        intent?.let {
            it.getStringExtra("url")
        }

        val url = intent.getStringExtra("url")
        webview.loadUrl(url)

        if (url.isNullOrEmpty()) {
            webview.loadUrl("https://www.taobao.com")
        } else {
            webview.loadUrl(url)
        }
    }
}