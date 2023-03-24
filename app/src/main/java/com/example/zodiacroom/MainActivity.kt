package com.example.zodiacroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = fetchData()
        val adapterSign = adapter(items)
        recyclerView.adapter = adapterSign

        adapterSign.setOnItemClickListener(object : adapter.onItemClickListener
        {
            override fun onItemClick(position: Int) {
                val intent  = Intent (this@MainActivity,ZodiacInfo::class.java)
                startActivity(intent)
            }
        })
    }
    fun fetchData() : ArrayList<String>{
        val list = ArrayList<String>()
        list.add("TAURUS")
        list.add("GEMINI")
        list.add("CANCER")
        list.add("LEO")
        list.add("VIRGO")
        list.add("LIBRA")
        list.add("SCORPIO")
        list.add("SAGITTARIUS")
        list.add("CAPRICORN")
        list.add("AQUARIUS")


        return list
    }
}