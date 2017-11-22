package com.example.isabelcosta.moviesapp.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by IsabelCosta on 20-11-2017.
 */

data class MovieSearchResultsListResponseData(
        @SerializedName("page") val page: Int, //1
        @SerializedName("results") val results: List<MovieSearchResultsItemResponseData>,
        @SerializedName("total_results") val totalResults: Int, //14
        @SerializedName("total_pages") val totalPages: Int //1
)

data class MovieSearchResultsItemResponseData(
		@SerializedName("poster_path") val posterPath: String, ///cezWGskPY5x7GaglTTRN4Fugfb8.jpg
		@SerializedName("adult") val adult: Boolean, //false
		@SerializedName("overview") val overview: String, //When an unexpected enemy emerges and threatens global safety and security, Nick Fury, director of the international peacekeeping agency known as S.H.I.E.L.D., finds himself in need of a team to pull the world back from the brink of disaster. Spanning the globe, a daring recruitment effort begins!
		@SerializedName("release_date") val releaseDate: String, //2012-04-25
		@SerializedName("genre_ids") val genreIds: List<Int>,
		@SerializedName("id") val movieId: Int, //24428
		@SerializedName("original_title") val originalTitle: String, //The Avengers
		@SerializedName("original_language") val originalLanguage: String, //en
		@SerializedName("title") val title: String, //The Avengers
		@SerializedName("backdrop_path") val backdropPath: String, ///hbn46fQaRmlpBuUrEiFqv0GDL6Y.jpg
		@SerializedName("popularity") val popularity: Double, //7.353212
		@SerializedName("vote_count") val voteCount: Int, //8503
		@SerializedName("video") val video: Boolean, //false
		@SerializedName("vote_average") val voteAverage: Double //7.33
)