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
                    // Load other Groovy vars
                    def buildVar = load('vars/build.groovy')
                    def deployVar = load('vars/deploy.groovy')
                    def testVar = load('vars/test.groovy')
                    def validateVar = load('vars/validate.groovy')
                    def loaderVar = load('vars/loader.groovy')

                    // Load classes safely
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
