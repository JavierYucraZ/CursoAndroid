package com.example.xykra.myapplication

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(activity : Activity, data : ArrayList<Pokemon>) : BaseAdapter() {

    private val context : Context
    private val items : ArrayList<Pokemon>

    init {
        this.context = activity
        this.items = data
    }


    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position : Int): Any {
        return items[position]
    }

    override fun getItemId(position : Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView : View?, parent: ViewGroup?): View {
        var convertView = convertView
        val viewHolder : ViewHolder

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false)
            viewHolder = ViewHolder(convertView!!)
            convertView.setTag(viewHolder)
        } else {
            viewHolder = convertView!!.tag as ViewHolder
        }


        val temp = getItem(position) as Pokemon
        viewHolder.itemTitulo.text = temp.titulo
        viewHolder.itemSubtitulo.text = temp.subtitulo
        viewHolder.itemImagen.setImageResource(temp.imagen)

        return convertView
    }


    private inner class ViewHolder(view : View){
        var itemTitulo : TextView
        var itemSubtitulo : TextView
        var itemImagen : ImageView

        init{
            itemTitulo = view.findViewById(R.id.tvTitulo) as TextView
            itemSubtitulo = view.findViewById(R.id.tvSubtitulo) as TextView
            itemImagen = view.findViewById(R.id.ivImagen) as ImageView
        }
    }




}