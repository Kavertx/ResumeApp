package com.example.resume.ui.projects

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resume.R
import com.example.resume.databinding.FragmentProjectsBinding
import com.example.resume.ui.adapters.ProjectsAdapter

class ProjectsFragment : Fragment() {

    private val viewModel: ProjectsViewModel by activityViewModels()
    private var _binding: FragmentProjectsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProjectsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val github: TextView = binding.github
        github.setOnClickListener{
            val uri = Uri.parse(githubAccountUri)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        val leetcode: TextView = binding.leetcode
        leetcode.setOnClickListener{
            val uri = Uri.parse(leetcodeAccountUri)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        val spinner: Spinner = binding.spinnerAndroid
        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.array_tech_stack,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    //TODO: Try to find a better way of setting the recyclerview
                    
                    if (p2==0){
                        binding.projectsRecyclerView.layoutManager = LinearLayoutManager(context)
                        binding.projectsRecyclerView.adapter = ProjectsAdapter(viewModel.androidProjectsList)
                    }else if (p2==1){
                        binding.projectsRecyclerView.layoutManager = LinearLayoutManager(context)
                        binding.projectsRecyclerView.adapter = ProjectsAdapter(viewModel.webProjectsList)
                    } else {
                        binding.projectsRecyclerView.layoutManager = LinearLayoutManager(context)
                        binding.projectsRecyclerView.adapter = ProjectsAdapter(viewModel.desktopProjectsList)
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        const val githubAccountUri = "https://github.com/Kavertx/"
        const val leetcodeAccountUri = "https://leetcode.com/Kavertx/"
    }

}
