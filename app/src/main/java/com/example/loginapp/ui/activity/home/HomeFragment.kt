package com.example.loginapp.ui.activity.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.loginapp.databinding.FragmentHomeBinding
import com.example.loginapp.model.UserModel
import com.example.loginapp.ui.activity.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createUser()
    }

    private fun createUser() = with(binding) {
        addUserButton.setOnClickListener{
            if (editTextCPF.text.isNotEmpty() && editTextName.text.isNotEmpty()){
                val user = UserModel(
                    code = editTextCode.text.toString(),
                    name = editTextName.text.toString(),
                    cpf = editTextCPF.text.toString(),
                    address = editTextAddress.text.toString(),
                    phone = editTextPhone.text.toString()
                )
                viewModel.save(user)
                Toast.makeText(context, "Pessoa cadastrada com sucesso, código " + user.cpf.substring(0, 4), Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(context, "Os campos nome e CPF São obrigatorios", Toast.LENGTH_SHORT).show()
            }
        }
    }

}