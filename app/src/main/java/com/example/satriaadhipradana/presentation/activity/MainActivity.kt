package com.example.satriaadhipradana.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.satriaadhipradana.R
import com.example.satriaadhipradana.databinding.ActivityMainBinding
import com.example.satriaadhipradana.utills.AppPreferences
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mNavController: NavController
    private lateinit var binding: ActivityMainBinding

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        binding.apply {
            bottomNavigationView = bottomNav
        }
        setContentView(view)

        AppPreferences.getPreferences(this)
        initNavigation()
        if (AppPreferences.findInfoUserInSystem()){
            mNavController.navigate(R.id.action_signInPageFragment_to_page1Fragment)
        }
    }

    private fun initNavigation(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        mNavController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(mNavController)
    }

    fun hideBottomNav(hide : Boolean){
        if(hide){
            bottomNavigationView.visibility = View.GONE
        }
        else{
            bottomNavigationView.visibility = View.VISIBLE
        }
    }
}