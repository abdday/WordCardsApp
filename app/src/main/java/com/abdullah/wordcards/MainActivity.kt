package com.abdullah.wordcards

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.abdullah.wordcards.DataBase.Card
import com.abdullah.wordcards.DataBase.AppDataBase
import com.abdullah.wordcards.DataBase.CardRepo
import com.abdullah.wordcards.DataBase.DataBaseHelper
import com.abdullah.wordcards.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.Timestamp
import java.time.OffsetDateTime

class MainActivity : AppCompatActivity() {

   /// private lateinit var binding: ActivityMainBinding

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
     ///   binding = ActivityMainBinding.inflate(layoutInflater)
       /// setContentView(binding.root)

        //val Database = Room.databaseBuilder(applicationContext , AppDataBase::class.java , "CardDatabase").build()
       // val db = Database.cardDao()
      //  db.insertNewCard(Card(5 , "Comprihensivly" , "majani" , Timestamp(System.nanoTime()) ))


        val db = CardRepo(application)
        db.addCard(Card(0, "ali", "alll", OffsetDateTime.now()))

      /*
        val db = AppDataBase.getDatabase(this).cardDao()

        lifecycleScope.launch(Dispatchers.IO) {
            db.insertNewCard(Card(0, "ali", "alll", OffsetDateTime.now()))

        }
        */

        val navView :BottomNavigationView = binding.navView
        ///val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

/*
        val dbHelper = Room.databaseBuilder(applicationContext , AppDataBase::class.java , "cardDB").build()

        val db = dbHelper.cardDao()
*/

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)




      ///  val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_home , R.id.navigation_dashboard , R.id.navigation_notifications))
        setupActionBarWithNavController(navController , appBarConfiguration)

        navView.setupWithNavController(navController)

        /* ///val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
   */

    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }
}