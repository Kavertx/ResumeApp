package com.example.resume.ui.certificates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resume.databinding.FragmentCertificatesBinding
import com.example.resume.ui.adapters.CertificatesAdapter

class CertificatesFragment : Fragment() {

    private val viewModel: CertificatesViewModel by activityViewModels()
    private var _binding: FragmentCertificatesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModelProvider(this)[CertificatesViewModel::class.java]

        _binding = FragmentCertificatesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.certificatesRecyclerView.adapter = CertificatesAdapter(viewModel.certificatesArray)
        binding.certificatesRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}