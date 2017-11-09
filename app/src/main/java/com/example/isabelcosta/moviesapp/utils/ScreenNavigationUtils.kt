package com.example.isabelcosta.moviesapp.utils

import android.app.FragmentManager
import com.example.isabelcosta.moviesapp.ui.activities.MainActivity
import com.example.isabelcosta.moviesapp.ui.fragments.BaseFragment

fun replaceActivityFragment(fragmentManager: FragmentManager, containerId: Int, fragment: BaseFragment<MainActivity>) {
    fragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .commit()
}
