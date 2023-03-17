package com.example.satriaadhipradana.presentation.fragments.details

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.domain.models.DetailsModel
import com.example.satriaadhipradana.R
import com.example.satriaadhipradana.databinding.FragmentDetailsBinding
import com.example.satriaadhipradana.utills.TabSelectedListener
import com.example.satriaadhipradana.utills.downloadIcon
import com.example.satriaadhipradana.utills.dpToPx
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
@SuppressLint("SetTextI18n")
class DetailsFragment : Fragment() {

    private var binding: FragmentDetailsBinding? = null
    private val mBinding get() = binding!!
    private val mViewModel: DetailsViewModel by viewModels()
    private var mSummaryPrice = 0.0
    private var mPrice = 0.0

    @Inject
    lateinit var mMainPageAdapter: MainPageAdapter

    private var mTabView : ConstraintLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFields()
        initTabLayoutIndicator()
        initDetails()
    }

    private fun initDetails() {
        mViewModel.details.observe(viewLifecycleOwner) {
            mMainPageAdapter.setList(it.image_urls)
            attachElementsTabLayout(it)

            mBinding.apply {
                name.text = it.name
                price.text = "$ ${it.price}0"
                summaryPrice.text ="$${it.price}00"
                description.text = it.description
                rating.text = it.rating.toString()
                reviews.text = "(${it.number_of_reviews} reviews)"
                mSummaryPrice = it.price
                mPrice = it.price

                firstColor.backgroundTintList = ColorStateList.valueOf(Color.parseColor(it.colors[0]))
                secondColor.backgroundTintList = ColorStateList.valueOf(Color.parseColor(it.colors[1]))
                thirdColor.backgroundTintList = ColorStateList.valueOf(Color.parseColor(it.colors[2]))
            }
        }
        mViewModel.getDetails()
    }

    private fun initFields(){
        mBinding.apply {
            pagerImagesDetails.adapter = mMainPageAdapter
            addFavorites.setOnClickListener {
                it.isSelected = !it.isSelected
            }
            backPressed.setOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
            firstColor.setOnClickListener {
                initChooseColor(it as MaterialButton)
            }
            secondColor.setOnClickListener {
                initChooseColor(it as MaterialButton)
            }
            thirdColor.setOnClickListener {
                initChooseColor(it as MaterialButton)
            }
            minus.setOnClickListener {
                if(mSummaryPrice != 0.0){
                    mSummaryPrice -= mPrice
                    summaryPrice.text = "$${mSummaryPrice}00"
                }
            }
            plus.setOnClickListener {
                mSummaryPrice += mPrice
                summaryPrice.text = "$${mSummaryPrice}00"
            }
        }
    }

    private fun initTabLayoutIndicator(){
        TabLayoutMediator(mBinding.tabIndicator, mBinding.pagerImagesDetails) { tab, _ ->
            mBinding.pagerImagesDetails.setCurrentItem(tab.position, true)
        }.attach()

        mBinding.tabIndicator.addOnTabSelectedListener(TabSelectedListener(75, 50, mTabView))
    }

    private fun attachElementsTabLayout(model : DetailsModel){
        for (i in 0..mBinding.tabIndicator.tabCount) {
            mBinding.tabIndicator.getTabAt(i)?.setCustomView(R.layout.item_indicator_details)
            val image = mBinding.tabIndicator.getTabAt(i)?.customView?.findViewById<ImageView>(R.id.image_indicator)
            image?.downloadIcon(model.image_urls[i])
        }
        mTabView = mBinding.tabIndicator.getTabAt(0)?.customView?.findViewById(R.id.tab_card)
        mTabView?.layoutParams = LinearLayout.LayoutParams(100.dpToPx(), 60.dpToPx())
    }

    private fun initChooseColor(view: MaterialButton) {
        val listViews = mutableListOf(mBinding.firstColor, mBinding.secondColor, mBinding.thirdColor)
        listViews.forEach {
            if (it.id == view.id) {
                it.strokeWidth = 2.dpToPx()
            } else {
                it.strokeWidth = 0.dpToPx()
            }
        }
    }
}