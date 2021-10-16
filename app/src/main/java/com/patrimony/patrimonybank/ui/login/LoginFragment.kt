package com.patrimony.patrimonybank.ui.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        onClick()

        return binding.root
    }

    private fun onClick() {
        binding.btnLogin.setOnClickListener {
            //TODO fazer lógica dessa budega
            if (viewModel.validateLogin(
                    binding.editCpf.text.toString(),
                    binding.editPassword.text.toString(),
                    requireContext()
                )
            ) {

            } else {

            }


            //if success
            onBoardingFinished()
        }
    }


    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}