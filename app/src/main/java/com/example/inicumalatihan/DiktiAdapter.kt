package com.example.inicumalatihan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.inicumalatihan.models.room.Dikti


class DiktiAdapter(context: Context, DiktiArrayList : ArrayList<Dikti>) : RecyclerView.Adapter<DiktiAdapter.DiktiViewHolder>() , Filterable {

    val diktiArrayList = DiktiArrayList
    val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiktiViewHolder {
        val itemView = inflater.inflate(R.layout.item_list, parent, false)
        return DiktiViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return diktiArrayList.size
    }

    override fun onBindViewHolder(holder: DiktiViewHolder, position: Int) {
        holder.titleTextView.setText(diktiArrayList.get(position).title)
        holder.noContractTextView.setText(diktiArrayList.get(position).body)
        holder.iconImageView.setImageResource(R.drawable.ic_launcher_background)
    }


    override fun getFilter(): Filter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    inner class DiktiViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        val titleTextView = itemView.findViewById<TextView>(R.id.title_tv)
        val noContractTextView = itemView.findViewById<TextView>(R.id.body_tv)
        val iconImageView = itemView.findViewById<ImageView>(R.id.item_img)
    }
}