package com.hello.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hello.base.presenter.MainContract
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Create by jzhan on 2019/8/13
 */
class DemoAct : AppCompatActivity(), MainContract.View {
    override fun hello() {
        Log.d("jzhan","hello")
    }

    override fun getPresenter(): MainContract.Presenter {
        return MainContract.Presenter(this)
    }

    override fun getContext(): Context {
        return this
    }

    override fun isRecycled(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_view.setOnClickListener {
            getPresenter().getHello()
        }
    }
}