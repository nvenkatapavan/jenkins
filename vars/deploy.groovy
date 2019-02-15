#!/usr/bin/env groovy

import org.foo;

def call(body) {
    echo "Start Deploy"
    def obj = new Deployer(script:this)
    obj.run()
    echo "Deployed"
    currentBuild.result = 'SUCCESS'
    return this
}