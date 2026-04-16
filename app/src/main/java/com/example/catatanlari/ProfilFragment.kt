package com.example.catatanlari

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.catatanlari.databinding.FragmentProfilBinding

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!
    private val args: ProfilFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tampilkan data yang dikirim dari Beranda
        binding.apply {
            tvDisplayName.text = args.userName
            tvDisplayGender.text = args.userGender
            tvDisplayEmail.text = args.userEmail
            tvNama.text = args.userName

            buttonLogout.setOnClickListener {
                // Navigasi balik ke Welcome atau Login
                findNavController().navigate(R.id.action_profilFragment_to_welcomeFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}