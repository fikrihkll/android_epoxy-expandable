package com.teamdagger.expandableepoxylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.teamdagger.expandableepoxylist.databinding.ActivityMainBinding
import com.teamdagger.expandableepoxylist.entity.Coffee
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val controller = ListController()
        binding.coffeeEpoxyRecyclerView.setController(controller)

        controller.setNewAmericanData(
            listOf(
                Coffee(
                    UUID.randomUUID().toString(),
                    "Americano",
                    "Good coffee with bitter taste",
                    ""
                ),
                Coffee(
                    UUID.randomUUID().toString(),
                    "Americano 2",
                    "Good coffee with bitter taste 2",
                    ""
                )
            )
        )

        controller.setNewIndonesianData(
            listOf(
                Coffee(
                    UUID.randomUUID().toString(),
                    "Aceh Robusta",
                    "Good coffee to make u stay awake",
                    ""
                ),
                Coffee(
                    UUID.randomUUID().toString(),
                    "Aceh Robusta2",
                    "Good coffee to make u stay awake2",
                    ""
                ),
            )
        )
    }
}