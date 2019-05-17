package br.com.edu.ifpr.grazi.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.edu.ifpr.grazi.myapplication.entidades.Noticia
import br.com.edu.ifpr.grazi.myapplication.entidades.ResultadoNoticias
import br.com.edu.ifpr.grazi.myapplication.servicos.NoticiasService
import br.com.edu.ifpr.grazi.myapplication.ui.NoticiaAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var retrofit: Retrofit
    lateinit var service: NoticiasService
    lateinit var adapter: NoticiaAdapter

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configuraRetrofit()
        carregaDados()

        resources.configuration.locales[0].country.toLowerCase() // "br" "ar"
    }

    fun configuraRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(NoticiasService::class.java)
    }

    fun carregaDados() {
        service.getNews("").enqueue(object : Callback<ResultadoNoticias> {
            override fun onFailure(call: Call<ResultadoNoticias>, t: Throwable) {
               Log.e("grazi", t.message, t)
            }

            override fun onResponse(call: Call<ResultadoNoticias>, response: Response<ResultadoNoticias>) {
                val noticias = response.body()?.noticias
                if (noticias != null)
                    configuraRecyclerView(noticias)

            }
        })

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

    fun configuraRecyclerView(noticias: List<Noticia>) {
        adapter = NoticiaAdapter(noticias.toMutableList())
        listNoticias.adapter = adapter

        listNoticias.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL, false
        )
    }

}
