job('Example') {
  description 'SonarQube analysis'
  properties {
        githubProjectUrl 'https://github.com/tgunness/jenkins-seeder'
  }
  logRotator {
    numToKeep 20
  }
  label('linux-docker')
  concurrentBuild false
  steps {
    batchFile('echo Hello World!')
  }
}