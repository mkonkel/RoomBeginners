package mkonkel.com.room.database.migration

import android.arch.persistence.db.framework.FrameworkSQLiteOpenHelperFactory
import android.arch.persistence.room.testing.MigrationTestHelper
import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import mkonkel.com.room.database.AppDatabase
import mkonkel.com.room.database.Migrations
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@SmallTest
@RunWith(AndroidJUnit4::class)
class MigrationTest {

    private val TEST_DB_NAME = "test.db"

    @Rule @JvmField
    val testHelper: MigrationTestHelper = MigrationTestHelper(
            InstrumentationRegistry.getInstrumentation(),
            AppDatabase::class.java.canonicalName,
            FrameworkSQLiteOpenHelperFactory()
    )

    @Test
    @Throws(Exception::class)
    fun migration_5_6() {
        val db_v_5 = testHelper.createDatabase(TEST_DB_NAME, 5)

        testHelper.runMigrationsAndValidate(TEST_DB_NAME, 6,true, Migrations.MIGRATION_5_6)
    }
}