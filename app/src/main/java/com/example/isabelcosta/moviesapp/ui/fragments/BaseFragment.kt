package com.example.isabelcosta.moviesapp.ui.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    lateinit var rootView : ViewGroup

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater?.inflate(getLayoutResourceId(), container) as ViewGroup
        return rootView
    }

    protected abstract fun getLayoutResourceId() : Int
}