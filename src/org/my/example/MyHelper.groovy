package helper

class MyHelper implements Serializable {
    def script

    MyHelper(script) {
        this.script = script
    }

    def printEnv() {
        script.echo "Workspace: ${script.env.WORKSPACE}"
        script.echo "Build Number: ${script.env.BUILD_NUMBER}"
    }

    def printMessage(String msg) {
        script.echo "Message: ${msg}"
    }
}
