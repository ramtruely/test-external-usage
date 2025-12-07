pipeline {
  agent any

  environment {
    NEXUS_URL = "http://localhost:8081/repository/maven-shared-lib/com/fact/1.1.0/fact-1.1.0-lib.zip"
  }

  stages {
    stage('Load Shared Lib From Nexus') {
      steps {
        script {
          sh """
            curl -u admin:admin -o sharedlib.zip $NEXUS_URL
            rm -rf .shared
            mkdir .shared
            unzip -o sharedlib.zip -d .shared
          """

          library(
            identifier: "my-shared-lib@1.1.0",
            retriever: modernSCM(
              [$class: 'DirectorySCMSource',
               directory: "${env.WORKSPACE}/.shared"]
            )
          )
        }
      }
    }

    stage('Test Call') {
      steps{
        script{
          example1() 
        }
      }
    }
  }
}
