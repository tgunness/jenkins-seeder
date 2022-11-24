pipeline {
    agent any 
    stages {
        stage('Seed jobs') {
            steps {
                jobDsl  targets: ['*.groovy'].join('\n')
            }
        }
    }
}