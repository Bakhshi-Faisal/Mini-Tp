package com.example.minitp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minitp.model.ObjectDataSample
import com.example.minitp.databinding.ActivityRecyclerViewBinding
import com.example.minitp.model.MyObjectForRecyclerView
import com.example.minitp.model.ObjectDataFooterSample
import com.example.minitp.model.ObjectDataHeaderSample

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

    private fun generateFakeData(): MutableList<MyObjectForRecyclerView> {
        val result = mutableListOf<MyObjectForRecyclerView>()
        // Create data raw
        mutableListOf(
            ObjectDataSample("Red bull", 5.99f),
            ObjectDataSample("Coke", 1.90f),
            ObjectDataSample("Fanta", 4.90f),
            ObjectDataSample("Monster", 1.90f),
            ObjectDataSample("Pepsi", 1.90f),

            ).groupBy {
            // Split in 2 list, modulo and not
            it.prix > 4
        }.forEach { (IsCher, items) ->
            // For each mean for each list split
            // Here we have a map (key = isModulo) and each key have a list of it's items
            result.add(ObjectDataHeaderSample("Est le plus cher:$IsCher"))
            result.addAll(items)
            result.add(ObjectDataFooterSample("Est le moins cher"))

            // Here we can add footer, just after our items
        }
        return result

    }
}
