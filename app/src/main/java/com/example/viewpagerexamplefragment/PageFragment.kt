package com.example.viewpagerexamplefragment

import android.os.Bundle
import android.transition.Scene
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpagerexamplefragment.databinding.FragmentLayoutBinding

//global constant value
private const val ARG_PARAM1 = "param1"

//fragment for each view page, which contains one recyclerview
class PageFragment : Fragment() {
    private var cityName: String? = null
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //retrieve the passed argument (city name)
        arguments?.let {
            cityName = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLayoutBinding>(
            inflater,
            R.layout.fragment_layout,
            container,
            false
        )

        //get the viewmodel object (shared with the activity)
        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        //configure the recyclerview
        val layoutManager = LinearLayoutManager(this.activity)
        binding.recyclerView.layoutManager = layoutManager
        //data source is coming from the viewmodel by filtering the list data with the given city
        val citySceneList = viewModel.sceneList.filter { it.city == cityName }
        val adapter = RecyclerViewAdapter(citySceneList)
        binding.recyclerView.adapter = adapter
        //add divider line
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this.activity,
                DividerItemDecoration.VERTICAL
            )
        )
        return binding.root
    }

    companion object {
        @JvmStatic
        //static method for creating a fragment instance
        fun newInstance(cityName: String) =
            PageFragment().apply {
                //pass an argument into the bundle
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, cityName)
                }
            }
    }
}