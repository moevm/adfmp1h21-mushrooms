package com.example.ntabu.mushrooms

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_results.*

class ResultsActivity : MushroomsActivityBase() {
    private var dbHelper : DBHelper? = null
    private var details : MushroomDetails? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        setupActionBar()

        result1.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            if (details != null)
                intent.putExtra("details", details)
            startActivity(intent)
        }

        dbHelper = DBHelper(applicationContext)
        details = selectData()

        if (details != null) {
            result1.text = details!!.name
            if (details!!.pictureId == 2)
                result1.setBackgroundResource(R.drawable.fli_killer)
            else
                result1.setBackgroundResource(R.drawable.belyiy_grib_elovyiy)
        }
    }

    override fun onDestroy() {
        dbHelper?.close()
        super.onDestroy()
    }

    private fun selectData() : MushroomDetails? {
        var result : MushroomDetails? = null
        if (dbHelper != null) {
            val criteria = intent.extras.getParcelable<MushroomCriteria>("criteria")!!
            val db = dbHelper!!.writableDatabase
            var c = db.rawQuery(
                "SELECT * FROM mushrooms WHERE hat_color='${criteria.topColor}' AND hat_bottom='${criteria.roundKind}'",
                null
            )
            if (c != null) {
                if (c.moveToFirst()) {
                    val nameIndex = c.getColumnIndex("name")
                    val descriptionIndex = c.getColumnIndex("description")
                    val pictureIdIndex = c.getColumnIndex("picture_id")
                    result = MushroomDetails(c.getString(nameIndex), c.getString(descriptionIndex), c.getInt(pictureIdIndex))
                }
                c.close()
            }
        }
        return result
    }
}
