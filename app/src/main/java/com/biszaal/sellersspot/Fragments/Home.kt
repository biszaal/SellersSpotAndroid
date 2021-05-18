package com.biszaal.sellersspot.Fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.biszaal.sellersspot.Post
import com.biszaal.sellersspot.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class Home : Fragment()
{
    private lateinit var sv_searchBar: SearchView
    private lateinit var rv_postsView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        sv_searchBar = view.findViewById(R.id.sv_searchBar)
        rv_postsView = view.findViewById(R.id.rv_postsView)

        sv_searchBar.onActionViewExpanded()
        sv_searchBar.queryHint = "Search"
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadPost()
    }


    private fun loadPost()
    {

        val postListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot)
            {
                val post = snapshot.getValue<Post>()
                Log.i("firebase", "Got value $post")
            }

            override fun onCancelled(error: DatabaseError)
            {
                Log.w(TAG, "loadPost:onCancelled", error.toException())
            }

        }

        print(postListener)
    }

}
