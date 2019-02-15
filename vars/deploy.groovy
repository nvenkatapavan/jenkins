#!/usr/bin/env groovy

def call(body) {
    echo "Start Deploy"
    new org.foo.Deployer.getsecrets()
    echo "Deployed"
    currentBuild.result = 'SUCCESS'
    return this
}