package com.example.retrofitexample.model

/*
    Json Structure
    { -> the beginning of a new object
    [ -> the beginning of a new array/list
 */

// root response
data class ITunesResponse(
    val results: List<ITunesSong>
)

data class ITunesSong(

    val artistName : String,
    val collectionName : String,
    val artworkUrl60 : String,
    val trackPrice : String,
    val previerwUrl : String
) {
}
