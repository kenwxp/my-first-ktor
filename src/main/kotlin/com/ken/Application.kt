package com.ken

import com.ken.dao.DatabaseFactory
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.ken.plugins.*

fun main() {
    embeddedServer(Netty, port = 1234, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    //初始化数据库
    DatabaseFactory.init()
    configureHTTP()
    configureSockets()
    configureRouting()
}
