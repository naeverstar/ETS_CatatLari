package com.example.catatanlari

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.catatanlari.databinding.FragmentCatatlariBinding

class CatatlariFragment : Fragment() {

    private var _binding: FragmentCatatlariBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatatlariBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSimpan.setOnClickListener {
            val jadwal = binding.etDate.text.toString()
            val jarak = binding.etDistance.text.toString()
            val waktu = binding.etTime.text.toString()
            val tempat = binding.etLocation.text.toString()

            if(jadwal.isEmpty() || jarak.isEmpty() || waktu.isEmpty() || tempat.isEmpty()) {
                Toast.makeText(requireContext(), "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                // Mengirim hasil ke BerandaFragment menggunakan Fragment Result API
                setFragmentResult("requestKey", bundleOf(
                    "jadwal" to jadwal,
                    "jarak" to jarak,
                    "waktu" to waktu,
                    "tempat" to tempat
                ))
                
                Toast.makeText(requireContext(), "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
                
                // Kembali ke Beranda
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}