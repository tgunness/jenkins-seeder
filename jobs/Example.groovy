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
    shell('''
    #!/bin/bash -ex
    PROJECT_NAME="Xello.Feed.API"
    SONAR_PROJECT_KEY="Xello.Feed.API"
    DOCKER_TEMPLATE="dockerfile_netsdk60_sonarqube_jenkins_ci"
    IMG_NAME=$(echo "${PROJECT_NAME}.Sonar" | tr '[:upper:]' '[:lower:]')
    curl -s -H "Authorization: token ${GITHUB_TOKEN}" \
    "https://raw.githubusercontent.com/CareerCruising/docker/master/templates/${DOCKER_TEMPLATE}" > ${DOCKER_TEMPLATE}
    docker build \
    -t ${IMG_NAME}:${BUILD_NUMBER} \
    -f ./${DOCKER_TEMPLATE} \
    --build-arg SONAR_URL=${SONAR_URL} \
    --build-arg SONAR_TOKEN=${SONAR_TOKEN} \
    --build-arg SONAR_PROJECT_KEY=${SONAR_PROJECT_KEY} \
    --build-arg PROJECT_NAME=${PROJECT_NAME} .''')
  }
}