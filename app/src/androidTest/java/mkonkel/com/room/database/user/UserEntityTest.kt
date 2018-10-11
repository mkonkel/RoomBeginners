package mkonkel.com.room.database.user

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import mkonkel.com.room.database.AppDatabase
import mkonkel.com.room.database.dao.UserDao
import mkonkel.com.room.database.getValue
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@SmallTest
@RunWith(AndroidJUnit4::class)
open class UserEntityTest {
    private lateinit var userDao: UserDao
    private lateinit var database: AppDatabase

    @Rule @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getTargetContext()
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
                .allowMainThreadQueries() // for testing only
                .build()

        userDao = database.userDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertUserAndRead() {
        val user = UserData.createUserWithIndex(1)
        userDao.insertUser(user)

        val result = userDao.user(1)

        assertEquals(result.firstName, user.firstName)
    }

    @Test
    @Throws(Exception::class)
    fun insertUpdateAndRead() {
        val user = UserData.createUserWithIndex(1)
        userDao.insertUser(user)

        val queryUser = userDao.user(1)
        userDao.updateUser(queryUser.apply { firstName = "John" })

        val result = userDao.user(1)

        assertEquals(result.firstName, "John")
    }

    @Test
    @Throws(Exception::class)
    fun insertAndDelete() {
        val user = UserData.createUserWithIndex(1)
        userDao.insertUser(user)

        userDao.deleteUser(user)

        val result = userDao.user(1)

        assertNull(result)
    }

    @Test
    @Throws(Exception::class)
    fun insertUserAndReadRx() {
        val user = UserData.createUserWithIndex(2)
        userDao.insertUser(user)

        userDao.userRxFlowable(2)
                .test()
                .assertValue { result ->
                    result.firstName.equals(user.firstName)
                }
    }

    @Test
    @Throws(Exception::class)
    fun insertUserAndReadLiveData() {
        val user = UserData.createUserWithIndex(3)
        userDao.insertUser(user)

        val result = userDao.userLiveData(3)

        assertEquals(getValue(result).firstName, user.firstName)
    }
}