package com.example.viewpagerexamplefragment

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

//work with viewpager2 for sliding between fragments
//for each item in cityList, create one individual fragment
class FragmentAdapter(fragmentActivity:FragmentActivity, val cityList: List<String>): FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): PageFragment {
        //create a new fragment with a passed argument of the city name
        return PageFragment.newInstance(cityList[position])
    }
    override fun getItemCount(): Int {
        return cityList.size
    }

}