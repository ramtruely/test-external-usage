def runTestSh() {
    echo "Running NON shared lib test.sh …"

    def content = readFile 'resources/test.sh'
    writeFile file: 'test.sh', text: content

    if (isUnix()) {
        sh 'chmod +x test.sh'
        sh './test.sh'
    } else {
        bat 'bat '"C:\\Program Files\\Git\\bin\\bash" test.sh'
    }
}

return this
