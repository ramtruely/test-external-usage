// vars/loader.groovy
def call() {
    return this
}

// Dynamically load a class from src/com/mntz/
def get(String className, Object... args) {
    // Build path to the groovy file
    def path = "src/com/mntz/${className}.groovy"

    // Load the groovy file
    def clsScript = load path

    // Create an instance of the class (assumes default constructor or parameters)
    def instance
    if(args) {
        instance = clsScript.newInstance(*args)
    } else {
        instance = clsScript.newInstance()
    }

    return instance
}
