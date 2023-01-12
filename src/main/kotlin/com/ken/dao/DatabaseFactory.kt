package com.ken.dao
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.*
import org.jetbrains.exposed.sql.transactions.experimental.*

object DatabaseFactory {
    fun init() {
        // 1. postgres
//        val driverClassName = "com.impossibl.postgres.jdbc.PGDataSource"
//        val jdbcURL = "jdbc:pgsql://localhost:5500/zee"
//        val database = Database.connect(jdbcURL, driverClassName, "backend", "zee666")

        // 2. mysql
//        val config = HikariConfig().apply {
//            jdbcUrl         = "jdbc:mysql://localhost:3306/sell_screen"
//            driverClassName = "com.mysql.cj.jdbc.Driver"
//            username        = "root"
//            // password        = "123456"
//            password        = "hantang@20221220"
//            maximumPoolSize = 100
//        }
//        val dataSource = HikariDataSource(config)
//        val database = Database.connect(dataSource)

        // 3. 建表
//        transaction(database) {
//            SchemaUtils.create(Articles)
//            SchemaUtils.create(ShopCandidateTable)
//            SchemaUtils.create(ShopCommodityTable)
//            SchemaUtils.create(CommodityCandidateTable)
//
//            // MySQL不支持序号生成器
//            // SchemaUtils.createSequence(phoneSequence)
//        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}
