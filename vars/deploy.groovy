#!/usr/bin/env groovy

import org.foo.Deployer

def call() {
    stage('Deploy') {
       steps {
            def bp = new Deployer(this)
            bp.getsecrets()
            return this           
       }
    }    
}