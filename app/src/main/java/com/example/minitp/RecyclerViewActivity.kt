package com.example.minitp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minitp.model.ObjectDataSample
import com.example.minitp.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity: AppCompatActivity() {
    private lateinit var mAdapter: AndroidVersionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Create the instance of adapter
        mAdapter = AndroidVersionAdapter()


        // We define the style
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        // We set the adapter to recycler view
        binding.recyclerView.adapter = mAdapter


        // Generate data and give it to adapter
        mAdapter.submitList(generateFakeData() as List<ObjectDataSample>?)
    }

    private fun generateFakeData(): ArrayList<ObjectDataSample> {
        return arrayListOf(
            ObjectDataSample("Red bull", 5.99f),
            ObjectDataSample("Coke", 1.90f),
            ObjectDataSample("Fanta", 4.90f),
            ObjectDataSample("Monster", 1.90f),
            ObjectDataSample("Pepsi", 1.90f),

        )
    }
}