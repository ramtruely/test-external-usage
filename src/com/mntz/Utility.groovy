class Utility implements Serializable {
    String env

    Utility(String env) {
        this.env = env
    }

    def doSomething() {
        return "Utility doing something in environment: ${env}"
    }
}
