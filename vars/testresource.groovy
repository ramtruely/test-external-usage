def call() {
    // Read resource file located in resources/sample.txt
    def content = libraryResource 'sample.txt'
    echo "Resource Content => ${content}"
}
return this
