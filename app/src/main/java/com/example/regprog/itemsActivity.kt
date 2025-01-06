package com.example.regprog

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class itemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)

        val itemsList:RecyclerView=findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()




        items.add(
            Item(
                id = 1,
                image = "wireless_headphones",
                title = "Wireless Headphones",
                desc = "High-quality wireless headphones with noise cancellation.",
                text = "Enjoy your music with exceptional sound quality and comfort. These headphones are perfect for travel and work.",
                price = 129
            )
        )

        items.add(
            Item(
                id = 2,
                image = "mouse",
                title = "Gaming Mouse",
                desc = "Ergonomic gaming mouse with RGB lighting.",
                text = "Precision and style meet in this gaming mouse. Features customizable buttons and adjustable DPI settings.",
                price = 49
            )
        )

        items.add(
            Item(
                id = 3,
                image = "smartwatch",
                title = "SmartWatch",
                desc = "Stylish smartwatch with fitness tracking features.",
                text = "Track your fitness goals and stay connected with this sleek smartwatch. Perfect for any lifestyle.",
                price = 199
            )
        )

        items.add(
            Item(
                id = 4,
                image = "electric_scooter",
                title = "Electric Scooter",
                desc = "Compact and eco-friendly electric scooter.",
                text = "Commute in style with this lightweight electric scooter. Provides a smooth and safe ride.",
                price = 499
            )
        )

        items.add(
            Item(
                id = 5,
                image = "portable_speaker",
                title = "Portable Speaker",
                desc = "Waterproof portable speaker with long battery life.",
                text = "Take your music anywhere with this durable portable speaker. Enjoy crystal-clear sound and up to 12 hours of playtime.",
                price = 89
            )
        )

        itemsList.layoutManager=LinearLayoutManager(this)
        itemsList.adapter=ItemsAdapter(items,this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}