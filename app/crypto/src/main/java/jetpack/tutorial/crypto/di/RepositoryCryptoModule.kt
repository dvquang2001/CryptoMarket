package jetpack.tutorial.crypto.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jetpack.tutorial.crypto.data.local.CryptoDatabase
import jetpack.tutorial.crypto.data.remote.CryptoApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryCryptoModule {

    @Provides
    @Singleton
    fun provideCryptoApi(): CryptoApi {
        return Retrofit.Builder()
            .baseUrl(CryptoApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideCryptoDatabase(app: Application): CryptoDatabase {
        return Room.databaseBuilder(
            app,
            CryptoDatabase::class.java,
            "crypto_db.db"
        ).build()
    }
}