pipeline {
    agent any
    stages {
        stage('Load Shared Lib') {
            steps {
                script {
                    library identifier: 'my-nexus-lib@1.0.0',
                            retriever: nexus(
                                artifactDetails: 'com.example:shared-lib:1.0.0:zip:lib',  // Your GAVC
                                mavenHome: 'C:/ProgramData/chocolatey/lib/maven/apache-maven-3.9.11'  // Run `mvn -v` for path
                            )
                }
            }
        }
        stage('Use Lib') {
            steps {
                script {
                    example1()
                }
            }
        }
    }
}
