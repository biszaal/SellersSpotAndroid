package com.biszaal.sellersspot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class EachPostView() : Fragment()
{
    private lateinit var siv_userImage : ImageView
    private lateinit var tv_post_name: TextView
    private lateinit var tv_post_description: TextView
    private lateinit var hsv_post_image: HorizontalScrollView
    private lateinit var tv_post_location: TextView
    private lateinit var tv_post_price: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.eachpost, container, false)

        siv_userImage = view.findViewById(R.id.siv_userImage)
        siv_userImage.background = null

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
    }
}