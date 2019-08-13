package com.hello.base.presenter

import com.hello.lib_net.mvp.BasePresenter
import com.hello.lib_net.mvp.IBaseView
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer

/**
 * Create by jzhan on 2019/8/13
 */
class MainContract {

    interface View : IBaseView<Presenter> {
        fun hello()
    }

    class Presenter(iView:View) : BasePresenter<View>(iView) {

        fun getHello() {
            Observable.create<Boolean> {
                it.onNext(true)
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    view.hello()
                })
        }
    }
}