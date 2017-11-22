package com.example.isabelcosta.moviesapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.extensions.hideFully
import com.example.isabelcosta.moviesapp.extensions.show
import com.example.isabelcosta.moviesapp.ui.activities.BaseActivity
import com.example.isabelcosta.moviesapp.ui.callbacks.ILoadingUiCallback
import kotlinx.android.synthetic.main.fragment_execute_request.*

abstract class ExecuteRequestFragment<S : BaseActivity>: BaseFragment<S>(), ILoadingUiCallback {
    
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        rootView = inflater?.inflate(R.layout.fragment_execute_request, container, false) as ViewGroup

        val containedFragment = inflater?.inflate(getLayoutResourceId(), rootView, false)

        rootView.addView(containedFragment, 0)

        return rootView
    }

    override fun showLoader() {
        executeFragmentContainer.hideFully()
        loadingContainerView.show()
    }

    override fun hideLoader() {
        loadingContainerView.hideFully()
        executeFragmentContainer.show()
    }

}