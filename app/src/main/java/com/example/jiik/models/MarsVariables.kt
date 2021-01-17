package com.example.jiik.models

import com.squareup.moshi.Json

data class MarsVariables(
        val id: String = "515495",
        @Json(name = "img_src") val imgSrc: String = "https://mars.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044631140305211C00_DXXX.jpg",
        val price: Int = 13000000 ,
        val type: String = "rent"
)