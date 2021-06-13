package com.biszaal.sellersspot

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class EachPostView(
    private val postList: ArrayList<Post>
) : RecyclerView.Adapter<EachPostView.ViewHolder>()
{


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var siv_userImage : CircleImageView = itemView.findViewById(R.id.siv_userImage)
        var tv_post_name: TextView = itemView.findViewById(R.id.tv_post_name)
        var tv_post_description: TextView = itemView.findViewById(R.id.tv_post_description)
        var hsv_post_image: HorizontalScrollView = itemView.findViewById(R.id.hsv_post_image)
        var tv_post_location: TextView = itemView.findViewById(R.id.tv_post_location)
        var ib_post_like: ImageButton = itemView.findViewById(R.id.ib_post_like)
        var ib_post_disike: ImageButton = itemView.findViewById(R.id.ib_post_dislike)
        var tv_post_price: TextView = itemView.findViewById(R.id.tv_post_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val context = parent.context
        val view : View = LayoutInflater.from(context).inflate(R.layout.eachpost, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val currentPost: Post = postList[position]

        holder.tv_post_name.text = currentPost.postName
        holder.tv_post_description.text = currentPost.postDescription
    }
}