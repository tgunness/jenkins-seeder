job('Example') {
  description 'SonarQube analysis'
  properties {
        githubProjectUrl 'https://github.com/tgunness/jenkins-seeder'
  }
  logRotator {
    numToKeep 20
  }
  label 'linux-docker'
  concurrentBuild false
  steps {
    batchFile('echo Hello World!')
  }
  scm {
    git {
      remote {
        url 'https://github.com/tgunness/jenkins-seeder.git'
      }
      branch 'refs/heads/main'
      credentialsId 'ccbuilds@careercruising.com'
    }
      
  }
}