package com.example.satriaadhipradana.utills

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {

    private const val PREF = "preferences"
    private const val LOGIN = "login"

    private lateinit var mPreferences: SharedPreferences

    fun getPreferences(context: Context): SharedPreferences {
        mPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return mPreferences
    }

    fun rememberUserInSystem(isLogin: Boolean) {
        mPreferences.edit().putBoolean(LOGIN, isLogin).apply()
    }

    fun findInfoUserInSystem(): Boolean {
        return mPreferences.getBoolean(LOGIN, false)
    }
}