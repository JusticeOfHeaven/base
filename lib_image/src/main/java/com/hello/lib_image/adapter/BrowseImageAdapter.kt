package com.hello.lib_image.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hello.lib_image.R
import com.hello.lib_net.widget.AspectRatioImageView

/**
 * Create by jzhan on 2019/10/14
 */
class BrowseImageAdapter(
        private var mContext: Context,
        private var data:MutableList<String>
) : RecyclerView.Adapter<BrowseImageAdapter.MViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): MViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.image_item_select, null)
        return MViewHolder(view)
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        val imageView = holder.getView<AspectRatioImageView>(R.id.image_view)

        val parse = Uri.parse(data[position])
        imageView.setImageURI(parse)
    }

    override fun getItemCount(): Int = data.size

    class MViewHolder(
            private var mView: View
    ) : RecyclerView.ViewHolder(mView) {

        fun <T : View> getView(id: Int): T {
            return mView.findViewById(id)
        }
    }

    fun setData(data:List<String>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }
}