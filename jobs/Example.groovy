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
        string('SONAR_TOKEN', 'c9609518-8875-48a3-8069-6b92013d7d1d')
    }
    timeout {
      absolute(15)
    }
  }
  steps {
    shell(readFileFromWorkspace('sonar/sonar_netsdk60.sh'))
  }


}