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
                echo "Compiling..."
                sh "/usr/bin/sbt testOnly"
            }
        }
    }
}
