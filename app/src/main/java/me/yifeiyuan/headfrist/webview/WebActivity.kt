package me.yifeiyuan.headfrist.webview

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.KeyEvent
import android.view.View
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


        webview.settings.apply {

            javaScriptEnabled = true

        }

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

//                result?.cancel()
//                result?.confirm()
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
                result?.confirm("vallue")
                return super.onJsPrompt(view, url, message, defaultValue, result)
            }

            override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {
                super.onReceivedIcon(view, icon)
                Log.d(TAG, "onReceivedIcon() called with: view = $view, icon = $icon")
            }

            override fun onReceivedTouchIconUrl(
                view: WebView?,
                url: String?,
                precomposed: Boolean
            ) {
                super.onReceivedTouchIconUrl(view, url, precomposed)
                Log.d(
                    TAG,
                    "onReceivedTouchIconUrl() called with: view = $view, url = $url, precomposed = $precomposed"
                )
            }

            override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
                super.onShowCustomView(view, callback)

                Log.d(TAG, "onShowCustomView() called with: view = $view, callback = $callback")
            }

            override fun onShowCustomView(
                view: View?,
                requestedOrientation: Int,
                callback: CustomViewCallback?
            ) {
                super.onShowCustomView(view, requestedOrientation, callback)
                Log.d(
                    TAG,
                    "onShowCustomView() called with: view = $view, requestedOrientation = $requestedOrientation, callback = $callback"
                )
            }

            override fun onHideCustomView() {
                super.onHideCustomView()
                Log.d(TAG, "onHideCustomView() called")
            }

            override fun onCreateWindow(
                view: WebView?,
                isDialog: Boolean,
                isUserGesture: Boolean,
                resultMsg: Message?
            ): Boolean {
                Log.d(
                    TAG,
                    "onCreateWindow() called with: view = $view, isDialog = $isDialog, isUserGesture = $isUserGesture, resultMsg = $resultMsg"
                )
                return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)
            }

            override fun onRequestFocus(view: WebView?) {
                super.onRequestFocus(view)
                Log.d(TAG, "onRequestFocus() called with: view = $view")
            }

            override fun onCloseWindow(window: WebView?) {
                super.onCloseWindow(window)
                Log.d(TAG, "onCloseWindow() called with: window = $window")
            }

            override fun onJsBeforeUnload(
                view: WebView?,
                url: String?,
                message: String?,
                result: JsResult?
            ): Boolean {
                Log.d(
                    TAG,
                    "onJsBeforeUnload() called with: view = $view, url = $url, message = $message, result = $result"
                )
                return super.onJsBeforeUnload(view, url, message, result)
            }

            override fun onExceededDatabaseQuota(
                url: String?,
                databaseIdentifier: String?,
                quota: Long,
                estimatedDatabaseSize: Long,
                totalQuota: Long,
                quotaUpdater: WebStorage.QuotaUpdater?
            ) {
                super.onExceededDatabaseQuota(
                    url,
                    databaseIdentifier,
                    quota,
                    estimatedDatabaseSize,
                    totalQuota,
                    quotaUpdater
                )
                Log.d(
                    TAG,
                    "onExceededDatabaseQuota() called with: url = $url, databaseIdentifier = $databaseIdentifier, quota = $quota, estimatedDatabaseSize = $estimatedDatabaseSize, totalQuota = $totalQuota, quotaUpdater = $quotaUpdater"
                )
            }

            override fun onReachedMaxAppCacheSize(
                requiredStorage: Long,
                quota: Long,
                quotaUpdater: WebStorage.QuotaUpdater?
            ) {
                super.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater)
                Log.d(
                    TAG,
                    "onReachedMaxAppCacheSize() called with: requiredStorage = $requiredStorage, quota = $quota, quotaUpdater = $quotaUpdater"
                )
            }

            override fun onGeolocationPermissionsShowPrompt(
                origin: String?,
                callback: GeolocationPermissions.Callback?
            ) {
                super.onGeolocationPermissionsShowPrompt(origin, callback)
                Log.d(
                    TAG,
                    "onGeolocationPermissionsShowPrompt() called with: origin = $origin, callback = $callback"
                )
            }

            override fun onGeolocationPermissionsHidePrompt() {
                super.onGeolocationPermissionsHidePrompt()
                Log.d(TAG, "onGeolocationPermissionsHidePrompt() called")
            }

            override fun onPermissionRequest(request: PermissionRequest?) {
                super.onPermissionRequest(request)
                Log.d(TAG, "onPermissionRequest() called with: request = $request")
            }

            override fun onPermissionRequestCanceled(request: PermissionRequest?) {
                super.onPermissionRequestCanceled(request)
                Log.d(TAG, "onPermissionRequestCanceled() called with: request = $request")
            }

            override fun onJsTimeout(): Boolean {
                Log.d(TAG, "onJsTimeout() called")
                return super.onJsTimeout()
            }

            //onConsoleMessage() called with: message = console called, lineNumber = 26, sourceID = file:///android_asset/hybrid_test.html
            /**
             *
             * @lineNumber : JS 代码行号
             * @sourceID : 页面链接
             */
            override fun onConsoleMessage(message: String?, lineNumber: Int, sourceID: String?) {
                super.onConsoleMessage(message, lineNumber, sourceID)
                Log.d(
                    TAG,
                    "onConsoleMessage() called with: message = $message, lineNumber = $lineNumber, sourceID = $sourceID"
                )
            }

