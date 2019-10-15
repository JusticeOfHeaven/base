package com.hello.lib_net.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Create by jzhan on 2019/7/11
 */
abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
    }

    abstract fun initView()

    abstract fun getLayoutId(): Int
}