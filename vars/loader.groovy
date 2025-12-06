def loadClasses() {
    def classesMap = [:]

    // Instantiate classes directly
    classesMap['Utility'] = new Utility("DEV")
    classesMap['Helper']  = new Helper("Ram")

    return classesMap
}
