job('Example') {
  description("SonarQube analysis")
  concurrentBuild false
  steps {
    batchFile('echo Hello World!')
  }
}