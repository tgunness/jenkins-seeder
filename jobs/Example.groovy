job('Example') {
  description 'SonarQube analysis'
  properties {
        githubProjectUrl 'https://github.com/tgunness/jenkins-seeder'
  }
  logRotator {
    numToKeep 20
  }
  concurrentBuild false
  steps {
    batchFile('echo Hello World!')
  }
}