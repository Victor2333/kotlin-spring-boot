package com.victor.io.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloWorld @Autowired constructor(
    val superTest: SuperTest
) {

    @GetMapping("/api")
    fun helloWorld(): String {
        return superTest.hello()
    }

    @GetMapping("/getFoo")
    fun getFoo():String {
        return superTest.foo()
    }

    @GetMapping("/getSuperFoo")
    fun getSuperFoo():String {
        return superTest.superFoo()
    }
}

open class Test {
    open val test = { i: Int ->
        "hello $i"
    }
}

@Service
class SuperTest : Test() {
    override var test = { a: Int ->
        "$a hello world"
    }

    fun hello(): String {
        return "Hello World!"
    }

    fun foo(): String {
        return this.test(20)
    }

    fun superFoo(): String {
        return super.test(21)
    }
}