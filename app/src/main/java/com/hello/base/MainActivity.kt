package com.hello.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hello.lib_image.util.ImageModuleHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_view.setOnClickListener {
            startActivity(Intent(this, DemoAct::class.java))
        }

        tv_to_select_image.setOnClickListener {
            ImageModuleHelper.startSelectImage(this)
        }
    }
}
