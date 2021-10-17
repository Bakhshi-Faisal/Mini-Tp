package com.example.minitp.model

sealed class MyObjectForRecyclerView()

data class ObjectDataHeaderSample(
    val header: String
) : MyObjectForRecyclerView()

data class ObjectDataSample(
    val nomBoisson : String,
    val prix : Float
) : MyObjectForRecyclerView()

data class ObjectDataFooterSample(
    val footerText: String,
) : MyObjectForRecyclerView()
