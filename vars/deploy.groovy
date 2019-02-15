#!/usr/bin/env groovy

import org.foo.Deployer

def call(Map config, Closure body) {
  config.debug = config.debug ?: false
  def logger = new OdsLogger(this, config.debug)
  def bp = new Deployer(this, config, logger)
  return bp.getsecrets(body)
}

return this