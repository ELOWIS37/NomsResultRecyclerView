import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elowis.nomsresultrecyclerview.R
import com.elowis.nomsresultrecyclerview.model.ItemsViewModel

class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nom: TextView = itemView.findViewById(R.id.nom)
        private val edat: TextView = itemView.findViewById(R.id.edat)

        fun bind(item: ItemsViewModel) {
            nom.text = item.nom
            edat.text = item.edat.toString()
        }
    }
}
