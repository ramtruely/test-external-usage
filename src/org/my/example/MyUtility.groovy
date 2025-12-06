class UtilityImpl implements Serializable {
    String env
    UtilityImpl(String env) { this.env = env }
    def printEnv() { println "UtilityImpl env=${env}" }
    def getEnvInfo() { return "Environment info: ${env}" }
}

// factory function exposed to caller
def create(String env) {
    return new UtilityImpl(env)
}

// return this script object so load(...) returns something useful
return thispackage org.my.example

class MyHelper implements Serializable {

    def sayHello(String name) {
        return "Hello " + name
    }

    def addNumbers(int a, int b) {
        return a + b
    }
}
