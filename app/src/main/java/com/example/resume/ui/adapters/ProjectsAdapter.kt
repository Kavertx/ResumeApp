package com.example.resume.ui.adapters

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.resume.databinding.ItemProjectBinding
import com.example.resume.ui.projects.Project

class ProjectsAdapter(private val dataSet: Array<Project>):
        RecyclerView.Adapter<ProjectsAdapter.ProjectsViewHolder>(){

            class ProjectsViewHolder(binding: ItemProjectBinding): ViewHolder(binding.root){
               val projectName: TextView = binding.projectName

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        return ProjectsViewHolder(
            ItemProjectBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(viewHolder: ProjectsViewHolder, position: Int) {
        val project: Project = dataSet[position]
        viewHolder.projectName.text = project.Name
        viewHolder.projectName.setOnClickListener {
            val uri = Uri.parse(project.URL)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            viewHolder.projectName.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = dataSet.size
}