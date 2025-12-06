package org.my.example

// Non-shared lib, sandbox-safe helper
class MyHelper {

    // Prints some basic environment variables
    def printEnv() {
        // env is automatically visible in Jenkins pipeline context
        println "JOB_NAME: ${env.JOB_NAME}"
        println "BUILD_NUMBER: ${env.BUILD_NUMBER}"
        println "NODE_NAME: ${env.NODE_NAME}"
        println "WORKSPACE: ${env.WORKSPACE}"
    }

    // Example method to simulate some logic
    def sayHello(String name) {
        println "Hello, ${name}! Welcome to Jenkins."
    }
}
