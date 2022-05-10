package com.example.lab2_layouts

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MenuActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    // Declaración variable gri, lista y adaptador
    private var gridView: GridView? = null
    private var arrayList: ArrayList<Movie>? = null
    private var movieAdapter: MovieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        //val tvUsername = findViewById<TextView>(R.id.tvUsername)

        //val lusername: String = intent.getStringExtra("username").toString()
        //val lpassword: String = intent.getStringExtra("password").toString()

        //tvUsername.text = lusername

        // Desplega lista de peliculas, imagen y titulo
        gridView = findViewById(R.id.my_grid)
        arrayList = ArrayList()
        arrayList = setDataList()
        movieAdapter = MovieAdapter(applicationContext, arrayList!!)
        gridView?.adapter = movieAdapter
        gridView?.onItemClickListener = this

        val menuLogin = findViewById<Button>(R.id.btnMenuLogin)
        val menuRating = findViewById<Button>(R.id.btnMenuRating)

        //evento onClick
        menuLogin.setOnClickListener {
            val intent = Intent(this, LogActivity::class.java)
            startActivity(intent)
        }

        menuRating.setOnClickListener {
            val intent = Intent(this, RatingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setDataList(): ArrayList<Movie> {
        var arrayList: ArrayList<Movie> = ArrayList()

        arrayList.add(Movie(R.drawable.batman, "Batman"))
        arrayList.add(Movie(R.drawable.eternals, "Eternals"))
        arrayList.add(Movie(R.drawable.uncharted, "Uncharted"))
        arrayList.add(Movie(R.drawable.strange, "Doctor Strange"))
        arrayList.add(Movie(R.drawable.adam, "Proyecto Adam"))
        arrayList.add(Movie(R.drawable.moon, "Moon Knight"))
        arrayList.add(Movie(R.drawable.sonic, "Sonic 2"))
        arrayList.add(Movie(R.drawable.venom, "Venom: Carnage"))

        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        var movie: Movie = arrayList!!.get(position)
        Toast.makeText(applicationContext, movie.name, Toast.LENGTH_LONG).show()
    }

}