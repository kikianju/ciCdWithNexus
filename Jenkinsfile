pipeline {
    agent any

    environment {
        IMAGE_NAME = "localhost:5000/cicdwithnexusandjenkins/codereviewbot"
    }

    stages {
        stage('Clone') {
            steps {
                // GitHub SSH 키 설정된 credentialsId 사용
                git branch: 'main', credentialsId: 'github-ssh', url: 'git@github.com:kikianju/ciCdWithNexus.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${IMAGE_NAME}:latest")
                }
            }
        }

        stage('Push to Nexus Registry') {
            steps {
                script {
                    docker.withRegistry('http://localhost:5000', 'nexus-cred') {
                        docker.image("${IMAGE_NAME}:latest").push()
                    }
                }
            }
        }
    }
}
