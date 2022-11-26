package br.com.up.pokedex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.com.up.pokedex.network.Api
import com.squareup.picasso.Picasso

class DetalhesActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)


        val layoutName: TextView = findViewById(R.id.Name)
        val layoutImage : ImageView = findViewById(R.id.Image)
        val layoutType1 : TextView = findViewById(R.id.Types1)
        val layoutType2 : TextView = findViewById(R.id.Types2)
        val layoutStats1 : TextView = findViewById(R.id.Stat1)
        val layoutStats2 : TextView = findViewById(R.id.Stat2)
        val layoutStats3 : TextView = findViewById(R.id.Stat3)
        val layoutStats4 : TextView = findViewById(R.id.Stat4)
        val layoutStats5 : TextView = findViewById(R.id.Stat5)
        val layoutStats6 : TextView = findViewById(R.id.Stat6)
        val layoutSkills : TextView = findViewById(R.id.Skills)
        val layoutMoves : TextView = findViewById(R.id.Moves)

        var statName = ""
        var statData = ""
        var abilidades = ""
        var moves = ""
        var types = ""


        val id = intent.getStringExtra("id")
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png").into(layoutImage)

        Api().getDetailsById((id.toString())){ details ->
            
            layoutName.text = details!!.name.uppercase()
            
            details.types.forEach { types = types + it.type.name + " " }
            layoutType1.text = types.split(' ')[0].uppercase()
            layoutType2.text = types.split(' ')[1].uppercase()


            details.stats.forEach { 
                statName = statName + it.stat.name + " " 
                statData = statData + it.base_stat + " "
            }

            layoutStats1.text = statName.split(" ")[0].uppercase() + " = " + statData.split(" ")[0]
            layoutStats2.text = statName.split(" ")[1].uppercase() + " = " + statData.split(" ")[1]
            layoutStats3.text = statName.split(" ")[2].uppercase() + " = " + statData.split(" ")[2]
            layoutStats4.text = statName.split(" ")[3].uppercase() + " = " + statData.split(" ")[3]
            layoutStats5.text = statName.split(" ")[4].uppercase() + " = " + statData.split(" ")[4]
            layoutStats6.text = statName.split(" ")[5].uppercase() + " = " + statData.split(" ")[5]

            details.abilities.forEach { abilidades = abilidades + it.ability.name.uppercase() + " " }
            layoutSkills.text = abilidades

            details.moves.forEach { moves = moves + it.move.name.uppercase() + "\n" }
            layoutMoves.text = moves
        }

    }
}