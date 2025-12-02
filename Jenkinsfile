pipeline {
    agent any

    tools {
        maven 'Maven-3.9.11'   // Make sure you configured this under "Global Tool Configuration"
        jdk 'JDK21'          // Replace with your installed JDK name
    }

    environment {
        // You can set variables here if needed
        DEPLOY_PATH = "C:\\Deployments"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/dhanushreesivakumar/Devops.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        // stage('Deploy') {
        //     steps {
        //         bat 'deploy_app.bat'
        //     }
        // }
    }

    post {
        success {
            echo '✅ Build, Test, and Deploy stages completed successfully!'
        }
        failure {
            echo '❌ Build failed. Please check the logs.'
        }
    }
}
