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
                    git branch: 'master', url: "${env.REPO_URL}"
                }
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    echo "Installing Python (if not already installed)"
                    sh 'apt-get update'
                    sh 'apt-get install -y python3'
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "No build needed for Python"
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo "Running unit tests"
                    sh 'python3 test.py'   // Run the Python test script
                }
            }
        }

        stage('Code Quality Check') {
            steps {
                script {
                    echo "Running code quality checks"
                    sh 'pip3 install pylint'   // Install pylint
                    sh 'pylint main.py'        // Run pylint on main.py
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "Deploying the application to a testing environment specified by the environment variable: ${env.TESTING_ENVIRONMENT}"
                    sh 'bash deploy.sh'  // Run deployment script (if applicable)
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
                    sh 'bash deploy.sh'  // Run deployment script (if applicable)
                }
            }
        }
    }
}
