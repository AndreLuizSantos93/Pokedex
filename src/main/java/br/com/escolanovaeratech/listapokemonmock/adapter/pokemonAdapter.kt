package br.com.escolanovaeratech.listapokemonmock.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.core.content.res.ComplexColorCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.escolanovaeratech.listapokemonmock.R
import br.com.escolanovaeratech.listapokemonmock.model.PokemonModel
import br.com.escolanovaeratech.listapokemonmock.model.PokemonType

class pokemonAdapter(
    private val onClickListener: (PokemonModel) -> Unit
) : ListAdapter<PokemonModel, pokemonAdapter.pokemonViewHolder>(
    pokemonDiffCallBack
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): pokemonViewHolder {


        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon, parent, false)
        return pokemonViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(
        holder: pokemonViewHolder,
        position: Int
    ) {
        val model = getItem(position)
        holder.bind(model)
    }

    // ViewHolder responsavel por popular a  UI,
    class pokemonViewHolder(
        itemView: View,
        val onClickListener: (PokemonModel) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val imgPokemon = itemView.findViewById<ImageView>(R.id.imgCharmander)
        private val txtIdentificacao = itemView.findViewById<TextView>(R.id.txt_identificação)
        private val txtName = itemView.findViewById<TextView>(R.id.txt_name)

        private val typeContainer = itemView.findViewById<LinearLayout>(R.id.TypeContainer)

        fun bind(model: PokemonModel) {
            imgPokemon.setImageResource(model.imageRes)
            txtName.text = model.name
            txtIdentificacao.text = model.id.toString()
            itemView.setOnClickListener {
                onClickListener.invoke(model)
            }
            bindType((model.types))


        }

        private fun bindType(types: List<PokemonType>) {
            typeContainer.removeAllViews()

            val inflater = LayoutInflater.from(itemView.context)
            types.forEach { type ->
                val chip = inflater.inflate(R.layout.view_type_chip, typeContainer, false)
                val typeName = chip.findViewById<TextView>(R.id.txtTypeName)
                val typeDot = chip.findViewById<View>(R.id.typeDot)
                typeName.text = type.displayNome


                val color = ContextCompat.getColor(itemView.context, type.colorRes)
                typeDot.background = typeDot.background.mutate().also { it.setTint(color) }
                typeContainer.addView(chip)
            }
        }

    }

    // DiffUtil para diferenciar os itens da lista quando escrolar, para não haver duplicidade.
    // Diferencia os item pelo ID e pelo conteúdo.
    private object pokemonDiffCallBack : DiffUtil.ItemCallback<PokemonModel>() {
        override fun areItemsTheSame(
            oldItem: PokemonModel,
            newItem: PokemonModel
        ): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(
            oldItem: PokemonModel,
            newItem: PokemonModel
        ): Boolean {
            return newItem == oldItem
        }
    }
}