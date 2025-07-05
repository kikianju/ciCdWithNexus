FROM jenkins/jenkins:lts

USER root

# Docker CLI 설치
RUN apt-get update && \
    apt-get install -y docker.io && \
    usermod -aG docker jenkins

USER jenkins
