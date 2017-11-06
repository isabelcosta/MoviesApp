package com.example.isabelcosta.moviesapp.data.entities

import com.fasterxml.jackson.annotation.JsonProperty

data class NowPlayingListResponseData(
        @JsonProperty("results") val results : List<NowPlayingListItemResponseData>,
        @JsonProperty("page") val pageNumber : Int,
        @JsonProperty("total_results") val totalNumberOfResults : Int,
        @JsonProperty("dates") val dates : NowPlayingListDatesResponseData,
        @JsonProperty("total_pages") val totalNumberOfPages : Int
)

data class NowPlayingListDatesResponseData(
        @JsonProperty("maximum") val maximumDate : String,
        @JsonProperty("minimum") val minimumDate : String
)

data class NowPlayingListItemResponseData(
        @JsonProperty("vote_count") val voteCount: Int,
        @JsonProperty("id") val id : Int,
        @JsonProperty("video") val video : Boolean,
        @JsonProperty("vote_average") val voteAverage : Float,
        @JsonProperty("title") val movieTitle : String,
        @JsonProperty("popularity") val popularity : Int,
        @JsonProperty("poster_path") val posterPath : String,
        @JsonProperty("original_language") val originalLanguage : String,
        @JsonProperty("backdrop_path") val backdropPath : String,
        @JsonProperty("overview") val overview : String,
        @JsonProperty("release_date") val releaseDate : String,
        @JsonProperty("adult") val adult : Boolean,
        @JsonProperty("genre_ids") val genreIds : Array<Int>
)