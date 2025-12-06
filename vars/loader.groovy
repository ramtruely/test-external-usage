// vars/loader.groovy

// Method to load a class from src/com/mntz dynamically
def get(className, Object... args) {
    // Full package name
    def fullClassName = "com.mntz.${className}"
    // Load class
    def cls = this.class.classLoader.loadClass(fullClassName)
    // Instantiate with constructor arguments
    return cls.newInstance(*args)
}

// Return this object to make methods accessible
return this
