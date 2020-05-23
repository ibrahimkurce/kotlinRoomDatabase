package ps.room.com

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey
    val tableId: String,

    @ColumnInfo(name="author")
    val author: String,

    @ColumnInfo(name="book")
    val book: String
) {

}