#!/usr/bin/env groovy

def call(body) {
    echo "Start Deploy"
    def obj = new org.foo.Deployer()
    obj.run()
    echo "Deployed"
    currentBuild.result = 'SUCCESS'
    return this
}