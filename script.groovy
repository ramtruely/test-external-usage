def buildApp() {
    echo 'building the application...'
} 

def testApp() {
    echo 'testing the application...'
    echo 'its update bro..'
} 

def deployApp() {
    echo 'deplying the application...'
    echo "deploying version ${params.VERSION}"
} 

return this
