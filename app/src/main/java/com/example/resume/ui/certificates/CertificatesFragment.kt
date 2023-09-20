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

    val androidKotlin2022 = Certificate(
        "Android Development with Kotlin",
        "https://softuni.bg/Certificates/Details/148201/bcf6ba8e"
    )
    val QaBasics = Certificate(
        "QA Basics",
        "https://softuni.bg/certificates/details/154752/77aba62a"
    )
    val softwareTechnologies = Certificate(
        "Software Technologies",
        "https://softuni.bg/certificates/details/175738/2be3fc79"
    )
    val QaFundamentalsAndManualTesting = Certificate(
        "QA Fundamentals and Manual Testing",
        "https://softuni.bg/certificates/details/183605/9b1d2d2d"
    )
    val htmlAndCss =
        Certificate("HTML & CSS", "https://softuni.bg/certificates/details/182042/da0154ee")
    val csAdvanced =
        Certificate("C# Advanced", "https://softuni.bg/certificates/details/173566/d79312a4")


    val certificatesArray = arrayOf(
        androidKotlin2022,
        QaBasics,
        softwareTechnologies,
        QaFundamentalsAndManualTesting,
        htmlAndCss,
        csAdvanced
    )

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