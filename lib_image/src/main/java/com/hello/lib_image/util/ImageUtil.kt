package com.hello.lib_image.util

import android.content.Context
import android.net.Uri
import android.provider.MediaStore

/**
 * Create by jzhan on 2019/10/9
 */
object ImageUtil {


    /**
     * 获取手机的图库
     */
    fun getLocalImages(context: Context):MutableList<String> {
        val images = arrayListOf<String>()
        val cursor = context.contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null)
        cursor?.run{
            cursor.moveToFirst()
            while (cursor.moveToNext()) {
                //图片完全路径
                val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
                //图片处于哪个文件夹下
                val parent = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.BUCKET_DISPLAY_NAME))
                //图片大小
                val size = cursor.getInt(cursor.getColumnIndex(MediaStore.Images.Media.SIZE))

                val name = Uri.parse(path).lastPathSegment
                val parentPath = path.replace(name, "")

                images.add(path)
            }
        }

        cursor?.close()
        return images
    }
}