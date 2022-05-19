package www.onbeatapps.com.ui.lineUp

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import www.onbeatapps.com.databinding.AdapterLineUpBinding
import www.onbeatapps.com.databinding.SampleListItemBinding
import java.util.*

/**
 * Created by PKB on 11-06-2021.
 * PKB@gmail.com
 */
class LineUpAdapter(private val context: Context, val clickFunction: () -> Unit) :
    RecyclerView.Adapter<LineUpAdapter.MyViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var dataList = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "")

    //This method inflates view present in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(AdapterLineUpBinding.inflate(inflater, parent, false));
    }

    //Binding the data using get() method of POJO object
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItems = dataList[position]
        holder.bindView(listItems, position)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setListContent(listItems: ArrayList<String>) {
        dataList = listItems
        notifyDataSetChanged()
    }

    inner class MyViewHolder(b: AdapterLineUpBinding) : RecyclerView.ViewHolder(b.root) {
        fun bindView(listItems: String, position: Int) {
            binding.root.setOnClickListener { clickFunction() }
            binding.apply {
                if (position == 4)tvLive.visibility = View.VISIBLE
                else tvLive.visibility = View.GONE
            }
        }

        var binding: AdapterLineUpBinding = b

    }
}