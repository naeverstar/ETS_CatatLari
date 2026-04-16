package com.example.catatanlari

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.catatanlari.databinding.FragmentRegistrasiBinding

class RegistrasiFragment : Fragment() {

    private var _binding: FragmentRegistrasiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val namaLengkap = binding.etName.text.toString()
            val gender = binding.etGender.text.toString()
            val email = binding.etEmailRegister.text.toString()
            val password = binding.etPasswordRegister.text.toString()

            if (namaLengkap.isEmpty() || gender.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Registrasi berhasil!", Toast.LENGTH_SHORT).show()
                val action = RegistrasiFragmentDirections.actionRegistrasiFragmentToBerandaFragment(
                    userEmail = email,
                    userName = namaLengkap,
                    userGender = gender
                )
                findNavController().navigate(action)
            }
        }

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(
                RegistrasiFragmentDirections.actionRegistrasiFragmentToBerandaFragment(
                    userEmail = "User",
                    userName = "User",
                    userGender = "-"
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}