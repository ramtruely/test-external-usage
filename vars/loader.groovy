// vars/loader.groovy
// sandbox-safe loader that uses load(...) on src files and returns instances

def get(String shortName, Object... args) {
    // map simple names to file paths (adjust if you use other naming)
    def map = [
        'Utility': 'src/org/my/example/MyHelper.groovy',
        'Helper' : 'src/org/my/example/MyUtility.groovy'
    ]

    def path = map[shortName]
    if (!path) {
        error "Unknown class ${shortName}"
    }

    // load returns the script object (because each src returns this)
    def scriptObj = load(path)

    // call its factory 'create' with args
    if (args?.length > 0) {
        return scriptObj.create(*args)
    } else {
        return scriptObj.create()
    }
}

return this
