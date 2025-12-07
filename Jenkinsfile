pipeline {
  agent any

  stages {
    
    stage('Load Shared Lib From Nexus') {
      steps {
        script {
          sh """
            curl -u admin:admin \
             -o sharedlib.zip \
             http://localhost:8081/repository/maven-shared-lib/com/fact/1.1.0/fact-1.1.0-lib.zip

            rm -rf .shared
            mkdir .shared
            unzip sharedlib.zip -d .shared
          """
        }

        library(
          identifier: "my-shared-lib@1.1.0",
          retriever: [
            $class: 'SCMSourceRetriever',
            scm: [
              $class: 'DirectorySCM',
              directory: "${env.WORKSPACE}/.shared"
            ]
          ]
        )
      }
    }

    stage('Test Call') {
      steps {
        script {
          example1()    
        }
      }
    }
  }
}
