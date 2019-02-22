#!/usr/bin/env groovy

package org.foo;

// import static Constants.GITHUB_CREDENTIALS_ID;
class Deployer implements Serializable {
    def script
    def Deployer(script){
        this.script = script
    }

    def secrets = [
        [$class: 'VaultSecret', path: '', secretValues: [
            [$class: 'VaultSecretValue', envVar: 'testing', vaultKey: 'password'],
    ]]]

    def getsecrets(){
        try {
            // inside this block your credentials will be available as env variables
            script.wrap([$class: 'VaultBuildWrapper', vaultSecrets: secrets]) {
                script.echo "My secret is : ${testing}"  
            }       
        }catch(ex){
            script.echo ex.toString();
            script.echo ex.getMessage();               
        }

    }

}