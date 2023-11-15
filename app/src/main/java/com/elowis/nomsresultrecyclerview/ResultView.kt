package com.elowis.nomsresultrecyclerview
import CustomAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.elowis.nomsresultrecyclerview.databinding.ActivityResultViewBinding
import com.elowis.nomsresultrecyclerview.model.ItemsViewModel

class ResultView : AppCompatActivity() {

    lateinit var binding: ActivityResultViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemsList = intent.getSerializableExtra("itemsList") as? ArrayList<ItemsViewModel>
        if (itemsList != null) {
            val recyclerView = binding.nomsRecyclerView
            recyclerView.layoutManager = LinearLayoutManager(this)
            val adapter = CustomAdapter(itemsList)
            recyclerView.adapter = adapter
        } else {
            Toast.makeText(this, "itemList empty", Toast.LENGTH_SHORT).show()

        }

    }
}
