pipeline {
  agent any

  libraries {
    lib("my-shared-lib@1.1.0")
  }

  options {
    skipDefaultCheckout true
  }

  environment {
    NEXUS_URL = "http://localhost:8081/repository/maven-shared-lib/com/fact/1.1.0/fact-1.1.0-lib.zip"
  }

  stages {
    stage('Load Shared Library') {
      steps {
        script {
          // download zip
          sh """
            curl -u admin:admin -o sharedlib.zip $NEXUS_URL
          """

          // unzip to workspace
          sh """
            unzip -o sharedlib.zip -d sharedlib
          """

          // add this folder to library path
          library identifier: "my-shared-lib@1.1.0",
            retriever: modernSCM(
              [$class: 'LegacySCMSource', scm: [
                $class: 'hudson.scm.SubversionSCM',
                locations: [[remote: "file://${WORKSPACE}/sharedlib"]]
              ]]
            )
        }
      }
    }

    stage('Run shared function') {
      steps {
        script {
          example1()
        }
      }
    }
  }
}
