package com.example.satriaadhipradana.presentation.fragments.login

import android.os.Build
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.domain.models.UserModel
import com.example.satriaadhipradana.R
import com.example.satriaadhipradana.databinding.FragmentLoginBinding
import com.example.satriaadhipradana.utills.AppPreferences
import com.example.satriaadhipradana.utills.BUNDLE_LOGIN
import com.example.satriaadhipradana.utills.hideKeyBoard
import com.example.satriaadhipradana.utills.showSnackBarError
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null
    private val mBinding get() = binding!!

    private var mUserModel = UserModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        validationData()
        visiblePassword()
    }

    private fun visiblePassword() {
        mBinding.apply {
            password.apply {
                visiblePassword.setOnClickListener {
                    if (transformationMethod == PasswordTransformationMethod.getInstance()) {
                        transformationMethod = HideReturnsTransformationMethod.getInstance()
                        setSelection(length())
                    } else {
                        transformationMethod = PasswordTransformationMethod.getInstance()
                        setSelection(length())
                    }
                }
            }
        }
    }

    private fun validationData() {
        mUserModel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable(BUNDLE_LOGIN, mUserModel::class.java) ?: UserModel()
        } else {
            arguments?.getSerializable(BUNDLE_LOGIN) as UserModel
        }

        mBinding.apply {
            login.setOnClickListener {
                it.hideKeyBoard()

                if(firstName.text.toString() == mUserModel.firstName && password.text.toString() == mUserModel.email){
                    AppPreferences.rememberUserInSystem(true)
                    findNavController().navigate(R.id.action_loginFragment_to_page1Fragment)
                }
                else{
                    showSnackBarError(firstName, getString(R.string.user_doesnt_exist), context)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}