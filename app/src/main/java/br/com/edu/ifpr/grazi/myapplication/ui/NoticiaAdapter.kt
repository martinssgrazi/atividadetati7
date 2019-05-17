package br.com.edu.ifpr.grazi.myapplication.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.edu.ifpr.grazi.myapplication.R
import br.com.edu.ifpr.grazi.myapplication.entidades.Noticia
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_noticia_compacto.view.*


class NoticiaAdapter(
    private var noticias: MutableList<Noticia>):RecyclerView.Adapter<NoticiaAdapter.TarefaViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TarefaViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_noticia_compacto, parent, false)
        )

    override fun getItemCount() = noticias.size

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) =
        holder.preencherView(noticias[position])

    inner class TarefaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun preencherView(noticia: Noticia) {

                itemView.lbTitulo.setText(noticia.titulo)
                itemView.lbDescricao.setText(noticia.descricao)
                itemView.lbConteudo.setText(noticia.conteudo)
                Picasso.get().load(noticia.urlToImage).into(itemView.imageView)
                itemView.lbAutor.setText(noticia.autor)
                    noticia.titulo = itemView.lbTitulo.text.toString()
                    noticia.descricao = itemView.lbDescricao.text.toString()



                    val position = noticias.indexOf(noticia)



                itemView.lbTitulo.text = noticia.titulo


            }
        }
   }

