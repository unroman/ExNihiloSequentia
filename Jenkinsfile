pipeline {
    agent any

    stages {
        stage('Clean') {
            steps{
                sh 'chmod +x gradlew'
                sh './gradlew clean'
            }
        }
        stage('Build, Test, Package') {
            steps {
                sh './gradlew build'
            }
        }
        stage('Deploy') {
            when {
                branch '1.16-dev'
            }
            steps {
                sh './create-release.sh'
                sh './gradlew curseforge400012'
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'build/libs/*.jar'
        }
    }
}