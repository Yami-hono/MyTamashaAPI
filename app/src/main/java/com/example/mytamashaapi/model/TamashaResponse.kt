package com.example.mytamashaapi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class TamashaResponse (
    @SerializedName("data")
    val empData:ArrayList<EmployeeData>?,
    @SerializedName("status")
    val status:String?,
    @SerializedName("message")
    val msg:String?
    )

@Parcelize
data class EmployeeData(
    @SerializedName("id")
    val id:Int?=0,
    @SerializedName("employee_name")
    val eName:String?="",
    @SerializedName("employee_salary")
    val eSalary:Int?=0,
    @SerializedName("employee_age")
    val eAge:Int?=0,
    @SerializedName("profile_image")
    var profilePic:String?
):Parcelable