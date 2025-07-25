pipeline {
    agent any

    /* options {
               disableConcurrentBuilds()  // Prevents @2 folders
             } */


    /* environment {
        IMAGE_NAME = 'dockergodown/userdetailservice'
        IMAGE_TAG = "latest"
    } */

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

        stage('AWS') {
                    agent {
                        docker {
                            image 'amazon/aws-cli'
                            args "--entrypoint=''"
                        }
                    }
                    steps {
                        withCredentials([usernamePassword(credentialsId: 'awscred', passwordVariable: 'AWS_SECRET_ACCESS_KEY', usernameVariable: 'AWS_ACCESS_KEY_ID')]) {
                           sh '''
                             aws --version
                             aws s3 ls
                             aws s3 cp $WORKSPACE/target/ s3://my-image-storage-bucket-2025/jars/ --recursive --exclude "*" --include "*.jar"
                            '''
                         }

                    }
                }

       /*  stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                    def branch = sh(script: 'git rev-parse --abbrev-ref HEAD', returnStdout: true).trim()
                     env.BRANCH_NAME = branch
                     echo "Detected branch: ${env.BRANCH_NAME}"
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker push ${IMAGE_NAME}:${IMAGE_TAG}
                        docker logout
                    '''
                }
            }
        }*/
    }

   /*  post {
        success {
            echo "Build and Docker image creation successful: ${IMAGE_NAME}:${IMAGE_TAG}"
        }
        failure {
            echo "Build failed!"
        }
    }  */
}
