package cat.meaw.meow.mymotionex3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import cat.meaw.meow.mymotionex3.adapter.PokemonAdapter
import cat.meaw.meow.mymotionex3.model.Pokemon
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),PokemonAdapter.OnPokemonClick {
    lateinit var pokemonAdapter: PokemonAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener = AppBarLayout.OnOffsetChangedListener{ unused, verticalOffset ->
            val seekPosition = - verticalOffset / appbar_layout.totalScrollRange.toFloat()
            motion_layout.progress = seekPosition
        }
        appbar_layout.addOnOffsetChangedListener(listener)

        initRecyc()
    }

    fun initRecyc(){
        val array = ArrayList<Pokemon>()
        for (i in 1..30){
            array.add(Pokemon("Name: $i ","Content : $i "))
        }
        pokemonAdapter = PokemonAdapter(array,this)
        recyc.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = pokemonAdapter
        }
    }

    override fun onItemClick(str: String) {
        Intent(this, PokemonActivity::class.java).apply {
            startActivity(this)
        }

    }
}