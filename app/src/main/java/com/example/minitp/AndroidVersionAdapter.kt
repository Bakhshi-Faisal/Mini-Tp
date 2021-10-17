package com.example.minitp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.minitp.databinding.ItemCustomRecyclerBinding
import com.example.minitp.databinding.ItemCustomRecyclerFooterBinding
import com.example.minitp.databinding.ItemCustomRecyclerHeaderBinding
import com.example.minitp.model.MyObjectForRecyclerView
import com.example.minitp.model.ObjectDataFooterSample
import com.example.minitp.model.ObjectDataHeaderSample
import com.example.minitp.model.ObjectDataSample

private val diffItemUtils = object : DiffUtil.ItemCallback<MyObjectForRecyclerView>() {


    override fun areItemsTheSame(oldItem: MyObjectForRecyclerView, newItem: MyObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }


    override fun areContentsTheSame(oldItem: MyObjectForRecyclerView, newItem: MyObjectForRecyclerView): Boolean {
        return oldItem == newItem
    }
}


class AndroidVersionAdapter(
) : ListAdapter<MyObjectForRecyclerView, RecyclerView.ViewHolder>(diffItemUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            MyItemType.ROW.type -> {
                AndroidVersionViewHolder(
                    ItemCustomRecyclerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }


            MyItemType.HEADER.type -> {
                HeaderViewHolder(
                    ItemCustomRecyclerHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            MyItemType.FOOTER.type -> {
                FooterViewHolder(
                    ItemCustomRecyclerFooterBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> throw RuntimeException("Wrong view type received $viewType")
        }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            MyItemType.ROW.type -> (holder as AndroidVersionViewHolder).bind(getItem(position) as ObjectDataSample)
            MyItemType.HEADER.type -> (holder as HeaderViewHolder).bind(getItem(position) as ObjectDataHeaderSample)
            MyItemType.FOOTER.type -> (holder as FooterViewHolder).bind(getItem(position) as ObjectDataFooterSample)
            else -> throw RuntimeException("Wrong view type received ${holder.itemView}")
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ObjectDataSample -> MyItemType.ROW.type
            is ObjectDataHeaderSample -> MyItemType.HEADER.type
            is ObjectDataFooterSample -> MyItemType.FOOTER.type
        }
    }

}

class AndroidVersionViewHolder(
    private val binding: ItemCustomRecyclerBinding,
) : RecyclerView.ViewHolder(binding.root) {


    private lateinit var ui: ObjectDataSample

    fun bind(objectDataSample: ObjectDataSample) {
        ui = objectDataSample
        binding.itemRecyclerViewVersionName.text = objectDataSample.nomBoisson
        binding.itemRecyclerViewVersionCode.text = "${objectDataSample.prix}"
    }
}

class HeaderViewHolder(
    private val binding : ItemCustomRecyclerHeaderBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(objectDataHeaderSample: ObjectDataHeaderSample) {
        binding.itemRecyclerViewHeader.text = objectDataHeaderSample.header
    }
}
class FooterViewHolder(
    private val binding : ItemCustomRecyclerFooterBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(objectDataFooterSample: ObjectDataFooterSample) {
        binding.itemRecyclerViewHeader.text = objectDataFooterSample.footerText
    }
}

enum class MyItemType(val type: Int){
    ROW(0),
    HEADER(1),
    FOOTER(2),
}
