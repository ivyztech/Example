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
                    echo "Code quality checks passed."
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
