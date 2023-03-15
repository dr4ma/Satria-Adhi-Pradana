package com.example.satriaadhipradana.presentation.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.satriaadhipradana.R
import com.example.satriaadhipradana.databinding.FragmentProfileBinding
import com.example.satriaadhipradana.presentation.activity.MainActivity
import com.example.satriaadhipradana.utills.AppPreferences

class ProfileFragment : Fragment() {

    private var binding: FragmentProfileBinding? = null
    private val mBinding get() = binding!!

    private lateinit var selectImageIntent: ActivityResultLauncher<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initChangePhoto()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFields()
        initLogOut()
    }

    private fun initLogOut() {
        mBinding.logOut.setOnClickListener {
            AppPreferences.rememberUserInSystem(false)
            (activity as MainActivity).hideBottomNav(true)
            findNavController().navigate(R.id.action_profileFragment_to_signInPageFragment)
        }
    }

    private fun initChangePhoto() {
        selectImageIntent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            if (uri != null) {
                mBinding.profilePhoto.setImageURI(uri)
            }
        }
    }

    private fun initFields() {
        mBinding.apply {
            changePhotoLabel.setOnClickListener {
                selectImageIntent.launch("image/*")
            }
            backPressed.setOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}