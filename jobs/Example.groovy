job('Example') {
  description("SonarQube analysis")
  concurrentBuild true
  steps {
    batchFile('echo Hello World!')
  }
}