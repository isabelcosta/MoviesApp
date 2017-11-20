package com.example.isabelcosta.moviesapp.presenters

import com.example.isabelcosta.moviesapp.data.models.MovieDetailResponseData
import com.example.isabelcosta.moviesapp.data.remote.MoviesRemoteDataSource
import com.example.isabelcosta.moviesapp.data.source.IMoviesDataSource
import com.example.isabelcosta.moviesapp.ui.callbacks.IMovieDetailUiCallback

class MovieDetailPresenter(private val uiCallback: IMovieDetailUiCallback) : IMoviesDataSource.GetMovieDetail{

    private val remoteDataSource = MoviesRemoteDataSource()

    fun getMovieDetail(movieId: Int) = remoteDataSource.getMovieDetail(this, movieId)

    override fun onSuccessGetMovieDetail(movieDetail: MovieDetailResponseData) = uiCallback.onShowMovieDetail(movieDetail)

    override fun onFailGetMovieDetail() = uiCallback.onFetchFailMovieDetail()
}
