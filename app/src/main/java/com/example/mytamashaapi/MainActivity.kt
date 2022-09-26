package com.example.mytamashaapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mytamashaapi.adapter.SearchAdapter
import com.example.mytamashaapi.databinding.ActivityMainBinding
import com.example.mytamashaapi.model.EmployeeData
import com.example.mytamashaapi.model.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private lateinit var searchAdapter: SearchAdapter
    private lateinit var myTable:List<EmployeeData>
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        super.onCreate(savedInstanceState)

        searchAdapter= SearchAdapter(this)
        viewModel.getEmpList()
        binding.recyclerView.setAdapter(searchAdapter)
        addObserver()
    }

    fun addObserver(){
        viewModel.searchResponse.observe(this){
            if(it.empData!=null ) {
                myTable=it.empData
                binding.header.visibility= View.GONE
                searchAdapter.setUpdatedList(it.empData)
            }
        }
    }

}