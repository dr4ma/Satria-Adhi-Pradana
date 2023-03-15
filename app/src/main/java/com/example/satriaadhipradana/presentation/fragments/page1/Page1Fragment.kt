package com.example.satriaadhipradana.presentation.fragments.page1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.widget.SearchView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.satriaadhipradana.R
import com.example.satriaadhipradana.databinding.FragmentPage1Binding
import com.example.satriaadhipradana.presentation.activity.MainActivity
import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.MainAdapter
import com.example.satriaadhipradana.utills.createListCategory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Page1Fragment : Fragment() {

    private var binding: FragmentPage1Binding? = null
    private val mBinding get() = binding!!
    private lateinit var mRecyclerCategories: RecyclerView
    private lateinit var mRecyclerLatest: RecyclerView
    private lateinit var mRecyclerFlashSales: RecyclerView
    private lateinit var mWordsRecycler: RecyclerView

    private val mViewModel: Page1ViewModel by viewModels()

    @Inject
    lateinit var mSearchAdapter : SearchAdapter
    @Inject
    lateinit var mAdapterCategories: MainAdapter
    @Inject
    lateinit var mAdapterLatest: MainAdapter
    @Inject
    lateinit var mAdapterFlashSale: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPage1Binding.inflate(layoutInflater, container, false)
        mBinding.apply {
            mRecyclerCategories = categoriesRecycler
            mRecyclerLatest = latestRecycler
            mRecyclerFlashSales = flashSaleRecycler
            mWordsRecycler = wordsRecycler
        }
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFields()
        initCategories()
        initObservers()
    }

    private fun initFields() {
        (activity as MainActivity).hideBottomNav(false)
        mBinding.photoProfilePage1.setOnClickListener {
            findNavController().navigate(R.id.action_page1Fragment_to_profileFragment)
        }

        mBinding.search.addTextChangedListener {
            if(mBinding.search.text.toString() != ""){
                mBinding.searchIcon.visibility = View.INVISIBLE
                mViewModel.getWords(mBinding.search.text.toString())
            }
            else{
                mWordsRecycler.adapter = null
                mBinding.searchIcon.visibility = View.VISIBLE
            }
        }
    }

    private fun initObservers() {
        // Latest
        mViewModel.latestList.observe(viewLifecycleOwner) {
            mAdapterLatest.setItems(it) {
                mBinding.latestProgress.visibility = View.GONE
                mRecyclerLatest.adapter = mAdapterLatest
            }
        }
        // FlashSales
        mViewModel.flashSale.observe(viewLifecycleOwner) {
            mAdapterFlashSale.setItems(it) {
                mBinding.flashSalesProgress.visibility = View.GONE
                mRecyclerFlashSales.adapter = mAdapterFlashSale
            }
        }
        // Words Search
        mViewModel.words.observe(viewLifecycleOwner){
            if(mBinding.search.text.toString() != ""){
                mWordsRecycler.adapter = mSearchAdapter
                mSearchAdapter.setList(it)
            }
        }
        mViewModel.getPage1Info()
    }

    private fun initCategories() {
        mAdapterCategories.setItems(createListCategory(context)){
            mRecyclerCategories.adapter = mAdapterCategories
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object{
        fun navigateToDetails(view: View){
            view.findNavController().navigate(R.id.action_page1Fragment_to_detailsFragment)
        }
    }
}