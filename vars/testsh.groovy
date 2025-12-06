def runTestSh() {
    echo "Running NON shared lib test.sh …"

    // read from workspace
    def content = readFile 'resources/test.sh'

    // write a new file
    writeFile file: 'test.sh', text: content

    sh 'chmod +x test.sh'
    sh './test.sh'
}

return this
