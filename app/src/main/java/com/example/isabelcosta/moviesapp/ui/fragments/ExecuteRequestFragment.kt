package com.example.isabelcosta.moviesapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.ui.activities.MainActivity

abstract class ExecuteRequestFragment: BaseFragment<MainActivity>() {
    
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater?.inflate(R.layout.fragment_execute_request, container, false) as ViewGroup

        val containedFragment = inflater?.inflate(getLayoutResourceId(), rootView, false) as ViewGroup

        rootView.addView(containedFragment)

        return rootView
    }

    fun showLoader() {

    }

    fun hideLoader() {

    }

}