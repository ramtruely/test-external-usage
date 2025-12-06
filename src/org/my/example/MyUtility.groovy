// src/org/my/example/MyUtility.groovy
import java.io.Serializable

class MyUtility implements Serializable {
    def steps

    MyUtility(steps) {
        this.steps = steps
    }

    def listFiles(String dirPath) {
        def files = steps.sh(script: "ls -1 ${dirPath}", returnStdout: true).trim().split("\n")
        return files
    }

    def printFiles(String dirPath) {
        def files = listFiles(dirPath)
        files.each { steps.echo it }
    }
}
return this
