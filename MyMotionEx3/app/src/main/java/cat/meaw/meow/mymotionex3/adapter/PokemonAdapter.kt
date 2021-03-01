package cat.meaw.meow.mymotionex3.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.RecyclerView
import cat.meaw.meow.mymotionex3.R
import cat.meaw.meow.mymotionex3.model.Pokemon
import kotlinx.android.synthetic.main.item_row.view.*


class PokemonAdapter(val pokemons:ArrayList<Pokemon>,val onPokemonClick: OnPokemonClick): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>(){

    interface OnPokemonClick{
        fun onItemClick(str:String)
    }
    inner class PokemonViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(pokemon: Pokemon,onPokemonClick: OnPokemonClick){
            var start: Boolean = true

            itemView.txt_title.text = pokemon.name
            itemView.txt_content.text = pokemon.detail
            itemView.txt_content.setOnClickListener {
                onPokemonClick.onItemClick(pokemon.name)
            }

            //itemView.la_top.
//            itemView.la_top.setTransitionListener(object : MotionLayout.TransitionListener{
//                override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
//                    //Log.d("DSST","onTransitionStarted")
//
//                }
//
//                override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
//                    //Log.d("DSST","onTransitionChange: p1 = $p1  p2 = $p2 p3 = $p3")
//                    itemView.motion_id.progress = p3
//                }
//
//                override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
//
////                    if(start){
////                        start = false
////                        itemView.motion_id.transitionToEnd()
////                        Log.d("DSST","AA")
////                    }else {
////                        start = true
////                        itemView.motion_id.transitionToStart()
////                        Log.d("DSST","BB")
////                    }
//                    //Log.d("DSST","onTransitionCompleted")
//                    //if(p1 == p0?.endState){
//                    //itemView.la_top.performClick()
//                    //}
//
//                }
//
//                override fun onTransitionTrigger(
//                    p0: MotionLayout?,
//                    p1: Int,
//                    p2: Boolean,
//                    p3: Float
//                ) {
//
//                }
//
//            })
            //itemView.la_content.onGenericMotionEvent(con)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemons[position],onPokemonClick)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }


}