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
                bat 'mvn package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat "docker build -t ci-cd-demo:${env.BUILD_NUMBER} ."
            }
        }

        stage('Deploy with Docker Compose'){
            steps{
                bat 'docker compose down'
                bat 'docker compose up -d --build'
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