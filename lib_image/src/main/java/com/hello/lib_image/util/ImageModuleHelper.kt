package com.hello.lib_image.util

import android.content.Context
import android.content.Intent
import com.hello.lib_image.view.BrowseImageActivity

/**
 * Create by jzhan on 2019/10/14
 */
object ImageModuleHelper {

    fun startSelectImage(context: Context) {
        context.startActivity(Intent(context, BrowseImageActivity::class.java))
    }
}