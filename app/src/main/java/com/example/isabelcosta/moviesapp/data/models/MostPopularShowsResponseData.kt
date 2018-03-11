package com.example.isabelcosta.moviesapp.data.models

import com.google.gson.annotations.SerializedName

data class MostPopularShowsListResponseData(
        @SerializedName("page") val page: Int, //1
        @SerializedName("total_results") val totalResults: Int, //20022
        @SerializedName("total_pages") val totalPages: Int, //1002
        @SerializedName("results") val results: List<MostPopularShowsListItemResponseData>
)

data class MostPopularShowsListItemResponseData(
		@SerializedName("original_name") val originalName: String, //The Walking Dead
		@SerializedName("genre_ids") val genreIds: List<Int>,
		@SerializedName("name") val name: String, //The Walking Dead
		@SerializedName("popularity") val popularity: Double, //232.631301
		@SerializedName("origin_country") val originCountry: List<String>,
		@SerializedName("vote_count") val voteCount: Int, //2608
		@SerializedName("first_air_date") val firstAirDate: String, //2010-10-31
		@SerializedName("backdrop_path") val backdropPath: String, ///xVzvD5BPAU4HpleFSo8QOdHkndo.jpg
		@SerializedName("original_language") val originalLanguage: String, //en
		@SerializedName("movieId") val showId: Int, //1402
		@SerializedName("vote_average") val voteAverage: Double, //7.4
		@SerializedName("overview") val overview: String, //Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.
		@SerializedName("poster_path") val posterPath: String ///vxuoMW6YBt6UsxvMfRNwRl9LtWS.jpg
)
