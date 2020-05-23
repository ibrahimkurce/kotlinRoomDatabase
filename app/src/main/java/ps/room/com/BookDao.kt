package ps.room.com

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {

    @Insert
    fun insert(book: Book)

    @get:Query("SELECT * FROM books")
    val allBooks: LiveData<List<Book>>

    @Query("DELETE FROM books")
    fun deleteAllBooks()

}