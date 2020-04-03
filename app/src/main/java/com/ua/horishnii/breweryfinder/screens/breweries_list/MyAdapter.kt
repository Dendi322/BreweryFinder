import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ua.horishnii.breweryfinder.R
import com.ua.horishnii.breweryfinder.db.Brewery
import kotlinx.android.synthetic.main.item_recycler_breweries_list.view.*


class MyAdapter() : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val recyclerItem: View) : RecyclerView.ViewHolder(recyclerItem)

    private var myData: List<Brewery> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_breweries_list, parent, false)
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val brewery = myData[position]
        val recyclerItem = holder.recyclerItem

        if (brewery.name.isNullOrEmpty()) {
            recyclerItem.text_name.visibility = View.GONE
        } else {
            recyclerItem.text_name.text = brewery.name
        }

        if (brewery.phone.isNullOrEmpty()) {
            recyclerItem.linear_phone.visibility = View.GONE
        } else {
            recyclerItem.text_phone_value.text = brewery.phone
        }

        if (brewery.websiteUrl.isNullOrEmpty()) {
            recyclerItem.linear_website.visibility = View.GONE
        } else {
            recyclerItem.text_website_value.text = brewery.websiteUrl
        }

        if (brewery.country.isNullOrEmpty()) {
            recyclerItem.linear_country.visibility = View.GONE
        } else {
            recyclerItem.text_country_value.text = brewery.country
        }

        if (brewery.state.isNullOrEmpty()) {
            recyclerItem.linear_state.visibility = View.GONE
        } else {
            recyclerItem.text_state_value.text = brewery.state
        }

        if (brewery.city.isNullOrEmpty()) {
            recyclerItem.linear_city.visibility = View.GONE
        } else {
            recyclerItem.text_city_value.text = brewery.city
        }

        if (brewery.street.isNullOrEmpty()) {
            recyclerItem.linear_street.visibility = View.GONE
        } else {
            recyclerItem.text_street_value.text = brewery.street
        }

        if (brewery.latitude != null && brewery.longitude != null) {
            recyclerItem.btn_show_on_map.setOnClickListener {
                var intentString = "geo:" + brewery.latitude + "," + brewery.longitude
                if (!brewery.name.isNullOrEmpty()) {
                    intentString += "?q=" + brewery.name
                }
                val gmmIntentUri: Uri = Uri.parse(intentString)
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                if (mapIntent.resolveActivity(recyclerItem.context.packageManager) != null) {
                    recyclerItem.context.startActivity(mapIntent)
                }
            }
        } else {
            recyclerItem.btn_show_on_map.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    fun setData(breweryList: List<Brewery>) {
        myData = breweryList
        notifyDataSetChanged()
    }
}