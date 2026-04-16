package com.example.catatanlari

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catatanlari.databinding.FragmentBerandaBinding

class BerandaFragment : Fragment() {

    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!
    private val args: BerandaFragmentArgs by navArgs()
    
    private lateinit var adapter: CatatLariAdapter
    private val dataList = mutableListOf<catatLari>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sapaan User
        val email = args.userEmail
        val userName = args.userName
        val userGender = args.userGender

        val name = if (userName.isNotEmpty() && userName != "User") userName else email.substringBefore("@")
        binding.textView.text = getString(R.string.welcome_user, name)

        // Setup RecyclerView
        adapter = CatatLariAdapter(dataList) { item ->
            // Navigasi ke Detail saat item diklik
            val action = BerandaFragmentDirections.actionBerandaFragmentToDetailCatatLariFragment(
                jadwal = item.jadwal,
                jarak = item.jarak,
                waktu = item.waktu,
                tempat = item.tempat
            )
            findNavController().navigate(action)
        }

        binding.rvCatatLari.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCatatLari.adapter = adapter

        // Listener untuk menerima data dari CatatlariFragment
        setFragmentResultListener("requestKey") { _, bundle ->
            val jadwal = bundle.getString("jadwal") ?: ""
            val jarak = bundle.getString("jarak") ?: ""
            val waktu = bundle.getString("waktu") ?: ""
            val tempat = bundle.getString("tempat") ?: ""
            
            val newData = catatLari(jadwal, jarak, waktu, tempat)
            adapter.addData(newData)
        }

        binding.floatinAddButton.setOnClickListener {
            findNavController().navigate(
                BerandaFragmentDirections.actionBerandaFragmentToCatatlariFragment()
            )
        }

        // Navigasi ke Profil saat foto profil diklik
        binding.imageView4.setOnClickListener {
            val action = BerandaFragmentDirections.actionBerandaFragmentToProfilFragment(
                userEmail = email,
                userName = userName,
                userGender = userGender
            )
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}