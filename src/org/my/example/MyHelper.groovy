// src/org/my/example/MyHelper.groovy
import java.io.Serializable

class MyHelper implements Serializable {
    def steps  // reference to Jenkins pipeline steps

    MyHelper(steps) {
        this.steps = steps
    }

    def printEnv() {
        steps.echo "Workspace: ${steps.env.WORKSPACE}"
        steps.echo "Build Number: ${steps.env.BUILD_NUMBER}"
    }

    def printMessage(String msg) {
        steps.echo "Message: ${msg}"
    }
}
return this
