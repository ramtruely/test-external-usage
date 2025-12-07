pipeline {
    agent any

    stages {
        stage('Load Shared Library from Nexus') {
            steps {
                script {
                    library(
                        identifier: 'external-shared-libraries@1.1.0',
                        retriever: nexus(
                            artifactDetails: 'com.fact:fact-lib:1.1.0:zip:lib',
                            mavenHome: 'C:\\ProgramData\\chocolatey\\lib\\maven\\apache-maven-3.9.11\\bin'
                        )
                    )
                }
            }
        }

        stage('Use Library') {
            steps {
                script {
                   example1()
                }
            }
        }
    }
}
