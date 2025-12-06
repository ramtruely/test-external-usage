package com.mntz

class Helper implements Serializable {
    String name

    Helper(String name) {
        this.name = name
    }

    def greet() {
        println "Hi ${name}!"
    }

    def staticGreet() {
        println "Static greet from Helper"
    }
}
