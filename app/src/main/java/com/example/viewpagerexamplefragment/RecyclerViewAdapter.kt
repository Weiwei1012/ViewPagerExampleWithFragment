package com.example.viewpagerexamplefragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viewpagerexamplefragment.databinding.ItemLayoutBinding

//adapter class for the recyclerview (without using ListAdapter)
//data source need to be passed into the adapter when created
class RecyclerViewAdapter(val sceneList: List<Scenes>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //use data binding in the layout
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(layoutInflater, parent, false)
        val viewHolder = ViewHolder(binding)
        viewHolder.itemView.setOnClickListener {
            //pass the id of the selected scene
            val selected = sceneList[viewHolder.adapterPosition].id
            //perfom fragment navigation
          it.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToDetailFragment(selected))
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return sceneList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val scene = sceneList[position]
        holder.binding.scene = scene
        //update the layout with data binding
        holder.binding.executePendingBindings()
    }
}

//setImageResource using the Glide API (auto-compression, quick loading)
@BindingAdapter("setImage")  //customized attribute name
fun ImageView.setImage(r_id: Int) {  //function name can be different with the attribute name
    Glide.with(this.context)
        .load(r_id)
        .into(this)
}
