#!/usr/bin/env groovy

// import org.foo.Deployer

def getsecrets(String secret, String key) {
    def secrets = [
        [$class: 'VaultSecret', path: "${secret}", secretValues: [
            [$class: 'VaultSecretValue', envVar: "${key}", vaultKey: "${key}"],
    ]]]
    return secrets
    wrap([$class: 'VaultBuildWrapper', vaultSecrets: secrets]) {
      return env."${key}"
    }
  // def bp = new Deployer(this)
  // bp.getsecrets()
}

def getsecrets1(String secret, String key){
    SECRET1    = vault path: "${secret}", key: "${key}"
    print SECRET1
}
