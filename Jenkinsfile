@Library('fact-lib@1.1.0') _

pipeline {
    agent any

    stages {
        stage('Load Shared Library from Nexus') {
            steps {
                script {
                    // Explicit library retrieval from Nexus using HTTPS
                    library identifier: 'fact-lib@1.1.0',
                            retriever: nexus(
                                artifactDetails: 'com.fact:fact:1.1.0:zip:lib',
                                nexusUrl: 'https://nexus.example.com/repository/maven-shared-lib/',
                                credentialsId: 'nexus-https-creds',  // Jenkins credential for Nexus username/password
                                mavenHome: 'C:\\tools\\apache-maven-3.8.8'  // path to Maven on agent
                            )

                    // Example usage from vars/hello.groovy
                    example1()
                }
            }
        }
    }
}
