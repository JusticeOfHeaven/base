package com.hello.lib_image.view

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.hello.lib_image.R
import com.hello.lib_image.adapter.BrowseImageAdapter
import com.hello.lib_image.util.ImageUtil
import kotlinx.android.synthetic.main.image_act_browse_image.*

/**
 * Create by jzhan on 2019/10/14
 */
class BrowseImageActivity : AppCompatActivity() {

    private var data = mutableListOf<String>()
    private val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1111
    private var mAdapter: BrowseImageAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_act_browse_image)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                            Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE)

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }else{
            val localImages = ImageUtil.getLocalImages(this)
            Log.e("BrowseImageActivity","localImages = $localImages")
            data.addAll(localImages)
        }

        recycler_view.layoutManager = GridLayoutManager(this, 3)
        mAdapter = BrowseImageAdapter(this, data)
        recycler_view.adapter = mAdapter

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    val localImages = ImageUtil.getLocalImages(this)
                    Log.e("BrowseImageActivity","localImages = $localImages")
                    mAdapter?.setData(localImages)
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }

    }
}