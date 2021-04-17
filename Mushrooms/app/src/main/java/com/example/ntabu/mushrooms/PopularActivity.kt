package com.example.ntabu.mushrooms

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.action_popular_mushrooms.*

class PopularActivity : MushroomsActivityBase() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.action_popular_mushrooms)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        belyiy_grib.setOnClickListener {
            val intent = Intent(this, Details1::class.java)
            intent.putExtra("name", "Vanua")
            startActivity(intent)
        }

        killer.setOnClickListener {
            val intent = Intent(this, Details4::class.java)
            startActivity(intent)
        }

        boletus.setOnClickListener {
            val intent = Intent(this, Details2::class.java)
            startActivity(intent)
        }

        mokruha.setOnClickListener {
            val intent = Intent(this, Details3::class.java)
            startActivity(intent)
        }

        glutinosus.setOnClickListener {
            val intent = Intent(this, Details5::class.java)
            startActivity(intent)
        }

    }


}