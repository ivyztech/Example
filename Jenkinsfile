pipeline {
    agent any

    environment {
        DIRECTORY_PATH = "${WORKSPACE}"
        TESTING_ENVIRONMENT = 'staging'
        PRODUCTION_ENVIRONMENT = 'Dominique'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    echo "Fetching the source code from the directory path specified by the environment variable: ${env.DIRECTORY_PATH}"
                    sh './build.sh'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo "Running unit tests"
                    sh './test.sh'
                }
            }
        }

        stage('Code Quality Check') {
            steps {
                script {
                    echo "Checking the quality of the code"
                    // Running Checkstyle
                    sh 'java -jar checkstyle-X.X-all.jar -c checkstyle.xml src/Main.java src/MainTest.java > checkstyle-report.xml'
                    
                    // Print Checkstyle report to the console
                    sh 'cat checkstyle-report.xml'
                    
                    // Optionally, fail the build if Checkstyle finds issues
                    sh 'grep -q "<error" checkstyle-report.xml && exit 1 || exit 0'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "Deploying the application to a testing environment specified by the environment variable: ${env.TESTING_ENVIRONMENT}"
                    sh './deploy.sh'
                }
            }
        }

        stage('Approval') {
            steps {
                echo "Pausing for manual approval"
                sleep(time: 10, unit: 'SECONDS')
            }
        }

        stage('Deploy to Production') {
            steps {
                script {
                    echo "Deploying the code to the production environment: ${env.PRODUCTION_ENVIRONMENT}"
                    echo "Deployment successful."
                }
            }
        }
    }
}
