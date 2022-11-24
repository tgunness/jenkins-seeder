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
  scm {
    git {
      remote {
        url 'https://github.com/tgunness/jenkins-seeder.git'
        credentials 'github_ccbuilds'
      }
      branch 'refs/heads/main'
    }      
  }
  triggers {
    githubPush()
  }
  wrappers {
        credentialsBinding {
            string('GITHUB_TOKEN', 'github_ccbuilds')
            string('SONAR_TOKEN', 'jenkins-sonarqube-token')
        }
  }





  steps {
    batchFile('echo Hello World!')
  }


}