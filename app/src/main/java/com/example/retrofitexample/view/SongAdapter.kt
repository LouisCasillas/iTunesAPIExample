package com.example.retrofitexample.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexample.R
import com.example.retrofitexample.model.ITunesSong
import com.squareup.picasso.Picasso

// create our ViewHolder
// bind the data to the ViewHolder
class SongAdapter(private val list: List<ITunesSong>)
    : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    // binding our data, to our view
    inner class SongViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBind(song: ITunesSong) {
            val tvUserName = itemView.findViewById<TextView>(R.id.tv_user_name)
            val ivUserThumbnail = itemView.findViewById<ImageView>(R.id.iv_user_thumbnail)

            tvUserName.text = song.artistName

            Picasso.get()
                .load(song.artworkUrl60)
                .placeholder(R.drawable.ic_launcher_foreground)
                .fit()
                .into(ivUserThumbnail)

            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "${song.artistName} was clicked",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    // we inflate our list item and pass it to our ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val listItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list_item, parent, false)
        return SongViewHolder(listItem)
    }

    // this is where we bind the data to the view
    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    // return the size of the list
    override fun getItemCount(): Int {
        return list.size
    }
}