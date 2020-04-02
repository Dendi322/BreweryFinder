import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ua.horishnii.breweryfinder.R
import com.ua.horishnii.breweryfinder.db.Brewery
import kotlinx.android.synthetic.main.item_recycler_breweries_list.view.*

class MyAdapter() : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val recyclerItem: View) : RecyclerView.ViewHolder(recyclerItem)

    private var myDataset: List<Brewery> = emptyList()

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_breweries_list, parent, false)
        return MyViewHolder(textView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val brewery = myDataset[position]
        if (brewery.name!!.isNotEmpty()) {
            holder.recyclerItem.text_name.text = brewery.name
        }
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    fun setData(breweryList: List<Brewery>) {
        myDataset = breweryList
        notifyDataSetChanged()
    }

}