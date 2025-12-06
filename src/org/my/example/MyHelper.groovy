class HelperImpl implements Serializable {
    String name
    HelperImpl(String name) { this.name = name }
    def greet() { println "Hello, ${name}!" }
    def getUserInfo() { return "User info: ${name}" }
}

def create(String name) {
    return new HelperImpl(name)
}

return this
