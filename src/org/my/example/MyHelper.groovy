package org.my.example

class MyHelper implements Serializable {

    def sayHello(String name) {
        return "Hello " + name
    }

    def addNumbers(int a, int b) {
        return a + b
    }
}
