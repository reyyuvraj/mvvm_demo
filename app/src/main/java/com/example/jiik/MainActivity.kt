package com.example.jiik

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.jiik.models.MarsAdapter
import com.example.jiik.models.MarsView


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MarsView
    private lateinit var adapter: MarsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView  = findViewById(R.id.recyclerView)
        val progressBar: ProgressBar = findViewById(R.id.progressBar)

        viewModel = ViewModelProvider(this).get(MarsView::class.java)
        viewModel.getMarsData()

        adapter = MarsAdapter(this)
        recyclerView.adapter = adapter


        viewModel.showProgress.observe(this, Observer {
            if (it)
                progressBar.visibility = View.VISIBLE
            else
                progressBar.visibility = View.GONE

        })
        viewModel.marsData.observe(this, Observer {
            adapter.setMarsData(it)
        })
    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,  menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_refresh ->{
                MarsAdapter(this)
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }*/
}