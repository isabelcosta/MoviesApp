package com.example.isabelcosta.moviesapp.data.models

import com.google.gson.annotations.SerializedName

data class NowPlayingListResponseData(
        @SerializedName("results") val results: List<NowPlayingListItemResponseData>,
        @SerializedName("page") val pageNumber: Int,
        @SerializedName("total_results") val totalNumberOfResults: Int,
        @SerializedName("dates") val dates: NowPlayingListDatesResponseData,
        @SerializedName("total_pages") val totalNumberOfPages: Int
)

data class NowPlayingListDatesResponseData(
        @SerializedName("maximum") val maximumDate: String,
        @SerializedName("minimum") val minimumDate: String
)

data class NowPlayingListItemResponseData(
        @SerializedName("vote_count") val voteCount: Int,
        @SerializedName("id") val movieId: Int,
        @SerializedName("video") val video: Boolean,
        @SerializedName("vote_average") val voteAverage: Float,
        @SerializedName("title") val movieTitle: String,
        @SerializedName("popularity") val popularity: Double,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("original_language") val originalLanguage: String,
        @SerializedName("backdrop_path") val backdropPath: String,
        @SerializedName("overview") val overview: String,
        @SerializedName("release_date") val releaseDate: String,
        @SerializedName("adult") val adult: Boolean,
        @SerializedName("genre_ids") val genreIds: List<Int>
)