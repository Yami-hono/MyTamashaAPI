package com.example.mytamashaapi.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytamashaapi.network.NetworkService
import com.example.mytamashaapi.network.RetrofitInstance
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel: ViewModel() {

    val searchResponse = MutableLiveData<TamashaResponse>()

    fun getEmpList(){
        viewModelScope.launch{
            try {
                val retrofitInstance= RetrofitInstance.getRetrofitInstance().create(NetworkService::class.java)
                val res=retrofitInstance.getTamashaList()
                if(res.isSuccessful){
                    searchResponse.value=res.body()
                }
                else{
                }
            }catch (ex:Exception){

            }
        }
    }
}
