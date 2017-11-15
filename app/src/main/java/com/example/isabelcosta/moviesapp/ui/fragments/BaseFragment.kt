package com.example.isabelcosta.moviesapp.ui.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.isabelcosta.moviesapp.ui.activities.BaseActivity

abstract class BaseFragment<S : BaseActivity> : Fragment() {

    protected lateinit var screen: S
    protected lateinit var rootView : ViewGroup

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screen = activity as S
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater?.inflate(getLayoutResourceId(), container, false) as ViewGroup
        return rootView
    }

    protected abstract fun getLayoutResourceId() : Int

    protected abstract fun getTitleResourceId() : Int
}