package com.mntz

class Utility {
    def env

    Utility(env) {
        this.env = env
    }

    def printEnv() {
        println "Environment is: ${env}"
    }

    static def staticHello() {
        println "Hello from Utility.staticHello()"
    }
}
