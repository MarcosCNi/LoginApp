package com.example.loginapp.ui.activity.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.loginapp.databinding.FragmentLoginBinding
import com.example.loginapp.ui.activity.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel by viewModels()


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickAdapter()
    }

    private fun clickAdapter() = with(binding) {
        signInBtn.setOnClickListener{
            if(viewModel.checkUser(editTextUser.text.toString(), editTextPassword.text.toString())){

                val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
                view?.let { it1 -> Navigation.findNavController(it1).navigate(action) }
                Toast.makeText(context, "Usuario e senha corretos", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Usuario e senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }
    }

}