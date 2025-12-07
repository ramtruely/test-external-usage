pipeline {
  agent any

  environment {
    NEXUS_LIB = "http://localhost:8081/repository/maven-shared-lib/com/fact/1.1.0/fact-1.1.0-lib.zip"
  }

  stages {
    stage('Download Shared Lib') {
      steps {
        script {
          bat """
            curl -u admin:admin -o sharedlib.zip %NEXUS_LIB%
            rmdir /S /Q .shared 2>nul
            mkdir .shared
            tar -xf sharedlib.zip -C .shared
          """
        }
      }
    }

    stage('Load Shared') {
      steps {
        script {
          library(
            identifier: "my-shared-lib@1.1.0",
            retriever: [
              $class: 'SCMSourceRetriever',
              scm: [
                $class: 'DirectorySCM',
                directory: "${env.WORKSPACE}\\.shared"
              ]
            ]
          )
        }
      }
    }

    stage('Test') {
      steps {
        script {
          example1()
        }
      }
    }
  }
}
