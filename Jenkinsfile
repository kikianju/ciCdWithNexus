pipeline {
    agent any

    environment {
        IMAGE_NAME = "localhost:5000/ciCdWithNexusAndJenkins/codereviewbot"
        DOCKER_USERNAME = credentials('nexus-cred-username') // Jenkins에 등록된 Docker ID
        DOCKER_PASSWORD = credentials('nexus-cred-password') // Jenkins에 등록된 Docker Password
    }

    stages {
        stage('Clone') {
            steps {
                git credentialsId: 'github-ssh', url: 'git@github.com:kikianju/ciCdWithNexus.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${IMAGE_NAME}:latest")
                }
            }
        }

        stage('Login to Docker Registry') {
            steps {
                sh 'echo "$DOCKER_PASSWORD" | docker login http://localhost:5000 -u $DOCKER_USERNAME --password-stdin'
            }
        }

        stage('Push to Nexus Registry') {
            steps {
                script {
                    docker.image("${IMAGE_NAME}:latest").push()
                }
            }
        }
    }
}
