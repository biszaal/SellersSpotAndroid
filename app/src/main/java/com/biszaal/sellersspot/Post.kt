package com.biszaal.sellersspot

import com.google.firebase.database.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
public data class Post(
    var id: String? = "",
    var userId: String? = "",
    var postName: String? = "",
    var postImage: List<String>? = emptyList(),
    var postDescription: String? = "",
    var postPrice: String? = "",
    var postLocation: String? = "",
    var postDate: String? = "",
    var postLike: Map<String, String>? = emptyMap<String, String>(),
    var postDislike: Map<String, String>? = emptyMap<String, String>()

)
