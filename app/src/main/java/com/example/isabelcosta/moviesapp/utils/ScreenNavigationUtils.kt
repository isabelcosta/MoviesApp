package com.example.isabelcosta.moviesapp.utils

import android.app.FragmentManager
import android.view.View
import android.view.ViewGroup
import com.example.isabelcosta.moviesapp.ui.activities.MainActivity
import com.example.isabelcosta.moviesapp.ui.fragments.BaseFragment

fun replaceActivityFragment(fragmentManager: FragmentManager, containerId: Int, fragment: BaseFragment<MainActivity>) {
    fragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(null)
            .commit()
}

fun addFragmentToActivity(fragmentManager: FragmentManager, containerId: Int, fragment: BaseFragment<MainActivity>) {
    fragmentManager
            .beginTransaction()
            .add(containerId, fragment)
            .commit()
}

fun ViewGroup.addViewToFirstIndex(containedFragment: View) = this.addView(containedFragment, 0)
