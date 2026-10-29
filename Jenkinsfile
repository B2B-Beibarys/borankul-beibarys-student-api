pipeline {
    agent any

    tools {
        jdk 'jdk21'
    }

    environment {
        STUDENT_FULL_NAME = 'Beibarys Borankul'
        IMAGE_NAME        = 'borankul-beibarys-student-api'
        IMAGE_TAG         = 'v1.0-borankul-beibarys'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Student: ${STUDENT_FULL_NAME}"
                checkout scm
                sh 'git log -1 --oneline'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean bootJar -x test --no-daemon'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test --no-daemon'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'build/test-results/test/*.xml'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .'
            }
        }

        stage('Verify') {
            steps {
                sh 'docker image inspect ${IMAGE_NAME}:${IMAGE_TAG} > /dev/null'
                sh 'docker images ${IMAGE_NAME}'
                echo "Image ${IMAGE_NAME}:${IMAGE_TAG} exists. Built for ${STUDENT_FULL_NAME}"
            }
        }
    }

    post {
        success { echo "Pipeline SUCCESS for ${STUDENT_FULL_NAME}" }
        failure { echo "Pipeline FAILED for ${STUDENT_FULL_NAME}" }
    }
}
