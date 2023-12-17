package jetpack.tutorial.cryptoapp.features.crypto.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoListing

@Dao
interface CryptoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCryptoListing(
        cryptoListings: List<CryptoListing>
    )

    @Query("DELETE FROM cryptoListingEntity")
    suspend fun clearCryptoListings()

    @Query("""
        SELECT * 
        FROM cryptolistingentity
        WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' OR
        UPPER(:query) == symbol
    """)
    suspend fun searchCryptoListings(query: String): List<CryptoListing>
}