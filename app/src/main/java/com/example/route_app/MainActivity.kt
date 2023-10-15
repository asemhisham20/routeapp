package com.example.route_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview=findViewById<RecyclerView>(R.id.recycler_view)
recyclerview.layoutManager=LinearLayoutManager(this)


        val data=ArrayList<Courses>()

            data.add(Courses(0,R.drawable.fullstack, "FullStack" ))
        data.add(Courses(1,R.drawable.android, "Android" ))
        data.add(Courses(2,R.drawable.ios, "IOS" ))

        val adapter = Adaptercourse(data)



        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        adapter.setItemOnClickListener( object :  Adaptercourse.OnItemClickListener{

            override fun onClick(position: Int) {
                when(position){

                    0-> Intent(this@MainActivity,Fullstackcontent::class.java).also { startActivity(it) }
                    1-> Intent(this@MainActivity,android_content::class.java).also { startActivity(it) }
                    2-> Intent(this@MainActivity,Ios_content::class.java).also { startActivity(it) }

                }

            }
        }
        )
    }
}