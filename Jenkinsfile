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

                    properties([
                        parameters(paramList)
                    ])
                }
            }
        }

        stage("init") {
            steps {
                script {
                    libs = [:]
                    def files = findFiles(glob: 'vars/*.groovy')
                    files.each { file ->
                        def name = file.name.replace('.groovy','')
                        libs[name] = load file.path
                    }
                }
            }
        }
         stage('Init src') {
            steps {
                script {
                    // Use loader to get instances
                    def myHelper = loader.loadHelper(this)
                    def myUtil = loader.loadUtility(this)

                    myHelper.printEnv()
                    myHelper.printMessage("Hello from Loader!")

                    myUtil.printFiles("${env.WORKSPACE}")
                }
            }
        }

        stage("resource-test") {
            steps {
                script {
                    libs.testresource.testResource()
                }
            }
        }
        stage("test-sh") {
            steps {
                script {
                    libs.testsh.runTestSh()
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
    }
}
