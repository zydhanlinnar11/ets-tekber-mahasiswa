package xyz.zydhan.apps.mahasiswa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter(private val listMhs: ArrayList<Mahasiswa>, private val context: Context) :
        RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.name_mhs_list_item)
        val nrpView: TextView = view.findViewById(R.id.nrp_mhs_list_item)
        val ipkView: TextView = view.findViewById(R.id.ipk_mhs_list_item)
        val genderView: TextView = view.findViewById(R.id.gender_mhs_list_item)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = listMhs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameView.text = context.getString(R.string.name_string, listMhs[position].name)
        holder.nrpView.text = context.getString(R.string.nrp_string, listMhs[position].nrp)
        holder.ipkView.text = context.getString(R.string.ipk_string, listMhs[position].ipk)

        val genderString = listMhs[position].gender.toString().lowercase()
        val genderResourceId = context.resources.getIdentifier(genderString, "string", context.packageName)
        holder.genderView.text = context.getString(R.string.gender_string, context.getString(genderResourceId))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }
}