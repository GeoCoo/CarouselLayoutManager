package com.example.carousel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper


class MainActivity : AppCompatActivity() {

    // Initializing an empty ArrayList to be filled with animals
    private val animals: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv:RecyclerView = findViewById(R.id.rv_animal_list)
        val snapHelper: SnapHelper = LinearSnapHelper()

        // Loads animals into the ArrayList
        addAnimals()

        // Creates a vertical Layout Manager
        rv.apply {
            this.adapter = AnimalAdapter(animals,this@MainActivity)
            this.setPadding(10,0,10,0)
            this.clipToPadding = false
//            this.layoutManager = ScrollZoomLayoutManager(this@MainActivity,1)
            this.layoutManager = LinearLayout(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            snapHelper.attachToRecyclerView(this)

        }

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
//        rv_animal_list.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it

    }

    // Adds animals to the empty animals ArrayList
    fun addAnimals() {
        animals.add("dog")
        animals.add("cat")
        animals.add("owl")
        animals.add("cheetah")
        animals.add("raccoon")
        animals.add("bird")
        animals.add("snake")
        animals.add("lizard")
        animals.add("hamster")
        animals.add("bear")
        animals.add("lion")
        animals.add("tiger")
        animals.add("horse")
        animals.add("frog")
        animals.add("fish")
        animals.add("shark")
        animals.add("turtle")
        animals.add("elephant")
        animals.add("cow")
        animals.add("beaver")
        animals.add("bison")
        animals.add("porcupine")
        animals.add("rat")
        animals.add("mouse")
        animals.add("goose")
        animals.add("deer")
        animals.add("fox")
        animals.add("moose")
        animals.add("buffalo")
        animals.add("monkey")
        animals.add("penguin")
        animals.add("parrot")

    }

}