// sandbox-safe loader.groovy
def loadClasses() {
    def classesMap = [:]

    // Instantiate classes directly
    classesMap['Utility'] = new com.mntz.Utility("DEV")
    classesMap['Helper']  = new com.mntz.Helper("Ram")

    return classesMap
}
