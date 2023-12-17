package jetpack.tutorial.cryptoapp.features.auth.data.repository

import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import jetpack.tutorial.cryptoapp.core.Constants.FIREBASE_COLLECTION_USER
import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.auth.data.remote.dto.FireStoreUserModel
import jetpack.tutorial.cryptoapp.features.auth.data.remote.dto.toModel
import jetpack.tutorial.cryptoapp.features.auth.domain.model.LoginModel
import jetpack.tutorial.cryptoapp.features.auth.domain.model.RegisterModel
import jetpack.tutorial.cryptoapp.features.auth.domain.model.UserDataModel
import jetpack.tutorial.cryptoapp.features.auth.domain.payload.LoginPayload
import jetpack.tutorial.cryptoapp.features.auth.domain.payload.RegisterPayload
import jetpack.tutorial.cryptoapp.features.auth.domain.repository.AuthRepository
import jetpack.tutorial.cryptoapp.features.auth.domain.usecase.reset_password.ResetPasswordParam
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthRepository @Inject constructor(
    private val db: FirebaseFirestore,
    private val auth: FirebaseAuth
) : AuthRepository {

    private val userInfoFlow: MutableSharedFlow<UserDataModel> = MutableSharedFlow(replay = 1)
    private var userInfoListenerRegistration: ListenerRegistration? = null

    override fun loginWithEmailPassword(payload: LoginPayload): Flow<ResultModel<LoginModel>> {
        return flow {
            val result = try {
                val signInResult = auth.signInWithEmailAndPassword(
                    payload.email,
                    payload.password
                ).await()
                val userId = signInResult.user!!.uid
                val result = LoginModel(email = payload.email, userId = userId)
                ResultModel.Success(result)
            } catch (t: Throwable) {
                t.printStackTrace()
                ResultModel.Error(t)
            }
            emit(result)
        }
    }

    override fun registerWithEmailPassword(payload: RegisterPayload): Flow<ResultModel<RegisterModel>> {
        return flow {
            val result = try {
                val createAccountResult = auth.createUserWithEmailAndPassword(
                    payload.email,
                    payload.password
                ).await()
                val userId = createAccountResult.user!!.uid
                val firebaseUser = FireStoreUserModel(
                    email = payload.email,
                    name = payload.fullName,
                    createdAt = Timestamp.now()
                )
                db.runBatch {
                    it.set(db.collection(FIREBASE_COLLECTION_USER).document(userId), firebaseUser)
                }.await()
                val result = RegisterModel(
                    email = payload.email,
                    fullName = payload.fullName,
                    id = userId
                )
                ResultModel.Success(result)
            } catch (t: Throwable) {
                t.printStackTrace()
                ResultModel.Error(t)
            }
            emit(result)
        }
    }

    override fun resetPassword(param: ResetPasswordParam): Flow<ResultModel<Boolean>> {
        return flow {
            val result = try {
                auth.sendPasswordResetEmail(param.email).await()
                ResultModel.Success(true)
            } catch (t: Throwable) {
                t.printStackTrace()
                ResultModel.Error(t)
            }
            emit(result)
        }
    }

    override fun getUserInfo(): Flow<ResultModel<UserDataModel>> {
       return flow {
           if(userInfoListenerRegistration == null) subscribeUserInfo()
           emitAll(userInfoFlow.map { ResultModel.Success(it) })
       }
    }

    override fun subscribeUserInfo() {
        userInfoListenerRegistration?.remove()
        userInfoListenerRegistration = db
            .collection(FIREBASE_COLLECTION_USER)
            .document(auth.uid!!)
            .addSnapshotListener { data, error ->
                if(error != null) {
                    error.printStackTrace()
                    return@addSnapshotListener
                }
                data ?: return@addSnapshotListener
                val firebaseDoc = data.toObject(FireStoreUserModel::class.java)
                firebaseDoc?.let {
                    userInfoFlow.tryEmit(firebaseDoc.toModel())
                }
            }

    }

    override fun logout(): Flow<ResultModel<Boolean>> {
        return flow {
            val result = try {
                auth.signOut()
                ResultModel.Success(true)
            } catch (t: Throwable) {
                t.printStackTrace()
                ResultModel.Error(t)
            }
            emit(result)
        }
    }
}