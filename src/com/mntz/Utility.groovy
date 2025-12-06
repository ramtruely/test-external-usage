package com.mntz

class Utility implements Serializable {
    String env

    Utility(String env) {
        this.env = env
    }

    def printEnv() {
        println "Current environment is ${env}"
    }

    def staticHello() {
        println "Hello from Utility"
    }
}
