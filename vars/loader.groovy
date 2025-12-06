def loadHelper(script) {
    return new helper.MyHelper(script)
}

def loadUtility(script) {
    return new util.MyUtility(script)
}
return this
