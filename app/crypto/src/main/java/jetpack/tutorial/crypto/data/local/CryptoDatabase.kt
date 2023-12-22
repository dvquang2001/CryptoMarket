package jetpack.tutorial.crypto.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CryptoListingEntity::class],
    version = 1
)
abstract class CryptoDatabase: RoomDatabase() {
    abstract val dao: CryptoDao
}