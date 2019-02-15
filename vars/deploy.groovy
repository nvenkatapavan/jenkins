#!/usr/bin/env groovy

import org.foo.Deployer

def call() {
  def bp = new Deployer(this)
  bp.getsecrets()
  return this
}