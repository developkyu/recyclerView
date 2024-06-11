package com.example.recyclerviewkt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(val profileList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        //list_item.xml에 있는 데이터를 불러와서 어댑터에 붙여주는 코드
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        //상단에 만든 view를 아래에 넣어줌
        return CustomViewHolder(view).apply {
            //리사이클뷰 화면의 아이템뷰를 누르면 클릭버튼이 활성되도록 하는 명령코드
            itemView.setOnClickListener {
                val curPos : Int = adapterPosition
                val profile : Profiles = profileList.get(curPos)
                Toast.makeText(parent.context, "이름 : ${profile.name} 나이 : ${profile.age} 직업 : ${profile.job}", Toast.LENGTH_SHORT).show()

            }

        }
    }
    // 리사이클뷰가 실행이 되면 아이콘의 총 개수를 적는 코드
    override fun getItemCount(): Int {
        // 프로필리스트 사이즈 만큼 아이콘을 불러내는 코드
        return profileList.size

    }
    // 리사이클뷰에서 스크롤을 할 때 지속적으로 온바인드뷰홀더가 지속적으로 호출이 되면서 안정적으로 데이터가 매치 되도록하는 역할
    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        //현재 클릭한 위치...
        holder.gender.setImageResource(profileList.get(position).gender)
        holder.name.text = profileList.get(position).name
        //age는 최초 Int(숫자)형태로 되어 있기에 'toString()'(문자열로 변환하는 코드)코드를 추가하지 않으면 오류가 남
        holder.age.text = profileList.get(position).age.toString()
        holder.job.text = profileList.get(position).job
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile) // 성별
        val name = itemView.findViewById<TextView>(R.id.tv_name)       // 이름
        val age = itemView.findViewById<TextView>(R.id.tv_age)         // 나이
        val job = itemView.findViewById<TextView>(R.id.tv_job)         // 직업
    }
}