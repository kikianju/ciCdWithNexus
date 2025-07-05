pipeline {
    agent any

    environment {
        IMAGE_NAME = "host.docker.internal:5001/cicdwithnexusandjenkins/codereviewbot"
    }

    stages {
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
                    docker.withRegistry('http://host.docker.internal:5001', 'nexus-cred') {
                        docker.image("${IMAGE_NAME}:latest").push()
                    }
                }
            }
        }
    }
}
