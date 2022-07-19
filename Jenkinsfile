pipeline {
    agent any

    stages 
    {
        stage('Unit Test') 
        {
            steps 
            {
                echo 'Unit App'
            }
        }
        stage('Build') 
        {
            steps 
            {
                echo 'Build App'
            }
        }
        stage('Test') 
        {
            steps 
            {
                echo 'Test App'
            }
        }

        stage('Deploy') 
        {
            steps 
            {
                echo 'Deploy App'
            }
        }
    }

    post
    {
        always
        {
            emailext body: '''Hi 
            This is my first Jenkins pipeline.''', subject: 'SimplePipeline_1', to: 'automatesmb100@gmail.com'
        }

        failure
        {
            emailext body: '''Hi 
            This first Jenkins pipeline is failed due to some reason!.''', subject: 'SimplePipeline_1', to: 'automatesmb100@gmail.com'
        }
    }
}
