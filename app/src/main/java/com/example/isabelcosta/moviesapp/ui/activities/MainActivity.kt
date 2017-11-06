package com.example.isabelcosta.moviesapp.ui.activities

import android.os.Bundle
import com.example.isabelcosta.moviesapp.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val nowPlayingFragment = fragmentManager.findFragmentById(R.id.mainActivityFrameLayout)
//                as NowPlayingMoviesFragment? ?:
//                fragmentManager
//                        .beginTransaction()
//                        .replace(R.id.mainActivityFrameLayout, NowPlayingMoviesFragment.newInstance())
//                        .commit()
    }
}
