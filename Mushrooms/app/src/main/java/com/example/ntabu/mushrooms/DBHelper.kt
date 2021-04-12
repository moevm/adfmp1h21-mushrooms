package com.example.ntabu.mushrooms

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(mContext: Context) : SQLiteOpenHelper(mContext, DB_NAME, null, DB_VER) {
    val TABLE_NAME = "mushrooms"
    val CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            "( _id INTEGER PRIMARY KEY , " +
            " name TEXT, description TEXT, hat_color TEXT, hat_bottom TEXT, picture_id INTEGER)"
    val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
        fillData(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DROP_TABLE)
        onCreate(db)
    }

    private fun fillData(db: SQLiteDatabase?) {
        if (db != null) {
            createMushroom1(db)
            createMushroom2(db)
        }
    }

    private fun createMushroom1(db: SQLiteDatabase) {
        var values = ContentValues()
        values.put("name", "Белый гриб")
        values.put(
            "description", "<p>Можно спутать с желчным грибом, горчаком с розовеющей мякотью.</p>" +
                    "<p>Шляпка белого гриба имеет коричнево-бурый цвет, существуют подвиды белых " +
                    "грибов с окраской шляпки от светло коричневого до темно каштанового цвета. Обычно она вырастает " +
                    "до 7-30 сантиметров в диаметре. Хотя в некоторых, особенно благоприятных местах, можно встретить " +
                    "белый гриб со шляпкой диаметром в 50 см. Оборот шляпки губчатый, белого цвета.</p>" +
                    "<p>Мякоть у созревшего гриба обычно сочная, плотная, мясистая, белого цвета. " +
                    "У старых грибов она может немного пожелтеть. На срезе и после обработки не темнеет.</p>" +
                    "<p>Растут везде, за исключением Антарктиды и Австралии, в хвойных, лиственных и смешанных лесах.</p>"
        )
        values.put("hat_color", "Бурый, коричневый")
        values.put("hat_bottom", "Губчатый")
        values.put("picture_id", 1)
        db.insert(TABLE_NAME, null, values)
    }

    private fun createMushroom2(db: SQLiteDatabase) {
        var values = ContentValues()
        values.put("name", "Мухомор красный")
        values.put(
            "description",
                    "<p>Шляпка мухомора имеет красный цвет, в белую крапинку существуют подвиды " +
                    "мухоморов с окраской шляпки серого цвета. Обычно она вырастает " +
                    "до 7-10 сантиметров в диаметре. " +
                    "Оборот шляпки пластинчатый, белого цвета.</p>" +
                    "<p>Растут везде, за исключением Антарктиды и Австралии, в хвойных, лиственных и смешанных лесах.</p>"
        )
        values.put("hat_color", "Красный")
        values.put("hat_bottom", "Пластинчатый")
        values.put("picture_id", 2)
        db.insert(TABLE_NAME, null, values)
    }

    companion object {
        internal val DB_VER = 1
        internal val DB_NAME = "mushrooms.db"
    }
}