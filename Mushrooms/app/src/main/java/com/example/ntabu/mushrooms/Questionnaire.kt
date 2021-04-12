package com.example.ntabu.mushrooms

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_questionnaire.*

class Questionnaire : MushroomsActivityBase() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionnaire)
        setupActionBar()

        but_next.setOnClickListener { nextPage() }

        val hatColorSpinner: Spinner = findViewById(R.id.ed_top_color)
        ArrayAdapter.createFromResource(this, R.array.hat_color_array, android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                hatColorSpinner.adapter = adapter
            }

        val growsSpinner: Spinner = findViewById(R.id.ed_grow_place)
        ArrayAdapter.createFromResource(this, R.array.grow_place_array, android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                growsSpinner.adapter = adapter
            }

        val foundSpinner: Spinner = findViewById(R.id.ed_found)
        ArrayAdapter.createFromResource(this, R.array.found_array, android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                foundSpinner.adapter = adapter
            }

        val roundKindSpinner: Spinner = findViewById(R.id.ed_round_kind)
        ArrayAdapter.createFromResource(this, R.array.round_kind_array, android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                roundKindSpinner.adapter = adapter
            }

        val roundColorSpinner: Spinner = findViewById(R.id.ed_round_color)
        ArrayAdapter.createFromResource(this, R.array.round_color_array, android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                roundColorSpinner.adapter = adapter
            }

        val sliceSpinner: Spinner = findViewById(R.id.ed_slice)
        ArrayAdapter.createFromResource(this, R.array.slice_array, android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sliceSpinner.adapter = adapter
            }
    }

    private fun nextPage() {
        val criteria = MushroomCriteria(
            ed_top_color.selectedItem.toString(),
            ed_grow_place.selectedItem.toString(),
            ed_found.selectedItem.toString(),
            ed_round_color.selectedItem.toString(),
            ed_round_kind.selectedItem.toString(),
            ed_slice.selectedItem.toString())
        val intent = Intent(this, Questionnaire2::class.java)
        intent.putExtra("criteria", criteria)
        startActivity(intent)
    }
}
