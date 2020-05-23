package ps.room.com

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class BookViewModel(application: Application): AndroidViewModel(application){
    private var bookDao: BookDao
    val allBooks: LiveData<List<Book>>

    init {
        val bookDb = BookRoomDatabase.getDatabase(application)
        bookDao = bookDb!!.bookDao()
        allBooks = bookDao.allBooks
    }

    fun insert(book: Book){
        GlobalScope.async {
            bookDao.insert(book)
        }
        //InsertAsyncTask(bookDao!!).execute(book)
    }

    fun deleteAll(){
        GlobalScope.async {
            bookDao.deleteAllBooks()
        }
    }

    companion object {
        private class InsertAsyncTask(private val bookDao: BookDao): AsyncTask<Book, Void, Void?>() {
            override fun doInBackground(vararg books: Book): Void? {
                bookDao.insert(books[0])
                return null
            }
        }
    }
}