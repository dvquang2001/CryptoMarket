package jetpack.tutorial.cryptoapp.features.crypto.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CryptoListingEntity(
    @PrimaryKey val idLocal: Int? = null,
    val id: String ,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Double,
)