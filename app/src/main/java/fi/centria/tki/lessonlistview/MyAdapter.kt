package fi.centria.tki.lessonlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(private val context:Context, private val dataSource: ArrayList<Users>): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        /*val rowView: View = inflater.inflate(R.layout.list_item, parent, false)
        val textView: TextView = rowView.findViewById(R.id.list_item_name)
        textView.text = dataSource.get(position).firstName
        return rowView*/
        val view:View
        val holder:ViewHolder
        if (convertView == null)
        {
            view = inflater.inflate(R.layout.list_item, parent, false)
            holder = ViewHolder()
            holder.myTextView = view.findViewById(R.id.list_item_name)
            view.tag = holder
        }
        else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }
        holder.myTextView.text = dataSource.get(position).firstName
        return view

    }

    private class ViewHolder{
        lateinit var myTextView: TextView
    }
}