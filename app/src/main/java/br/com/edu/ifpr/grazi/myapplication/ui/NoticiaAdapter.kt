package br.com.edu.ifpr.grazi.myapplication.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.edu.ifpr.grazi.myapplication.entidades.Noticia


//class NoticiaAdapter(private var noticias: MutableList<Noticia>{
//
//
//
//
////    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
////        TarefaViewHolder(
////            LayoutInflater
////                .from(parent.context)
////                .inflate(viewType, parent, false)
////        )
////
////    override fun getItemCount() = noticias.size
////
////    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) =
////        holder.preencherView(noticias[position])
//
////    inner class TarefaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
////        fun preencherView(noticia: Noticia) {
////
////                itemView.txtTitulo.setText(tarefa.titulo)
////                itemView.txtDescricao.setText(tarefa.descricao)
////
////                itemView.btSalvar.setOnClickListener {
////                    tarefa.titulo = itemView.txtTitulo.text.toString()
////                    tarefa.descricao = itemView.txtDescricao.text.toString()
////
////                    tarefaEditando = null
////                    val position = tarefas.indexOf(tarefa)
////                    notifyItemChanged(position)
////
////                    listener.tarefaSalva(tarefa)
////                }
////                itemView.btApagar.setOnClickListener {
////                    tarefaEditando = null
////                    val position = tarefas.indexOf(tarefa)
////                    notifyItemRemoved(position)
////
////                    tarefas.remove(tarefa)
////
////                    listener.tarefaApagada(tarefa)
////                }
////
////                itemView.lblTitulo.text = tarefa.titulo
////                if (tarefa.feita) {
////                    itemView.lblTitulo.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
////                    itemView.btCompartilhar.visibility = View.VISIBLE
////                } else {
////                    itemView.lblTitulo.paintFlags = 0
////                    itemView.btCompartilhar.visibility = View.GONE
////                }
////                itemView.setOnClickListener {
////                    tarefaEditando = tarefa
////                    val position = tarefas.indexOf(tarefa)
////                    notifyItemChanged(position)
////                }
////                itemView.setOnLongClickListener {
////                    tarefa.feita = !tarefa.feita
////
////                    val position = tarefas.indexOf(tarefa)
////                    notifyItemChanged(position)
////
////                    listener.tarefaSalva(tarefa)
////
////                    true
////                }
////
////            }
////        }
//   }

