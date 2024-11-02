import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.BookDataClass
import com.example.recycleview.R

class BookAdapter(private val bookList: ArrayList<BookDataClass>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.book_list_item, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentItem = bookList[position]
        holder.imageBook.setImageResource(currentItem.coverImage)
        holder.txtTitle.text = currentItem.title
        holder.txtDescription.text = currentItem.description
    }

    override fun getItemCount() = bookList.size

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageBook: ImageView = itemView.findViewById(R.id.imageBook)
        val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val txtDescription: TextView = itemView.findViewById(R.id.txtDescription)
    }
}
