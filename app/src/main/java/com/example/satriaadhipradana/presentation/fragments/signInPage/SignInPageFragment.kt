package com.example.satriaadhipradana.presentation.fragments.signInPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.models.UserModel
import com.example.domain.usecases.UserUseCase
import com.example.domain.utills.RealmState
import com.example.satriaadhipradana.R
import com.example.satriaadhipradana.databinding.FragmentSignInPageBinding
import com.example.satriaadhipradana.utills.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInPageFragment : Fragment() {

    private var binding: FragmentSignInPageBinding? = null
    private val mBinding get() = binding!!

    private val mViewModel: SignInPageViewModel by viewModels()
    private var mUserModel = UserModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInPageBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        validationData()
        mBinding.accountLogin.setOnClickListener {
            navigateToLogin(mUserModel)
        }
    }

    private fun initObservers(){
        mViewModel.userModel.observe(viewLifecycleOwner){
            mUserModel = it
        }
        mViewModel.getUserModel()
    }

    private fun validationData(){
        mBinding.apply {
            signIn.setOnClickListener {
                it.hideKeyBoard()

                if(firstName.text.isEmpty() || lastName.text.isEmpty()){
                    showSnackBarError(firstName, getString(R.string.name_not_empty), context)
                }
                else if(!email.text.toString().isEmailValid()){
                    showSnackBarError(firstName, getString(R.string.email_not_correct), context)
                }
                else{
                    if(email.text.toString() != mUserModel.email){

                        mViewModel.insertOrUpdateUserModel(firstName.text.toString(), lastName.text.toString(), email.text.toString(), {
                            AppPreferences.rememberUserInSystem(true)
                            findNavController().navigate(R.id.action_signInPageFragment_to_page1Fragment)

                        }, {
                            showSnackBarError(firstName, getString(R.string.error_save_data), context)
                        })
                    }
                    else{
                        showSnackBarError(firstName, getString(R.string.user_exist), context)
                    }
                }
            }
        }
    }

    private fun navigateToLogin(model : UserModel){
        val bundle = Bundle()
        bundle.putSerializable(BUNDLE_LOGIN, model)
        findNavController().navigate(R.id.action_signInPageFragment_to_loginFragment, bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}