package com.example.catatanlari

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.catatanlari.databinding.FragmentDetailCatatLariBinding

class DetailCatatLariFragment : Fragment() {

    private var _binding: FragmentDetailCatatLariBinding? = null
    private val binding get() = _binding!!
    private val args: DetailCatatLariFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailCatatLariBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set data detail dari argumen
        binding.apply {
            tvDetailJadwal.text = args.jadwal
            tvDetailTempat.text = args.tempat
            tvDetailJarak.text = "${args.jarak} km"
            tvDetailWaktu.text = args.waktu

            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}