pipeline {
    agent any

    environment {
        IMAGE_NAME = 'dockergodown/userdetailservice'
        IMAGE_TAG = "latest"
    }

    tools {
        maven 'Maven_3.8.8'  // Adjust as needed
        jdk 'JDK_17'         // Adjust according to your setup
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                }
            }
        }

        stage('Push Docker Image') {
            when {
                expression { return env.BRANCH_NAME == 'main' || env.BRANCH_NAME == 'master' }
            }
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker push ${IMAGE_NAME}:${IMAGE_TAG}
                        docker logout
                    '''
                }
            }
        }
    }

    post {
        success {
            echo "Build and Docker image creation successful: ${IMAGE_NAME}:${IMAGE_TAG}"
        }
        failure {
            echo "Build failed!"
        }
    }
}
