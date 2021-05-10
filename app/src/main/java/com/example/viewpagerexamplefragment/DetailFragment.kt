package com.example.viewpagerexamplefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewpagerexamplefragment.databinding.FragmentDetailBinding

//show the details of one selected scene from the recyclerview
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container, false)
        //get the viewModel object (shared with the activity)
        val viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        //retrieve the passed scene index
        val args = DetailFragmentArgs.fromBundle(requireArguments())
        //Call onCreateView each time when a scene is selected, so the binding can be renewed
        binding.scene = viewModel.sceneList[args.sceneIndex]

        return binding.root
    }


}