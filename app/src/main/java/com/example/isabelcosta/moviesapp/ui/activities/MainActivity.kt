package com.example.isabelcosta.moviesapp.ui.activities

import android.os.Bundle
import com.example.isabelcosta.moviesapp.R
import com.example.isabelcosta.moviesapp.ui.fragments.NowPlayingMoviesFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager
                .beginTransaction()
                .replace(R.id.mainActivityFrameLayout, NowPlayingMoviesFragment.newInstance())
                .commit()
    }
}
