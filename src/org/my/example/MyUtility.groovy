package org.my.example

class MyUtility {

    // Print a custom message
    def printMessage(String message) {
        println "Message: ${message}"
    }

    // Example: simple addition method
    def addNumbers(int a, int b) {
        int result = a + b
        println "Addition Result: ${result}"
        return result
    }

    // Example: check if a file exists in workspace
    def fileExists(String filePath) {
        def file = new File(filePath)
        boolean exists = file.exists()
        println "File '${filePath}' exists? ${exists}"
        return exists
    }
}
