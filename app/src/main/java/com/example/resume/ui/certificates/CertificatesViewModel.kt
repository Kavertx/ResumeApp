package com.example.resume.ui.certificates

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CertificatesViewModel : ViewModel() {

    val androidKotlin2022 = Certificate("Android Development with Kotlin",
        "https://softuni.bg/Certificates/Details/148201/bcf6ba8e")
    val QAbasics = Certificate("QA Basics",
        "https://softuni.bg/certificates/details/154752/77aba62a")

    val certificatesArray = arrayOf<Certificate>(androidKotlin2022, QAbasics)

}

class Certificate(val name: String, val URL: String)