def libs
def config

pipeline {
    agent any
    stages {
        stage('init') {
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

        stage('use-src-classes') {
            steps {
                script {
                    // get instances from loader (no classloader usage)
                    def util = libs.loader.get('Utility', 'DEV')
                    util.printEnv()
                    echo util.getEnvInfo()

                    def helper = libs.loader.get('Helper', 'Ram')
                    helper.greet()
                    echo helper.getUserInfo()
                }
            }
        }
    }
}
