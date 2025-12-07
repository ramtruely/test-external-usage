pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:\\ProgramData\\chocolatey\\lib\\maven\\apache-maven-3.9.11'
        PATH = "${MAVEN_HOME}\\bin;${env.PATH}"
        NEXUS_URL = 'http://localhost:8081/repository/maven-shared-lib/'
        ARTIFACT = 'com.fact:fact:1.1.0:zip:lib'
        LOCAL_LIB_DIR = '.shared'
    }

    stages {
        stage('Download Shared Library from Nexus') {
            steps {
                script {
                    // Clean old library
                    bat "rmdir /S /Q ${env.LOCAL_LIB_DIR} 2>nul || echo No previous library"

                    bat "mkdir ${env.LOCAL_LIB_DIR}"

                    // Use Maven dependency:get to download the zip
                    bat """
                    "${MAVEN_HOME}\\bin\\mvn" dependency:get ^
                        -Dartifact=${env.ARTIFACT} ^
                        -Ddest=${env.LOCAL_LIB_DIR}\\sharedlib.zip ^
                        -DremoteRepositories=${env.NEXUS_URL}
                    """

                    // Extract the zip using PowerShell
                    bat "powershell -Command \"Expand-Archive -LiteralPath '${env.LOCAL_LIB_DIR}\\sharedlib.zip' -DestinationPath '${env.LOCAL_LIB_DIR}' -Force\""
                }
            }
        }

        stage('Load Shared Library Explicitly') {
            steps {
                script {
                    // Explicitly load the library from folder
                    library identifier: 'fact-lib@1.1.0',
                        retriever: legacySCM(
                            [$class: 'DirectorySCM', directory: "${env.WORKSPACE}\\${env.LOCAL_LIB_DIR}"]
                        )
                }
            }
        }

        stage('Test Shared Library') {
            steps {
                script {
                    // Example usage of a vars method or class
                    echo "Calling shared library function:"
                    mySharedVar() // replace with your actual method or variable from the library
                }
            }
        }
    }
}
