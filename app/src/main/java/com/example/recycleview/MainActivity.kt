package com.example.recycleview

import BookAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var newBookList: ArrayList<BookDataClass>
private lateinit var newRecycleView: RecyclerView
private lateinit var bookAdapter: BookAdapter



class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        newRecycleView = findViewById(R.id.newRecycleView)
        newRecycleView.layoutManager = LinearLayoutManager(this)

        newBookList = arrayListOf()

        getBookData()

        bookAdapter = BookAdapter(newBookList)
        newRecycleView.adapter = bookAdapter
    }

    private fun getBookData() {
        newBookList.add(BookDataClass(R.drawable.img, "Развалюха", "мазда миата 1"))
        newBookList.add(BookDataClass(R.drawable.img2, "Добрая мазда миата", "мазда миата 2"))
        newBookList.add(BookDataClass(R.drawable.img3, "Злая мазда миата", "мазда миата"))


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}