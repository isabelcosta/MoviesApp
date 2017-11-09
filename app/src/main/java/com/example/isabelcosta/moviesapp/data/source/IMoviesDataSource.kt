package com.example.isabelcosta.moviesapp.data.source

import com.example.isabelcosta.moviesapp.data.models.MovieDetailResponseData
import com.example.isabelcosta.moviesapp.data.models.NowPlayingListResponseData

interface IMoviesDataSource {

    interface GetNowPlayingMovies {
        fun onSuccessGetNowPlayingMovies(movies: NowPlayingListResponseData)
        fun onFailGetNowPlayingMovies()
    }

    interface GetMovieDetail {
        fun onSuccessGetMovieDetail(movieDetail: MovieDetailResponseData)
        fun onFailGetMovieDetail()
    }

    fun getNowPlayingMovies(presenter: IMoviesDataSource.GetNowPlayingMovies)
    fun getMovieDetail(presenter: IMoviesDataSource.GetMovieDetail, movieId: Int)

}