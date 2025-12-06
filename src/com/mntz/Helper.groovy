package com.mntz

class Helper implements Serializable {
    String name

    Helper(String name) {
        this.name = name
    }

    def doSomethingElse() {
        return "Helper processing for: ${name}"
    }
}
