package com.dicoding.fundamentl_subs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.dicoding.fundamentl_subs.databinding.ListItemBinding

class SandwhichesAdapter internal constructor(private val context: Context) : BaseAdapter() {

    internal var sandwhich = arrayListOf<Sandwhiches>()
    override fun getCount(): Int = sandwhich.size
    override fun getItem(i: Int): Any = sandwhich[i]
    override fun getItemId(i: Int): Long = i.toLong()
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {

        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as Sandwhiches
        viewHolder.bind(user)
        return itemView


    }


    private inner class ViewHolder(view: View){
        private val binding = ListItemBinding.bind(view)




        fun bind(user: Sandwhiches){
            binding.tvItemUNamename.text = user.Username
            binding.tvItemName.text = user.Name
            binding.tvItemLocation.text = user.Location
            binding.imgItemPhoto.setImageResource(user.Avatar)
        }
    }


}