pipeline {
    agent any

    options {
        // 기본 SCM 체크아웃 생략 (필요 시 직접 checkout stage 작성 가능)
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
