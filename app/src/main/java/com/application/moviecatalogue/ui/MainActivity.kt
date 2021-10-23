package com.application.moviecatalogue.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.application.moviecatalogue.R
import com.application.moviecatalogue.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var mainBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding?.root)

        val bottomNavigationView = mainBinding?.bottomNavMain
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
        if (bottomNavigationView != null) {
            NavigationUI.setupWithNavController(
                bottomNavigationView,
                navHostFragment.navController
            )
        }
    }
}