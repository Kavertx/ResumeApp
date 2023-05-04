package com.example.resume.ui.certificates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resume.databinding.FragmentCertificatesBinding
import com.example.resume.ui.adapters.CertificatesAdapter

class CertificatesFragment : Fragment() {

    private var _binding: FragmentCertificatesBinding? = null

    val androidKotlin2022 = Certificate("Android Development with Kotlin",
        "https://softuni.bg/Certificates/Details/148201/bcf6ba8e")
    val QAbasics = Certificate("QA Basics",
        "https://softuni.bg/certificates/details/154752/77aba62a")

    val certificatesArray = arrayOf(androidKotlin2022, QAbasics)

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentCertificatesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.certificatesRecyclerView.adapter = CertificatesAdapter(certificatesArray)
        binding.certificatesRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class Certificate(val name: String, val URL: String)