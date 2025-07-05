pipeline {
    agent any

    options {
        skipDefaultCheckout()
    }

    environment {
        IMAGE_NAME = "localhost:5001/cicdwithnexusandjenkins/codereviewbot"
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
                    docker.withRegistry('http://localhost:5001', 'nexus-cred') {
                        docker.image("${IMAGE_NAME}:latest").push()
                    }
                }
            }
        }
    }
}
