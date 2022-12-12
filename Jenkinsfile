pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                echo "Compiling..."
                sh "/usr/bin/sbt compile"
            }
        }
        stage('Test') {
            steps {
                echo "Testing..."
                sh "/usr/bin/sbt testOnly"
            }
        }
        stage('Package') {
            steps {
                echo "Compiling..."
                sh "/usr/bin/sbt package"
            }
        }
        stage('Finish') {
            steps {
                echo "Finished..."
            }
        }
    }
}
