package com.yml.networklibpoc.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yml.networklibpoc.databinding.FragmentUniversityBinding
import com.yml.networklibpoc.domain.model.University
import com.yml.networklibpoc.presentation.adapter.UniversityAdapter
import com.yml.networklibpoc.presentation.viewmodel.UniversityViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UniversityListFragment : Fragment() {
    private lateinit var _binding: FragmentUniversityBinding
    private var universities: ArrayList<University> = arrayListOf()

    private val universityViewModel: UniversityViewModel by viewModels()

    companion object {
        fun getInstance() = UniversityListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUniversityBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        universityViewModel.dataObserver.observe(this, {
            _binding.recyclerView.apply {
                _binding.progressBar.isVisible = false
                adapter = UniversityAdapter(it)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.recyclerView.layoutManager = LinearLayoutManager(context)
        _binding.progressBar.isVisible = true
        universityViewModel.getUniversities()
    }
}