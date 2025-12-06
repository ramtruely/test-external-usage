def call() {
    // load the resource file inside pipeline clone workspace
    def content = readFile "resources/sample.txt"
    echo "Sample.txt content:\n${content}"
}
