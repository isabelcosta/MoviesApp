package com.example.isabelcosta.moviesapp.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by IsabelCosta on 09-11-2017.
 */

data class MovieDetailResponseData(
        @SerializedName("adult") val adult: Boolean, //false
        @SerializedName("backdrop_path") val backdropPath: String, ///tcheoA2nPATCm2vvXw2hVQoaEFD.jpg
        @SerializedName("belongs_to_collection") val belongsToCollection: Any, //null
        @SerializedName("budget") val budget: Int, //35000000
        @SerializedName("genres") val genres: List<GenreResponseData>,
        @SerializedName("homepage") val homepage: String, //http://itthemovie.com/
        @SerializedName("id") val movieId: Int, //346364
        @SerializedName("imdb_id") val imdbId: String, //tt1396484
        @SerializedName("original_language") val originalLanguage: String, //en
        @SerializedName("original_title") val originalTitle: String, //It
        @SerializedName("overview") val overview: String, //In a small town in Maine, seven children known as The Losers Club come face to face with life problems, bullies and a monster that takes the shape of a clown called Pennywise.
        @SerializedName("popularity") val popularity: Double, //693.365693
        @SerializedName("poster_path") val posterPath: String, ///9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg
        @SerializedName("production_companies") val productionCompanies: List<ProductionCompanyResponseData>,
        @SerializedName("production_countries") val productionCountries: List<ProductionCountryResponseData>,
        @SerializedName("release_date") val releaseDate: String, //2017-09-05
        @SerializedName("revenue") val revenue: Int, //555575232
        @SerializedName("runtime") val runtime: Int, //135
        @SerializedName("spoken_languages") val spokenLanguages: List<SpokenLanguageResponseData>,
        @SerializedName("status") val status: String, //Released
        @SerializedName("tagline") val tagLine: String, //Your fears are unleashed
        @SerializedName("title") val title: String, //It
        @SerializedName("video") val video: Boolean, //false
        @SerializedName("vote_average") val voteAverage: Double, //7.3
        @SerializedName("vote_count") val voteCount: Int //3483
)

data class SpokenLanguageResponseData(
        @SerializedName("iso_639_1") val languageCode: String, //en
		@SerializedName("name") val name: String //English
)

data class GenreResponseData(
        @SerializedName("id") val id: Int, //18
        @SerializedName("name") val name: String //Drama
)

data class ProductionCompanyResponseData(
		@SerializedName("name") val name: String, //New Line Cinema
		@SerializedName("id") val id: Int //12
)

data class ProductionCountryResponseData(
        @SerializedName("iso_639_1") val countryCode: String, //US
		@SerializedName("name") val name: String //United States of America
)