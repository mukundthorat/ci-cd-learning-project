pipeline{
    agent any

    tools{
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {
        stage('checkout'){
            steps {
                checkout scm
            }
        }

        stage('build'){
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test'){
            steps {
                bat 'mvn test'
            }
        }

        stage('Package'){
            steps {
                bat 'mvn package'
            }
        }

        stage('Check Docker') {
            steps {
                bat 'docker ps'
            }
        }

    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }

        success {
            archiveArtifacts artifacts: 'target/*.jar',fingerprint: true
        }
    }
}