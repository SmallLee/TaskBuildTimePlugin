package com.example.taskbuildtimedemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.scwang.smartrefresh.layout.SmartRefreshLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tvSms).setOnClickListener {
            val intent =
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("upi://pay?pa=billdesk@hdfcbank&pn=BDUATV2K50&mc=7399&tr=UHD50000705133&tn=Pay&am=11.79&mam=11.79&cu=INR")
                )
            startActivity(intent)
        }
    }
}