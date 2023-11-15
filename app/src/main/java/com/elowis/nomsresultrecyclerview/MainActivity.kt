package com.elowis.nomsresultrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.elowis.nomsresultrecyclerview.databinding.ActivityMainBinding
import com.elowis.nomsresultrecyclerview.model.ItemsViewModel
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemsList = arrayListOf<ItemsViewModel>()
        val addButton = binding.addButton
        val nextButton = binding.nextButton

        addButton.setOnClickListener {
            val nom = binding.nomEditText.text.toString()
            val edat = binding.edatEditText.text.toString().toInt()
            val item = ItemsViewModel(nom, edat)
            itemsList.add(item)
            Toast.makeText(this, "alumne ${itemsList[itemsList.size-1].nom} added", Toast.LENGTH_SHORT).show()
        }

        nextButton.setOnClickListener {
            val intent = Intent(this, ResultView::class.java)
            intent.putExtra("itemsList", itemsList)
            startActivity(intent)
        }
    }
}