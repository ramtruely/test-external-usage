library(
    identifier: 'external-shared-libraries@1.1.0',
    retriever: nexus(
        artifactDetails: 'com.fact:fact-lib:1.1.0:zip:lib', 
        mavenHome: 'C:\\ProgramData\\chocolatey\\lib\\maven\\apache-maven-3.9.11'
    )
)

pipeline {
    agent any

    stages {
         stage('Run shared function') {
      steps {
        script {
          example1()
        }
      }
    }
  }
}
