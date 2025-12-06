pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Init') {
            steps {
                script {
                    def loaderVar = load('crc/com/loader.groovy')
                    def classes = loaderVar.loadClasses()

                    env.utility = classes['Utility']
                    env.helper  = classes['Helper']
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo "Testing the application..."
                    echo env.utility.doSomething()
                    echo env.helper.doSomethingElse()
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                    echo "Deploying version 1.0.0"
                }
            }
        }

        stage('Validate') {
            steps {
                script {
                    echo "Validating the application..."
                    echo "Validating version 1.0.0"
                }
            }
        }
    }
}
