job('example') {
  description("Test project for sonar analysis")
  concurrentBuild(false)
  steps {
    batchFile('echo Hello World!')
  }
}