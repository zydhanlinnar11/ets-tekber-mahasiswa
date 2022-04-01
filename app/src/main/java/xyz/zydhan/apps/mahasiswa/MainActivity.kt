package xyz.zydhan.apps.mahasiswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var mhsAdapter: MahasiswaAdapter
    private val listMhs = arrayListOf<Mahasiswa>()

    override fun onClick(view: View) {
        if (view.id != R.id.submit_button) return

        val nameEt: EditText = findViewById(R.id.name)
        val nrpEt: EditText = findViewById(R.id.nrp)
        val ipkEt: EditText = findViewById(R.id.ipk)
        val maleRb: RadioButton = findViewById(R.id.male)
        val femaleRb: RadioButton = findViewById(R.id.female)
        val isMale: Boolean = maleRb.isChecked
        val isFemale: Boolean = femaleRb.isChecked

        try {
            val name: String = nameEt.text.toString()

            if (name.isBlank()) throw IllegalArgumentException(getString(R.string.please_fill_name))

            val nrp: String = nrpEt.text.toString()

            if (nrp.isBlank()) throw IllegalArgumentException(getString(R.string.please_fill_nrp))

            val ipk: Float = ipkEt.text.toString().toFloat()

            if (!isFemale && !isMale)  throw IllegalArgumentException(getString(R.string.please_fill_gender))

            val gender: Gender = if (isMale) Gender.MALE else Gender.FEMALE

            val mhs = Mahasiswa(name, nrp, ipk, gender)
            this.listMhs.add(mhs)
            this.mhsAdapter.notifyItemInserted(this.listMhs.size - 1)
        } catch (e: NumberFormatException) {
            Toast.makeText(this.applicationContext, R.string.please_fill_gpa, Toast.LENGTH_SHORT).show()
        } catch (e: IllegalArgumentException) {
            Toast.makeText(this.applicationContext, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.submit_button).setOnClickListener(this)
        this.recyclerView = findViewById(R.id.list_mhs)
        this.mhsAdapter = MahasiswaAdapter(this.listMhs)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        this.recyclerView.layoutManager = layoutManager
        this.recyclerView.adapter = this.mhsAdapter
    }
}