package com.victor.io.controller

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringRunner::class)
@WebMvcTest(HelloWorld::class)
class HelloWorldTest {

    @Autowired
    lateinit var mockMvc: MockMvc
    @MockBean
    lateinit var helloWorld: HelloWorld

    @Test
    fun helloWorldTest() {
        given(this.helloWorld.helloWorld()).willReturn("Hello World!")
        this.mockMvc.perform(get("/hello/api").accept(MediaType.TEXT_PLAIN)).andExpect(status().isOk)
            .andExpect(content().string("Hello World!"))
    }

    @Test
    fun fooTest() {
        given(this.helloWorld.getFoo()).willReturn("20 hello world")
        this.mockMvc.perform(get("/hello/getFoo").accept(MediaType.TEXT_PLAIN)).andExpect(status().isOk)
            .andExpect(content().string("20 hello world"))
    }

    @Test
    fun superFooTest() {
        given(this.helloWorld.getSuperFoo()).willReturn("hello 21")
        this.mockMvc.perform(get("/hello/getSuperFoo").accept(MediaType.TEXT_PLAIN)).andExpect(status().isOk)
            .andExpect(content().string("hello 21"))
    }
}

