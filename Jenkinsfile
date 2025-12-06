def libs        // for vars/*.groovy
def classes     // for src/com/mntz/*.groovy
def config
def utility
def helper

pipeline {
    agent any

    stages {

        stage('init parameters') {
            steps {
                script {
                    config = readYaml file: 'devops/parameters.yaml'

                    def paramList = []
                    config.parameters.each { name, map ->
                        if (map.type == 'choice') {
                            paramList << choice(name: name, choices: map.values.join('\n'))
                        }
                        if (map.type == 'boolean') {
                            paramList << booleanParam(name: name, defaultValue: map.default)
                        }
                    }

                    properties([
                        parameters(paramList)
                    ])
                }
            }
        }

        stage("init") {
            steps {
                script {
                    // -----------------------------
                    // AUTO-LOAD all groovy files from vars/ folder
                    // -----------------------------
                    libs = [:]
                    def files = findFiles(glob: 'vars/*.groovy')
                    files.each { file ->
                        def name = file.name.replace('.groovy','')
                        libs[name] = load file.path
                    }

                    // -----------------------------
                    // AUTO-LOAD all classes from src/com/mntz/ folder
                    // -----------------------------
                    classes = [:]
                    def classFiles = findFiles(glob: 'src/com/mntz/*.groovy')
                    classFiles.each { file ->
                        def className = file.name.replace('.groovy','')
                        def classScript = load file.path
                        classes[className] = classScript
                    }

                    // -----------------------------
                    // Instantiate classes if needed
                    // -----------------------------
                    utility = new com.mntz.Utility("DEV")
                    helper = new com.mntz.Helper("Ram")
                }
            }
        }

        stage("build") {
            steps {
                script {
                    libs.build.buildApp()
                }
            }
        }

        stage("test") {
            when {
                expression { params.executeTests }
            }
            steps {
                script {
                    libs.test.testApp()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    libs.deploy.deployApp()
                }
            }
        }

        stage("validate") {
            steps {
                script {
                    libs.validate.validateApp()
                }
            }
        }

        stage("use classes") {
            steps {
                script {
                    // Example usage of classes from src/com/mntz/
                    
                    // Instance methods
                    utility.printEnv()
                    helper.greet()

                    // Static methods
                    com.mntz.Utility.staticHello()
                    com.mntz.Helper.staticGreet()
                }
            }
        }
    }
}
