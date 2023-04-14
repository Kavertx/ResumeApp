package com.example.resume.ui.projects

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProjectsViewModel : ViewModel() {

    val resume = Project("Resume", "https://github.com/Kavertx/ResumeApp/")
    val notes = Project("Notes", "https://github.com/Kavertx/NotesApp/")
    val calculator = Project("Calculator", "https://github.com/Kavertx/Calculator/")
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val techStackArray = arrayOf<String>("Android", "Web", "Desktop")

    val mapOfProjects =  mapOf<String, Array<Project>>(
        techStackArray[0] to arrayOf(resume, notes, calculator),
        techStackArray[1] to arrayOf(),
        techStackArray[2] to arrayOf()
    )


    val androidProjectsList = arrayOf<Project>(resume, notes, calculator)
    val webProjectsList = arrayOf<Project>()
    val desktopProjectsList = arrayOf<Project>()
}


class Project(val Name: String, val URL: String)
