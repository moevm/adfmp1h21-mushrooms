package com.example.ntabu.mushrooms

import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_details.*
import android.content.Intent
import android.widget.TextView


class DetailsActivity : MushroomsActivityBase() {

    override val isShareVisible: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setupActionBar()
        if(savedInstanceState == null) return
        val details = intent.extras.getParcelable<MushroomDetails>("details")
        if (details != null) {
            val mushroomTitle = findViewById<TextView>(R.id.title)
            mushroomTitle.text = details.name.toString()
            descriptionText.setText(Html.fromHtml(details.description, Html.FROM_HTML_MODE_LEGACY).toString())
        }
        else
            descriptionText.setText(getDescriptionText())
    }

    private fun getDescriptionText() : String {
        val text = "<p>Можно спутать с желчным грибом, горчаком с розовеющей мякотью.</p>" +
            "<p>Шляпка белого гриба имеет коричнево-бурый цвет, существуют подвиды белых " +
            "грибов с окраской шляпки от светло коричневого до темно каштанового цвета. Обычно она вырастает " +
            "до 7-30 сантиметров в диаметре. Хотя в некоторых, особенно благоприятных местах, можно встретить " +
            "белый гриб со шляпкой диаметром в 50 см. Оборот шляпки губчатый, белого цвета.</p>" +
            "<p>Мякоть у созревшего гриба обычно сочная, плотная, мясистая, белого цвета. " +
            "У старых грибов она может немного пожелтеть. На срезе и после обработки не темнеет.</p>" +
            "<p>Растут везде, за исключением Антарктиды и Австралии, в хвойных, лиственных и смешанных лесах.</p>"
        return Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY).toString()
    }

    override fun share() {
        val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val mushroomTitle = findViewById<TextView>(R.id.title)
        val shareBody = "${mushroomTitle.text}\n\n${descriptionText.text}"
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Смотри чего нашел!")
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Поделиться через"))
    }
}
