package util

class MyUtility implements Serializable {
    def script

    MyUtility(script) {
        this.script = script
    }

    def listFiles(String dirPath) {
        script.sh(script: "ls -1 ${dirPath}", returnStdout: true).trim().split("\n")
    }

    def printFiles(String dirPath) {
        listFiles(dirPath).each { script.echo it }
    }
}
