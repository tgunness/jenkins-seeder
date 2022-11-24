job('Example') {
  description("SonarQube analysis")
  concurrentBuild {
    allowConcurrentBuild false
  }
  steps {
    batchFile('echo Hello World!')
  }
}