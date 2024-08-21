pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/ivyztech/Example.git'
        TESTING_ENVIRONMENT = 'staging'
        PRODUCTION_ENVIRONMENT = 'Dominique Villafuerte'
    }

    stages {
        stage('Clone Repository') {
            steps {
                script {
                    echo "Cloning the repository from ${env.REPO_URL}"
                    git branch: 'main', url: "${env.REPO_URL}"
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Compiling the code and generating any necessary artifacts"
                    bat 'build.bat' // Use batch script instead of bash script
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo "Running unit tests"
                    bat 'test.exe' // Run the compiled test executable
                }
            }
        }

        stage('Code Quality Check') {
            steps {
                echo "Checking the quality of the code"
                // Add code quality check here, e.g., running a static analysis tool
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "Deploying the application to a testing environment specified by the environment variable: ${env.TESTING_ENVIRONMENT}"
                    bat 'deploy.bat' // Use batch script instead of bash script
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
                    bat 'deploy.bat' // Reuse the batch script for deployment
                }
            }
        }
    }
}
