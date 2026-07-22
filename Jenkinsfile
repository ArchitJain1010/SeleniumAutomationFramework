pipeline {
    agent any

    parameters {
        choice(name: 'ENVIRONMENT',
               choices: ['DEV', 'QA', 'UAT', 'PROD'],
               description: 'Select Environment')
    }

    environment {
        COMPANY = "OpenAI Learning"
        PROJECT = "Jenkins Mastery"
    }

    stages {

        stage('Print Details') {
            steps {
                echo "Company: ${env.COMPANY}"
                echo "Project: ${env.PROJECT}"
                echo "Job Name: ${env.JOB_NAME}"
                echo "Build Number: ${env.BUILD_NUMBER}"
                echo "Workspace: ${env.WORKSPACE}"
                echo "Selected Environment: ${params.ENVIRONMENT}"
            }
        }
    }
}