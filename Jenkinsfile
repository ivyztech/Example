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
                    echo "Installing g++"
                    sh 'sudo apt-get update && sudo apt-get install -y g++'
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    echo "Compiling the code and generating any necessary artifacts"
                    sh 'g++ -o main main.cpp'   // Compile the main application
                    sh 'g++ -o test test.cpp'   // Compile the test application
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo "Running unit tests"
                    sh './test'   // Run the test executable
                }
            }
        }

        stage('Code Quality Check') {
            steps {
                script {
                    echo "Running code quality checks"
                    // Install cppcheck if not available, only required on the first run
                    sh 'which cppcheck || sudo apt-get install -y cppcheck'
                    
                    // Run cppcheck on the C++ source files
                    sh 'cppcheck --enable=all --inconclusive --error-exitcode=1 .'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "Deploying the application to a testing environment specified by the environment variable: ${env.TESTING_ENVIRONMENT}"
                    sh 'bash deploy.sh'  // Replace with shell command
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
                    sh 'bash deploy.sh'  // Replace with shell command
                }
            }
        }
    }
}
