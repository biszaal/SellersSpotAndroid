package com.biszaal.sellersspot.Fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.biszaal.sellersspot.EachPostView
import com.biszaal.sellersspot.Post
import com.biszaal.sellersspot.R
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*

class Home : Fragment() {
    private lateinit var et_searchBar: EditText
    private lateinit var rv_postsView: RecyclerView

    private lateinit var database: DatabaseReference
    private lateinit var postList: ArrayList<Post>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        et_searchBar = view.findViewById(R.id.et_searchBar)
        rv_postsView = view.findViewById(R.id.rv_postsView)

        rv_postsView.setHasFixedSize(true)

        postList = arrayListOf<Post>()
        loadPost()

        return view
    }

    fun loadPost() {
        database = FirebaseDatabase.getInstance().getReference("posts")

            database.addValueEventListener(
                object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        // check if data exists or not
                        if (snapshot!!.exists()) {
                            for (child in snapshot.children) {
                                val post = child.getValue(Post::class.java)
                                postList.add(post!!)
                            }

                            Log.i(TAG,"Got Value $postList")

                            rv_postsView.adapter = EachPostView(postList)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w(TAG, "loadPost:onCancelled", error.toException())
                    }

                })
    }

}
