package com.example.resume.ui.adapters

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.resume.databinding.ItemCerificateBinding
import com.example.resume.ui.certificates.Certificate
import kotlinx.coroutines.processNextEventInCurrentThread

class CertificatesAdapter(private  val dataSet: Array<Certificate>):
RecyclerView.Adapter<CertificatesAdapter.CertificatesViewHolder>(){

    class CertificatesViewHolder(binding: ItemCerificateBinding): ViewHolder(binding.root){
        val certificateName: TextView = binding.certificateName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CertificatesViewHolder {
        return CertificatesViewHolder(
            ItemCerificateBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: CertificatesViewHolder, position: Int) {
        val certificate = dataSet[position]
        holder.certificateName.text = certificate.name
        holder.certificateName.setOnClickListener {
            val uri = Uri.parse(certificate.URL)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            holder.certificateName.context.startActivity(intent)
        }

    }


}