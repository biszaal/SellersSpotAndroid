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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class Home : Fragment() {
    private lateinit var sv_searchBar: SearchView
    private lateinit var rv_postsView: RecyclerView

    private lateinit var database: DatabaseReference
    private lateinit var postList: MutableList<Post>

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


    private fun loadPost() {
        postList = mutableListOf()
        database = Firebase.database.reference.child("posts")

        database.addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // check if data exists or not
                    if (snapshot!!.exists()) {
                        for (child in snapshot.children) {
                            val post = child.getValue() as HashMap<*, *>
                            val postClass = Post()
                            with(postClass)
                            {
                                id = child.key.toString()
                                userId = post ["userId"].toString()
                                postName = post ["postName"].toString()
                                postImage = post ["postImage"] as List<String>?
                                postDescription = post ["postDescription"].toString()
                                postPrice = post ["postPrice"].toString()
                                postLocation = post ["postLocation"].toString()
                                postDate = post ["postDate"].toString()
                                postLike = post ["postLike"] as Map<String, String>?
                                postDislike = post ["postDislike"] as Map<String, String>?

                            }
                            postList.add(postClass)
                            Log.i(TAG, "got value ${postList}")
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w(TAG, "loadPost:onCancelled", error.toException())
                }

            })
        print(postList)
    }

}