//            override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
//                Log.d(TAG, "onConsoleMessage() called with: consoleMessage = $consoleMessage")
//                return super.onConsoleMessage(consoleMessage)
//            }

            override fun getDefaultVideoPoster(): Bitmap? {
                Log.d(TAG, "getDefaultVideoPoster() called")
                return super.getDefaultVideoPoster()
            }

            override fun getVideoLoadingProgressView(): View? {
                Log.d(TAG, "getVideoLoadingProgressView() called")
                return super.getVideoLoadingProgressView()
            }

            override fun getVisitedHistory(callback: ValueCallback<Array<String>>?) {
                super.getVisitedHistory(callback)
                Log.d(TAG, "getVisitedHistory() called with: callback = $callback")
            }

            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                Log.d(
                    TAG,
                    "onShowFileChooser() called with: webView = $webView, filePathCallback = $filePathCallback, fileChooserParams = $fileChooserParams"
                )
                return super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
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

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                Log.d(TAG, "shouldOverrideUrlLoading() called with: view = $view, url = $url")
                return super.shouldOverrideUrlLoading(view, url)
            }

            override fun onLoadResource(view: WebView?, url: String?) {
                super.onLoadResource(view, url)
                Log.d(TAG, "onLoadResource() called with: view = $view, url = $url")
            }

            override fun onPageCommitVisible(view: WebView?, url: String?) {
                super.onPageCommitVisible(view, url)
                Log.d(TAG, "onPageCommitVisible() called with: view = $view, url = $url")
            }

            override fun shouldInterceptRequest(
                view: WebView?,
                url: String?
            ): WebResourceResponse? {
                Log.d(TAG, "shouldInterceptRequest() called with: view = $view, url = $url")
                return super.shouldInterceptRequest(view, url)
            }

            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest?
            ): WebResourceResponse? {
                Log.d(TAG, "shouldInterceptRequest() called with: view = $view, request = $request")
                return super.shouldInterceptRequest(view, request)
            }

            override fun onTooManyRedirects(
                view: WebView?,
                cancelMsg: Message?,
                continueMsg: Message?
            ) {
                Log.d(
                    TAG,
                    "onTooManyRedirects() called with: view = $view, cancelMsg = $cancelMsg, continueMsg = $continueMsg"
                )
                super.onTooManyRedirects(view, cancelMsg, continueMsg)
            }

            override fun onReceivedError(
                view: WebView?,
                errorCode: Int,
                description: String?,
                failingUrl: String?
            ) {
                Log.d(
                    TAG,
                    "onReceivedError() called with: view = $view, errorCode = $errorCode, description = $description, failingUrl = $failingUrl"
                )
                super.onReceivedError(view, errorCode, description, failingUrl)
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                Log.d(
                    TAG,
                    "onReceivedError() called with: view = $view, request = $request, error = $error"
                )
            }

            override fun onReceivedHttpError(
                view: WebView?,
                request: WebResourceRequest?,
                errorResponse: WebResourceResponse?
            ) {
                super.onReceivedHttpError(view, request, errorResponse)
                Log.d(
                    TAG,
                    "onReceivedHttpError() called with: view = $view, request = $request, errorResponse = $errorResponse"
                )
            }

            override fun onFormResubmission(
                view: WebView?,
                dontResend: Message?,
                resend: Message?
            ) {
                super.onFormResubmission(view, dontResend, resend)
                Log.d(
                    TAG,
                    "onFormResubmission() called with: view = $view, dontResend = $dontResend, resend = $resend"
                )
            }

            override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
                super.doUpdateVisitedHistory(view, url, isReload)
                Log.d(
                    TAG,
                    "doUpdateVisitedHistory() called with: view = $view, url = $url, isReload = $isReload"
                )
            }

            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler?,
                error: SslError?
            ) {
                super.onReceivedSslError(view, handler, error)
                Log.d(
                    TAG,
                    "onReceivedSslError() called with: view = $view, handler = $handler, error = $error"
                )
            }

            override fun onReceivedClientCertRequest(view: WebView?, request: ClientCertRequest?) {
                super.onReceivedClientCertRequest(view, request)
                Log.d(
                    TAG,
                    "onReceivedClientCertRequest() called with: view = $view, request = $request"
                )
            }

            override fun onReceivedHttpAuthRequest(
                view: WebView?,
                handler: HttpAuthHandler?,
                host: String?,
                realm: String?
            ) {
                super.onReceivedHttpAuthRequest(view, handler, host, realm)
                Log.d(
                    TAG,
                    "onReceivedHttpAuthRequest() called with: view = $view, handler = $handler, host = $host, realm = $realm"
                )
            }

            override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
                Log.d(TAG, "shouldOverrideKeyEvent() called with: view = $view, event = $event")
                return super.shouldOverrideKeyEvent(view, event)
            }

            override fun onUnhandledKeyEvent(view: WebView?, event: KeyEvent?) {
                super.onUnhandledKeyEvent(view, event)
                Log.d(TAG, "onUnhandledKeyEvent() called with: view = $view, event = $event")
            }

            override fun onScaleChanged(view: WebView?, oldScale: Float, newScale: Float) {
                super.onScaleChanged(view, oldScale, newScale)
                Log.d(
                    TAG,
                    "onScaleChanged() called with: view = $view, oldScale = $oldScale, newScale = $newScale"
                )
            }

            override fun onReceivedLoginRequest(
                view: WebView?,
                realm: String?,
                account: String?,
                args: String?
            ) {
                super.onReceivedLoginRequest(view, realm, account, args)
                Log.d(
                    TAG,
                    "onReceivedLoginRequest() called with: view = $view, realm = $realm, account = $account, args = $args"
                )
            }

            override fun onRenderProcessGone(
                view: WebView?,
                detail: RenderProcessGoneDetail?
            ): Boolean {
                Log.d(TAG, "onRenderProcessGone() called with: view = $view, detail = $detail")
                return super.onRenderProcessGone(view, detail)
            }

            override fun onSafeBrowsingHit(
                view: WebView?,
                request: WebResourceRequest?,
                threatType: Int,
                callback: SafeBrowsingResponse?
            ) {
                super.onSafeBrowsingHit(view, request, threatType, callback)
                Log.d(
                    TAG,
                    "onSafeBrowsingHit() called with: view = $view, request = $request, threatType = $threatType, callback = $callback"
                )
            }
        }

        val url = intent.getStringExtra("url")
        if (url != null) {
            webview.loadUrl(url)
        }
    }
}