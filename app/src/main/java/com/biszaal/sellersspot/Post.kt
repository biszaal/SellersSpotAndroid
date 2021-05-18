package com.biszaal.sellersspot

import java.util.*

data class Post(
    var id: String,
    var userId: String,
    var postName: String,
    var postImage: List<String?>,
    var postDescription: String,
    var postPrice: Float,
    var postLocation: String,
    var postDate: Date,
    var postLike: List<String>,
    var postDislike: List<String>


)