package br.com.inovasoft.aryapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ServicoAdapter (
        val servicos: List<Servico>,
        val onClick: (Servico) -> Unit
        ): RecyclerView.Adapter<ServicoAdapter.ServicosViewHolder>() {

            class ServicosViewHolder(view: View): RecyclerView.ViewHolder(view) {
                val cardNome: TextView
                val cardImage: ImageView
                val cardProgress: ProgressBar
                val cardView: CardView

                init {
                    cardNome = view.findViewById(R.id.card_nome)
                    cardImage = view.findViewById(R.id.card_image)
                    cardProgress = view.findViewById(R.id.card_progress)
                    cardView = view.findViewById(R.id.card_servicos)
                }
            }

            override fun getItemCount() = this.servicos.size

            override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int ) : ServicosViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_servico, parent, false)

                val holder = ServicosViewHolder(view)
                return holder
            }

            override fun onBindViewHolder(holder: ServicosViewHolder, position: Int) {

                val servico = servicos[position]

                holder.cardNome.text = servico.nome
                holder.cardProgress.visibility = View.VISIBLE

                val context = holder.itemView.context
                Picasso.with(context).load(servico.foto).fit().into(holder.cardImage,
                    object: com.squareup.picasso.Callback {
                        override fun onSuccess() {
                            holder.cardProgress.visibility = View.GONE
                        }
                        override fun onError() {
                            holder.cardImage.setImageResource(R.drawable.ic_sino)
                            holder.cardProgress.visibility = View.GONE
                        }
                    }
                )

                holder.itemView.setOnClickListener {onClick(servico)}
            }
        }