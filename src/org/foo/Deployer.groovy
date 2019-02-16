#!/usr/bin/env groovy

package org.foo;

// import static Constants.GITHUB_CREDENTIALS_ID;
class Deployer implements Serializable {
    def script
    def Deployer(script){
        this.script = script
    }
    // define the secrets and the env variables
    def secrets = [
        [$class: 'VaultSecret', path: 'secret/data/hello', secretValues: [
            [$class: 'VaultSecretValue', envVar: 'testing', vaultKey: 'mysecret'],
    ]]]
    // optional configuration, if you do not provide this the next higher configuration
    // (e.g. folder or global) will be used
    def configuration = [$class: 'VaultConfiguration',
                            vaultUrl: 'http://host.docker.internal:8200',
                            vaultCredentialId: 'vault-token']
    def getsecrets(){
        try {
            // inside this block your credentials will be available as env variables
            script.wrap([$class: 'VaultBuildWrapper', configuration: configuration, vaultSecrets: secrets]) {
                script.echo "hello"
                script.echo ${testing}   
                script.currentBuild.result = 'SUCCESS'
            }       
        }catch(ex){
            println(ex.toString());
            println(ex.getMessage());               
            script.currentBuild.result = 'FAILURE'
        }

    }

}