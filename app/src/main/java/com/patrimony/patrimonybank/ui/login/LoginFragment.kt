package com.patrimony.patrimonybank.ui.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.patrimony.patrimonybank.R
import com.patrimony.patrimonybank.databinding.FragmentLoginBinding
import com.patrimony.patrimonybank.utils.BaseFragment

class LoginFragment : BaseFragment() {

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
            doLogin()

        }
    }

    private fun doLogin() {
        findNavController().navigate(R.id.action_loginFragment2_to_homeFragment)

//        if (viewModel.validateLogin(
//                binding.editCpfCnpj.text.toString(),
//                binding.editPassword.text.toString(),
//                requireContext()
//            )
//        ) {
//            viewModel.doLogin(
//                binding.editCpfCnpj.text.toString(),
//                binding.editPassword.text.toString()
//            ).observe(viewLifecycleOwner, Observer {
//                if (it) {
//                    findNavController().navigate(R.id.action_loginFragment2_to_homeFragment)
//                } else {
//                    viewModel.loginError.observe(viewLifecycleOwner, Observer { msgError ->
//                        showToast(msgError)
//                    })
//                }
//            })
//
//        } else {
//            viewModel.loginError.observe(viewLifecycleOwner, Observer {
//                showToast(it)
//            })
//        }
    }


    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}