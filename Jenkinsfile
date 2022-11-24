pipeline {
    agent any 
    stages {
        stage('Seed jobs') {
            steps {
                jobDsl  targets: ['jobs/*.groovy'].join('\n')
            }
        }
    }
}