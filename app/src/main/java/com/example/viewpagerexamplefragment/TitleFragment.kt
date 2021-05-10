package com.example.viewpagerexamplefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewpagerexamplefragment.databinding.FragmentTitleBinding
import com.google.android.material.tabs.TabLayoutMediator

//the first fragment that is loaded by the NavController
//the layout contains a viewpager and a tabLayout
class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //get the view binding object and inflate the layout
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater,
            R.layout.fragment_title,
            container,
            false
        )
        //get the viewModel object (shared with activity)
        val viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        //assign a fragmentAdapter to the viewpager
        binding.viewPager.adapter = FragmentAdapter(requireActivity(), viewModel.cityList)
        //configure the tablayout
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = viewModel.cityList[position]
        }.attach()

        return binding.root
    }

}