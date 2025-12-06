package com.mntz

class Helper {
    def name

    Helper(name) {
        this.name = name
    }

    def greet() {
        println "Greetings, ${name}!"
    }

    static def staticGreet() {
        println "Hello from Helper.staticGreet()"
    }
}
