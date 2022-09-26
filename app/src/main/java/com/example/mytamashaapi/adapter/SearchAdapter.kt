package com.example.mytamashaapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.mytamashaapi.R
import com.example.mytamashaapi.model.EmployeeData

class SearchAdapter(private val context: Context, ): BaseExpandableListAdapter() {
    var data= ArrayList<EmployeeData>()

    fun setUpdatedList(data:ArrayList<EmployeeData>){
        this.data= data
        notifyDataSetChanged()
    }
    override fun getGroupCount(): Int {
        return data.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return 1
    }

    override fun getGroup(p0: Int): EmployeeData {
        return data.get(p0)
    }

    override fun getChild(p0: Int, p1: Int): EmployeeData {
        return data.get(p0)
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        val header=getGroup(p0)
        var convertView=p2
        if(convertView==null){
            val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView=inflater.inflate(R.layout.li_search_item, null)

        }
        val empName=convertView!!.findViewById<TextView>(R.id.empName)
        val empProfile=convertView!!.findViewById<ImageView>(R.id.empProfilePic)
        val empId=convertView!!.findViewById<TextView>(R.id.empId)
        empName.text=header.eName
        empId.text=header.id.toString()
        Glide.with(convertView.context)
                    .load(header.profilePic)
                    .into(empProfile)

        return convertView
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        val child=getChild(p0,p1)
        var convertView=p3
        if(convertView==null){
            val inflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView=inflater.inflate(R.layout.li_child_item, null)

        }
        val salary=convertView!!.findViewById<TextView>(R.id.salary)
        salary.text="Salary:- "+child.eSalary.toString()
        return convertView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return false
    }
}

