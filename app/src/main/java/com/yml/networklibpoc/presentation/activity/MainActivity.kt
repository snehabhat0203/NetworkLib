package com.yml.networklibpoc.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yml.networklibpoc.R
import com.yml.networklibpoc.presentation.fragment.UniversityListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, UniversityListFragment.getInstance())
            .commit()
    }
}