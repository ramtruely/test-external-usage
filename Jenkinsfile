def libs
def config

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

                    properties([parameters(paramList)])
                }
            }
        }

        stage("init libs") {
            steps {
                script {
                    // AUTO-LOAD all groovy files from vars/
                    libs = [:]
                    def files = findFiles(glob: 'vars/*.groovy')
                    files.each { file ->
                        def name = file.name.replace('.groovy','')
                        libs[name] = load file.path
                    }
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
                expression {
                    params.executeTests
                }
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
                    // Use loader to get instances of src/com/mntz classes
                    def loader = libs.loader

                    def utility = loader.get("Utility", "DEV")
                    def helper  = loader.get("Helper", "Ram")

                    // Call methods on instances
                    utility.doSomething()
                    helper.doSomethingElse()
                }
            }
        }
    }   
}
