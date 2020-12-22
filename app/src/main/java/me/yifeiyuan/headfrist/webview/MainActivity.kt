package me.yifeiyuan.headfrist.webview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.yifeiyuan.headfrist.webview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //打不开
        binding.taobao.setOnClickListener {
            WebActivity.start(this, "https://www.taobao.com")
        }

        binding.baidu.setOnClickListener {
            WebActivity.start(this, "https://www.baidu.com")
        }

        binding.hybridTest.setOnClickListener {
            WebActivity.start(this, "file:///android_asset/hybrid_test.html")
        }

    }
}