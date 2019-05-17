package br.com.edu.ifpr.grazi.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.edu.ifpr.grazi.myapplication.entidades.Noticia
import br.com.edu.ifpr.grazi.myapplication.entidades.ResultadoNoticias
import br.com.edu.ifpr.grazi.myapplication.servicos.NoticiasService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var retrofit: Retrofit
    lateinit var service: NoticiasService
//    lateinit var adapter: NoticiaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configuraRetrofit()
//        carregaDados()


    }

    fun configuraRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl("http://newapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(NoticiasService::class.java)
    }

//    fun carregaDados() {
//        service.getNews().enqueue(object: Callback<ResultadoNoticias>{
//            override fun onFailure(call: Call<ResultadoNoticias>, t: Throwable) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onResponse(call: Call<ResultadoNoticias>, response: Response<ResultadoNoticias>) {
//                val noticias = response.body()?.noticias
//                if (noticias != null)
////                    configuraRecyclerView(tarefas)
//
//            }
//        })

//        service.buscaTodas().enqueue(object : Callback<List<Tarefa>> {
//            override fun onFailure(call: Call<List<Tarefa>>, t: Throwable) {
//
//            }
//
//            override fun onResponse(
//                call: Call<List<Tarefa>>,
//                response: Response<List<Tarefa>>
//            ) {
//                val tarefas = response.body()
//                if (tarefas != null)
//                    configuraRecyclerView(tarefas)
//            }
//
//        })
    }
//
//    fun configuraRecyclerView(noticias: List<Noticia>) {
//        adapter = NoticiaAdapter(noticias.toMutableList(), this)
//        listNoticias.adapter = adapter
//
//        listNoticias.layoutManager = LinearLayoutManager(
//            this, RecyclerView.VERTICAL, false
//        )
//    }
