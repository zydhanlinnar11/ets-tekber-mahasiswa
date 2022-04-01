package xyz.zydhan.apps.mahasiswa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter(private val listMhs: ArrayList<Mahasiswa>) :
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
        holder.nameView.text = listMhs[position].name
        holder.nrpView.text = listMhs[position].nrp
        holder.ipkView.text = listMhs[position].ipk.toString()
        holder.genderView.text = listMhs[position].gender.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }
}