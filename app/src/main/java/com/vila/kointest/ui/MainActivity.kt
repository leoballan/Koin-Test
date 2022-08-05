package com.vila.kointest.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.vila.kointest.databinding.ActivityMainBinding
import com.vila.kointest.model.Warrior
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private val viewmodel : MandroidViewModel by viewModel()
    private lateinit var binding : ActivityMainBinding
    private val guerrero : Warrior by inject()
    val newGuerrero : Warrior by inject()
    var year = 0
    var month = 0
    var day = 0
    var hour = 0
    var minute = 0
    lateinit var timePickerDialog :TimePickerDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        init()
    }

    private fun init(){
        newGuerrero.force = 200
        newGuerrero.type = "General"

        Log.d("Mcontrol", "Detalles de Warrior " +
                "${guerrero.type} ... ${guerrero.force}")

        val calendar = Calendar.getInstance()
         year = calendar[Calendar.YEAR]
         month = calendar[Calendar.MONTH]
         day = calendar[Calendar.DAY_OF_MONTH]
        hour = calendar[Calendar.HOUR]
        minute = calendar[Calendar.MINUTE]

        viewmodel.test()
        //initObservers()
        initListeners()

    }

    private fun initListeners(){
        DatePickerDialog(this,{ p, y, m, d  ->

            Log.d("mControl","Ha seleccionado año:$y ... mes:$m ... dia:$d")
                timePickerDialog.show()
            }
            ,year,month,day).show()


        timePickerDialog = TimePickerDialog(this, { _, h, m ->



                Log.d("mControl","Ha seleccionado Hora:$h ... minutos:$m ")
                Log.d("mControl","UUID aleatorio ${UUID.randomUUID()} ")
                Log.d("mControl","numero aleatorio ${Random().nextInt(100)} ")

            }
            ,hour,minute,false)
    }

    /*private fun initObservers() {
        viewmodel.fetchDataBeterWay().observe(this,{result ->
            Log.d("mControl", result)
        })
    }*/

}