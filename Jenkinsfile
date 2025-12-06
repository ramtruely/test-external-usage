def gv

// Read parameters from YAML
def config = readYaml file: 'parameters.yaml'

// Convert YAML into Jenkins parameters
def paramList = []
config.parameters.each { name, map ->
    if (map.type == 'choice') {
        paramList << choice(name: name, choices: map.values.join('\n'))
    }
    if (map.type == 'boolean') {
        paramList << booleanParam(name: name, defaultValue: map.default)
    }
}

// Register parameters (needed for multibranch!)
properties([
    parameters(paramList)
])

pipeline {
    agent any

    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("build") {
            steps {
                script {
                    gv.buildApp(params.VERSION)
                }
            }
        }

        stage("test") {
            when {
                expression { params.executeTests }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    gv.deployApp(params.VERSION)
                }
            }
        }
    }
}
