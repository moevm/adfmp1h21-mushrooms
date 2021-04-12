package com.example.ntabu.mushrooms

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_history.*

class History : MushroomsActivityBase() {

    override val isHistoryVisible: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setupActionBar()


        but_show_result.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }

        but_clear.setOnClickListener {
            val group = history_item1.parent as ViewGroup
            group.removeAllViews()
        }
    }
}
