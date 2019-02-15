#!/usr/bin/env groovy

package org.foo;
import hudson.model.*
import java.io.File;
import jenkins.model.Jenkins;

// import static Constants.GITHUB_CREDENTIALS_ID;

class Deployer {
    int tries = 0
    Script script
    def jenkins = new Jenkins
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
   def run() {
        // inside this block your credentials will be available as env variables
        jenkins.wrap([$class: 'VaultBuildWrapper', configuration: configuration, vaultSecrets: secrets]) {
            script.echo ${testing}
        }    
    }    
}