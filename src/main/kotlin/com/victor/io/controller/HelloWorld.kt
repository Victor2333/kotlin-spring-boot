package com.victor.io.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloWorld @Autowired constructor(
    val superTest: SuperTest,
    val abstractClass: ExtendAbstractClass
) {

    @GetMapping("/api")
    fun helloWorld(): String {
        return superTest.hello()
    }

    @GetMapping("/getFoo")
    fun getFoo(): String {
        return superTest.foo()
    }

    @GetMapping("/getSuperFoo")
    fun getSuperFoo(): String {
        return superTest.superFoo()
    }

    @GetMapping("getAbstractClass")
    fun getExtendAbstractClass(): String {
        return abstractClass.hi()
    }
}

open class Test {
    open val test = { i: Int ->
        "hello $i"
    }
}

interface Super {
    fun helloSuper(): String
}

@Service
class SuperTest : Test(), Super {
    override fun helloSuper(): String {
        return "hello Super"
    }

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

abstract class AbstractClass {
    abstract fun hi(): String

    abstract val abstract: (Int) -> String
}

@Service
class ExtendAbstractClass(
    override val abstract: (Int) -> String = {
        a:Int -> "$a Hello"
    }
) : AbstractClass() {
    override fun hi(): String {
        return this.abstract(0)
    }
}