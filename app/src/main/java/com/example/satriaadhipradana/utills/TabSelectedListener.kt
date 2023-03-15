package com.example.satriaadhipradana.utills

import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.satriaadhipradana.R
import com.google.android.material.tabs.TabLayout

class TabSelectedListener(
    private val width: Int,
    private val height: Int,
    private var mTabView: ConstraintLayout?
) : TabLayout.OnTabSelectedListener {

    override fun onTabSelected(tab: TabLayout.Tab?) {
        mTabView = tab?.customView?.findViewById(R.id.tab_card)
        mTabView?.layoutParams = LinearLayout.LayoutParams((width + 25).dpToPx(), (height + 10).dpToPx())
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        mTabView = tab?.customView?.findViewById(R.id.tab_card)
        mTabView?.layoutParams = LinearLayout.LayoutParams(width.dpToPx(), height.dpToPx())
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }
}