def libs
def classesMap
def config

pipeline {
    agent any

    stages {

        stage('init parameters') {
            steps {
                script {
                    // Read YAML parameters
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

        stage("load classes") {
            steps {
                script {
                    // AUTO-LOAD all groovy classes from src/com/mntz/
                    def loader = new GroovyClassLoader(this.class.classLoader)
                    classesMap = [:]

                    def srcFiles = findFiles(glob: 'src/com/mntz/*.groovy')
                    srcFiles.each { file ->
                        loader.parseClass(new File(file.path))
                        def className = "com.mntz." + file.name.replace('.groovy','')
                        classesMap[file.name.replace('.groovy','')] = Class.forName(className)
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
                    // Instantiate and use your classes
                    def utility = classesMap.Utility.newInstance("DEV")
                    utility.printEnv()

                    def helper = classesMap.Helper.newInstance("Ram")
                    helper.greet()
                }
            }
        }
    }
}
